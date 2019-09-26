package com.lucifiere.algorithm;

import com.lucifiere.entity.SimpleNode;

/**
 * MOCK数据
 *
 * @author user
 */
public class MockUtils {

    public static SimpleNode mockSimpleLinkList(Integer... mockData) {
        SimpleNode head = new SimpleNode(mockData[0]);
        SimpleNode cur = head;
        for (int i = 1; i < mockData.length; i++) {
            SimpleNode newOne = new SimpleNode(mockData[i]);
            cur.next = newOne;
            cur = newOne;
        }
        return head;
    }

}
