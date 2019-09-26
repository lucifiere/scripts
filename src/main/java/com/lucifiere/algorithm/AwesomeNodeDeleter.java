package com.lucifiere.algorithm;

import com.lucifiere.entity.SimpleNode;

/**
 * 删除指定节点
 * 对于一个单向链表（头结点未知），删除其中一个节点
 * 难度：✨✨✨✨✨✨✨
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class AwesomeNodeDeleter {

    public static void main(String[] args) {
        SimpleNode head = MockUtils.mockSimpleLinkList();
        deleteNode(head.next.next);
    }

    private static void deleteNode(SimpleNode toBeDeleted) {
        toBeDeleted.next = toBeDeleted.next.next;
        toBeDeleted.next.val = toBeDeleted.next.next.val;
    }

}
