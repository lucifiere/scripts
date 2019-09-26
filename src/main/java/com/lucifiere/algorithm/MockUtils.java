package com.lucifiere.algorithm;

import com.lucifiere.entity.SimpleNode;

public class MockUtils {

    public static SimpleNode mockSimpleLinkList() {
        SimpleNode node1 = new SimpleNode(1);
        SimpleNode node2 = new SimpleNode(2);
        SimpleNode node3 = new SimpleNode(3);
        SimpleNode node4 = new SimpleNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

}
