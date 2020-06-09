package com.lucifiere.sxh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.SetUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * @author created by XD.Wang
 * Date 2020/6/9.
 */
public class Demo {

    public static void main(String[] args) {
        Map<String, JSONObject> map1 = new HashMap<>();
        map1.put("1", JSON.parseObject("{\"actType\":1,\"bizCost\":20.0,\"bizRefund\":0.0,\"buyPrice\":114.22,\"clearDateTime\":1591632000,\"couponCode\":\"5325236562\",\"dateTime\":1591632000,\"dealId\":401263904,\"orderId\":0,\"originalPrice\":250.0,\"poiId\":6401,\"salePrice\":134.22,\"setActType\":true,\"setBizCost\":true,\"setBizRefund\":true,\"setBuyPrice\":true,\"setClearDateTime\":true,\"setCouponCode\":true,\"setDateTime\":true,\"setDealId\":true,\"setOrderId\":true,\"setOriginalPrice\":true,\"setPoiId\":true,\"setSalePrice\":true,\"setSettlementAmount\":true,\"settlementAmount\":94.22}"));
        map1.put("2", JSON.parseObject("{\"actType\":2,\"bizCost\":20.0,\"bizRefund\":0.0,\"buyPrice\":114.22,\"clearDateTime\":1591632000,\"couponCode\":\"5325236562\",\"dateTime\":1591632000,\"dealId\":401263904,\"orderId\":0,\"originalPrice\":250.0,\"poiId\":6401,\"salePrice\":134.22,\"setActType\":true,\"setBizCost\":true,\"setBizRefund\":true,\"setBuyPrice\":true,\"setClearDateTime\":true,\"setCouponCode\":true,\"setDateTime\":true,\"setDealId\":true,\"setOrderId\":true,\"setOriginalPrice\":true,\"setPoiId\":true,\"setSalePrice\":true,\"setSettlementAmount\":true,\"settlementAmount\":94.22}"));
        Map<String, JSONObject> map2 = new HashMap<>();
        map2.put("2", JSON.parseObject("{\"actType\":2,\"bizCost\":20.0,\"bizRefund\":0.0,\"buyPrice\":114.22,\"clearDateTime\":1591632000,\"couponCode\":\"5325236562\",\"dateTime\":1591632000,\"dealId\":401263904,\"orderId\":0,\"originalPrice\":250.0,\"poiId\":6401,\"salePrice\":134.22,\"setActType\":true,\"setBizCost\":true,\"setBizRefund\":true,\"setBuyPrice\":true,\"setClearDateTime\":true,\"setCouponCode\":true,\"setDateTime\":true,\"setDealId\":true,\"setOrderId\":true,\"setOriginalPrice\":true,\"setPoiId\":true,\"setSalePrice\":true,\"setSettlementAmount\":true,\"settlementAmount\":94.22}"));
        map2.put("1", JSON.parseObject("{\"actType\":3,\"bizCost\":20.0,\"bizRefund\":0.0,\"buyPrice\":114.22,\"clearDateTime\":1591632000,\"couponCode\":\"5325236562\",\"dateTime\":1591632000,\"dealId\":401263904,\"orderId\":0,\"originalPrice\":250.0,\"poiId\":6401,\"salePrice\":134.22,\"setActType\":true,\"setBizCost\":true,\"setBizRefund\":true,\"setBuyPrice\":true,\"setClearDateTime\":true,\"setCouponCode\":true,\"setDateTime\":true,\"setDealId\":true,\"setOrderId\":true,\"setOriginalPrice\":true,\"setPoiId\":true,\"setSalePrice\":true,\"setSettlementAmount\":true,\"settlementAmount\":94.22}"));
        System.out.println(isMapSame(map1, map2, (v1, v2) -> {
            return Objects.equals(v1.getInteger("actType"), v2.getInteger("actType")) && Objects.equals(v1.getLong("clearDateTime"), v2.getLong("clearDateTime"));
        }));
    }

    public static <K, V> boolean isMapSame(Map<K, V> m1, Map<K, V> m2, BiFunction<V, V, Boolean> comparator) {
        if (MapUtils.isEmpty(m1) && MapUtils.isEmpty(m2)) {
            return true;
        }
        if (MapUtils.isEmpty(m1) || MapUtils.isEmpty(m2)) {
            return false;
        }
        if (m1.size() != m2.size()) {
            return false;
        }
        if (!SetUtils.isEqualSet(m1.keySet(), m2.keySet())) {
            return false;
        }
        for (K key : m1.keySet()) {
            V v1 = m1.get(key);
            V v2 = m2.get(key);
            boolean isEqual = comparator.apply(v1, v2);
            if (!isEqual) {
                return false;
            }
        }
        return true;
    }

}
