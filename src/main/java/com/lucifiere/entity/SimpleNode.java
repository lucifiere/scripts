package com.lucifiere.entity;

public class SimpleNode {

    public int val;

    public SimpleNode next;

    public SimpleNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + ">>" + next.val;
    }

}