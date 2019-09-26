package com.lucifiere.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.LockSupport;

public class Phaser {

    /**
     * 阶段同步器的主状态：用一个64位数表示，不同的位数蕴含不同的信息
     * 0-15位：表示还没有完成本阶段的参与者数
     * 16-31位：全部参与者的计数
     * 32-62位：目前所处阶段
     * 63位：阶段同步器是否终止
     * <p>
     * Q：为啥要把这么多信息集中在一个long字段里？
     * A：旨在提高同步器性能，高效的对状态进行编解码、以及减小竞争窗口(空间)。
     */
    private volatile long state;

    /**
     * 参与者线程相关信息
     * ManagedBlocker的作用：当包含ForkJoinWorkerThread的QNode阻塞的时候，ForkJoinPool内部会增加一个工作线程来保证并行度
     */
    static final class QNode implements ForkJoinPool.ManagedBlocker {

        final java.util.concurrent.Phaser phaser;
        final int phase;
        final boolean interruptible;
        final boolean timed;
        boolean wasInterrupted;
        long nanos;
        /**
         * 超时
         */
        final long deadline;
        /**
         * 参与者
         */
        volatile Thread thread;
        /**
         * 向下一个QNode的域
         */
        QNode next;

        QNode(java.util.concurrent.Phaser phaser, int phase, boolean interruptible,
              boolean timed, long nanos) {
            this.phaser = phaser;
            this.phase = phase;
            this.interruptible = interruptible;
            this.nanos = nanos;
            this.timed = timed;
            this.deadline = timed ? System.nanoTime() + nanos : 0L;
            thread = Thread.currentThread();
        }

        /**
         * 判断是否需要解除阻塞
         *
         * @return 是否需要解除阻塞
         */
        @Override
        public boolean isReleasable() {
            // 没有线程参与，解除阻塞
            if (thread == null) {
                return true;
            }
            // phaser的阶段值不相等，解除阻塞
            if (phaser.getPhase() != phase) {
                thread = null;
                return true;
            }
            // 被中断，解除阻塞
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
            if (wasInterrupted && interruptible) {
                thread = null;
                return true;
            }
            // 等待超时，解除阻塞
            if (timed) {
                if (nanos > 0L) {
                    nanos = deadline - System.nanoTime();
                }
                if (nanos <= 0L) {
                    thread = null;
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean block() {
            if (isReleasable()) {
                return true;
            } else if (!timed) {
                LockSupport.park(this);
            } else if (nanos > 0L) {
                LockSupport.parkNanos(this, nanos);
            }
            return isReleasable();
        }
    }

}
