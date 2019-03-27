package com.lucifiere.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略上下文
 *
 * @author XD.Wang
 * @date 2019/1/23.
 */
public class StrategyContext {

    private Strategy curStrategy;

    private static final Map<String, Strategy> CAL_STRATEGY_MAP = new HashMap<>();

    static {
        CAL_STRATEGY_MAP.put("", null);
    }

    public StrategyContext(Strategy curStrategy) {
        this.curStrategy = curStrategy;
    }

    public StrategyContext(String type) {
        this.curStrategy = CAL_STRATEGY_MAP.get(type);
    }

    public static Strategy getStrategy(String promoType) {
        return CAL_STRATEGY_MAP.get(promoType);
    }

}
