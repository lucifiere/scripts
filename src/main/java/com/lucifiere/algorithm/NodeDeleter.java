package com.lucifiere.algorithm;

import com.lucifiere.entity.SimpleNode;

/**
 * 删除指定节点
 * 对于一个单向链表（头结点已知），删除其中一个节点
 * 难度：✨✨
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class NodeDeleter {

    public static void main(String[] args) {
        SimpleNode head = MockUtils.mockSimpleLinkList(1, 2, 3, 4);
        traversing(null, head, 2);
    }

    private static void traversing(SimpleNode pre, SimpleNode cur, int value) {
        if (pre == null) {
            if (cur.val == value) {
                cur.next = null;
                return;
            }
            traversing(cur, cur.next, value);
        } else if (cur.val == value) {
            pre.next = cur.next;
        }
    }

}
