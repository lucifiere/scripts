package com.lucifiere.platform.defination;

import com.google.common.collect.Sets;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Set;

/**
 * 能力实例定义
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Data
public class AbilityInstDefinition extends Definition {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbilityInstDefinition.class);

    private String ability;

    private String className;

    private int priority;

    private Set<ExtDefinition> abilityExtSet = Sets.newConcurrentHashSet();

    public void addExt(ExtDefinition definition) {
        Assert.notNull(definition, "extension cant be null！");
        if (definition.in(abilityExtSet)) {
            return;
        }
        abilityExtSet.add(definition);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof AbilityInstDefinition)) {
            return false;
        }
        AbilityInstDefinition target = (AbilityInstDefinition) obj;
        return StringUtils.equals(target.getCode(), this.getCode());
    }

    @Override
    public int hashCode() {
        if (StringUtils.isNotEmpty(getCode())) {
            return getCode().hashCode();
        }
        return super.hashCode();
    }

}
