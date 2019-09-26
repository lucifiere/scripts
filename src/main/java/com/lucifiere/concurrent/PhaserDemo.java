package com.lucifiere.concurrent;

import org.apache.commons.lang.math.RandomUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * 阶段器
 *
 * @author XD.Wang
 * @date 2019/4/18.
 */
public class PhaserDemo implements Runnable {

    private Phaser phaser;

    private String name;

    public PhaserDemo(Phaser phaser, String name) {
        this.name = name;
        this.phaser = phaser;
        System.out.println(this.name + "调用register方法将当前线程注册到阶段同步器");
        phaser.register();
    }

    /**
     * 第一阶段
     */
    private boolean phase1() {
        boolean flag = RandomUtils.nextBoolean();
        long ts = org.apache.commons.lang3.RandomUtils.nextLong(1000L, 3000L);
        try {
            Thread.sleep(ts);
        } catch (InterruptedException e) {
            phaser.arriveAndDeregister();
            return false;
        }
        if (flag) {
            System.out.println(this.name + "第一阶段执行成功，调用arriveAndAwaitAdvance方法等待其它线程也执行成功");
            phaser.arriveAndAwaitAdvance();
            return true;
        } else {
            System.out.println(this.name + "第一阶段执行失败，调用arriveAndDeregister方法退出阶段同步器");
            phaser.arriveAndDeregister();
            return false;
        }
    }

    /**
     * 第二阶段
     */
    private void phase2() {
        long ts = org.apache.commons.lang3.RandomUtils.nextLong(3000L, 5000L);
        try {
            Thread.sleep(ts);
            System.out.println(this.name + "第二阶段执行成功，调用arriveAndAwaitAdvance方法等待其它线程也执行成功");
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            System.out.println(this.name + "第二阶段执行失败，调用arriveAndDeregister方法退出阶段同步器");
            phaser.arriveAndDeregister();
        }
    }

    @Override
    public void run() {
        // 通知阶段同步器，开始执行任务
        phaser.arrive();
        // 执行第一阶段
        boolean flag = phase1();
        // 假设第一阶段成功了才能执行第二阶段
        if (flag) {
            phase2();
            // 通知阶段同步器，任务执行完成，调用arriveAndDeregister方法退出阶段同步器
            phaser.arriveAndDeregister();
        }
    }


    public static void main(String[] args) {
        System.out.println("创建一个阶段同步器");
        Phaser phaser = new Phaser();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new PhaserDemo(phaser, "player1"));
        executorService.submit(new PhaserDemo(phaser, "player2"));
        executorService.submit(new PhaserDemo(phaser, "player3"));
        executorService.shutdown();
    }

}
