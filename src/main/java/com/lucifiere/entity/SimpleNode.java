package com.lucifiere.entity;

/**
 * 单向节点
 *
 * @author user
 */
public class SimpleNode {

    public int val;

    public SimpleNode next;

    public SimpleNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + ">>" + next.val;
        } else {
            return val + "";
        }
    }

}