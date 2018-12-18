package com.chain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 链表管理
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
public class HandlerChainFactory {

    private static List<BaseHandler> demo = Lists.newArrayList();

    private static BaseHandler chaining(List<BaseHandler> handlers) {
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).nextIs(handlers.get(i + 1));
        }
        return handlers.get(0);
    }

    public static BaseHandler getDemoChain() {
        return chaining(demo);
    }

}
