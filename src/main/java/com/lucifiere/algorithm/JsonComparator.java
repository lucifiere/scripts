package com.lucifiere.algorithm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonComparator {

    public static void main(String[] args) {
        String json1 = "{\"end\":2,\"range\":{\"empty\":false},\"start\":1}";
        String json2 = "{\"end\":4,\"range\":{\"empty\":false},\"start\":7}";
        String json3 = "{\"end\":4,\"range\":{\"empty\":false},\"start\":7}";
        System.out.println("invoke compareByFastjson json1 and json2 -> " + compareByFastjson(json1, json2));
        System.out.println("invoke compareByFastjson json3 and json2 -> " + compareByFastjson(json3, json2));
    }

    private static boolean compareByFastjson(String json1, String json2) {
        JSONObject jo1 = JSON.parseObject(json1);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject jo2 = JSON.parseObject(json2);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return jo1.equals(jo2);
    }

}
