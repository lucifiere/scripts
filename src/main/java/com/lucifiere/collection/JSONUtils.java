package com.lucifiere.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class JSONUtils {

    public static boolean isJsonArrayContain(JSONArray j1, JSONArray j2) {
        if (Objects.isNull(j1) || Objects.isNull(j2)) {
            throw new IllegalArgumentException();
        }
        class Wrapper {

            public final JSONObject o;

            public Wrapper(Object obj) {
                if (obj instanceof JSONObject) {
                    this.o = (JSONObject) obj;
                    return;
                }
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Wrapper) {
                    Wrapper w2 = (Wrapper) obj;
                    return Objects.equals(w2.o.get("id"), this.o.get("id"));
                }
                return false;
            }

        }
        List<Wrapper> l1 = j1.stream().map(Wrapper::new).collect(Collectors.toList());
        List<Wrapper> l2 = j2.stream().map(Wrapper::new).collect(Collectors.toList());
        return l1.containsAll(l2);
    }

    public static boolean isJsonArrayContain0(JSONArray j1, JSONArray j2, String... fields) {
        if (Objects.isNull(j1) || Objects.isNull(j2) || Objects.isNull(fields)) {
            throw new IllegalArgumentException();
        }
        class Wrapper {

            public final JSONObject o;

            public Wrapper(Object obj) {
                if (obj instanceof JSONObject) {
                    this.o = (JSONObject) obj;
                    return;
                }
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Wrapper) {
                    Wrapper w2 = (Wrapper) obj;
                    for (String field : fields) {
                        if (!Objects.equals(w2.o.get(field), this.o.get(field))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

        }
        List<Wrapper> l1 = j1.stream().map(Wrapper::new).collect(Collectors.toList());
        List<Wrapper> l2 = j2.stream().map(Wrapper::new).collect(Collectors.toList());
        boolean res = l1.containsAll(l2);
        if (!res) {
            System.out.println(String.format("比较失败！expected={%s}；actual={%s}", printFields(j1, fields), printFields(j2, fields)));
        }
        return res;
    }

    private static String printFields(JSONArray j, String... fields) {
        return j.stream().map(o -> {
            List<String> printFields = Arrays.stream(fields).map(f -> f + "->" + ((JSONObject) o).get(f)).collect(Collectors.toList());
            return Joiner.on(",").join(printFields) + " |";
        }).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String s1 = "[{\"code\":\"885834865\",\"bizType\":\"未消费退2321款结算\",\"addTime\":1590940800,\"poiName\":\"深圳市_三十三间堂（天利店）\",\"dealId\":401263904,\"contractNumber\":\"DCKJ05922002004801\",\"dealName\":\"20200316_嘉华大酒店季花日本料理餐厅[1.2元][401263904]\",\"partner\":0,\"contractId\":\"b84f72e8-c9f3-4352-8cdb-bd9a8a4b6a3a\",\"useTime\":0,\"contractName\":\"分门店付款-钱包(团购)\",\"poiId\":6401,\"refund\":554.22},{\"code\":\"953523523\",\"bizType\":\"已消费退款结算\",\"addTime\":1590940800,\"poiName\":\"深圳市_三十三间堂（天利店）\",\"dealId\":401263904,\"contractNumber\":\"DCKJ05922002004801\",\"dealName\":\"20200316_嘉华大酒店季花日本料理餐厅[1.2元][401263904]\",\"partner\":0,\"contractId\":\"b84f72e8-c9f3-4352-8cdb-bd9a8a4b6a3a\",\"useTime\":1590389528,\"contractName\":\"分门店付款-钱包(团购)\",\"poiId\":6401,\"refund\":1.11}]";
        String s2 = "[{\"code\":\"885834865\",\"bizType\":\"未消费退款结算\",\"addTime\":1590940800,\"poiName\":\"深圳市_三十三间堂（天利店）\",\"dealId\":401263904,\"contractNumber\":\"DCKJ05922002004801\",\"dealName\":\"20200316_嘉华大酒店季花日本料理餐厅[1.2元][401263904]\",\"partner\":0,\"contractId\":\"b84f72e8-c9f3-4352-8cdb-bd9a8a4b6a3a\",\"useTime\":0,\"contractName\":\"分门店付款-钱包(团购)\",\"poiId\":6401,\"refund\":554.22},{\"code\":\"953523523\",\"bizType\":\"已消费退款结算\",\"addTime\":1590940800,\"poiName\":\"深圳市_三十三间堂（天利店）\",\"dealId\":401263904,\"contractNumber\":\"DCKJ05922002004801\",\"dealName\":\"20200316_嘉华大酒店季花日本料理餐厅[1.2元][401263904]\",\"partner\":0,\"contractId\":\"b84f72e8-c9f3-4352-8cdb-bd9a8a4b6a3a\",\"useTime\":1590389528,\"contractName\":\"分门店付款-钱包(团购)\",\"poiId\":6401,\"refund\":1.11}]";
        JSONArray j1 = JSON.parseArray(s1);
        JSONArray j2 = JSON.parseArray(s2);
        System.out.println(isJsonArrayContain0(j1, j2, "bizType", "refund"));
    }

}
