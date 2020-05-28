package com.lucifiere.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
        return l1.containsAll(l2);
    }

    public static void main(String[] args) {
        String s1 = "[{\"id\":6401,\"name\":\"深圳市_三十三间堂（天利店）\",\"contractId\":null,\"contractName\":null,\"contractNumber\":null,\"details\":[{\"partner\":0,\"due\":-545.33,\"realPayed\":10.0,\"bizCost\":0.0,\"service\":0.0,\"refund\":555.33,\"cnt\":1,\"savingCardAmount\":0.0}]}]";
        String s2 = "[{\"id\":6401,\"details\":[{\"partner\":0,\"due\":-545.33,\"realPayed\":10,\"bizCost\":0,\"service\":0,\"refund\":555.33,\"cnt\":1,\"savingCardAmount\":0}]}]";
        JSONArray j1 = JSON.parseArray(s1);
        JSONArray j2 = JSON.parseArray(s2);
        System.out.println(isJsonArrayContain(j1, j2));
        System.out.println(isJsonArrayContain0(j1, j2, "id"));
    }

}
