package com.lucifiere.platform.defination;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 能力定义
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Data
public class AbilityDefinition extends Definition {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbilityDefinition.class);

    private String domain;

    private Class<?> clazz;

    private Set<AbilityInstDefinition> abilityInstances = Sets.newConcurrentHashSet();

    private volatile Map<String, AbilityInstDefinition> abilityInstMap = Maps.newConcurrentMap();

    public void addAbilityInstance(AbilityInstDefinition definition) {
        addAbilityInstance0(definition);
        refreshAbilityInstMap();
    }

    public void addAbilityInstance(List<AbilityInstDefinition> definitions) {
        definitions.forEach(this::addAbilityInstance0);
        refreshAbilityInstMap();
    }

    public AbilityInstDefinition getAbilityInstByCode(String code) {
        return abilityInstMap.get(code);
    }

    public static AbilityDefinition of(String abilityCode, String abilityName, String abilityDesc) {
        AbilityDefinition abilitySpec = new AbilityDefinition();
        abilitySpec.setCode(abilityCode);
        abilitySpec.setName(abilityName);
        abilitySpec.setDesc(abilityDesc);
        return abilitySpec;
    }

    private void addAbilityInstance0(AbilityInstDefinition definition) {
        Assert.notNull(definition, "ability instance cant be null！");
        if (definition.in(abilityInstances)) {
            return;
        }
        definition.setAbility(this.getCode());
        abilityInstances.add(definition);
    }

    private void refreshAbilityInstMap() {
        this.abilityInstMap = Maps.newConcurrentMap();
        if (CollectionUtils.isEmpty(abilityInstances)) {
            return;
        }
        for (AbilityInstDefinition abilityInstance : abilityInstances) {
            if (StringUtils.isBlank(abilityInstance.getClassName())) {
                continue;
            }
            abilityInstMap.put(abilityInstance.getClassName(), abilityInstance);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof AbilityDefinition)) {
            return false;
        }
        AbilityDefinition target = (AbilityDefinition)obj;
        return StringUtils.equals(target.getCode(), this.getCode());
    }

    @Override
    public int hashCode() {
        if (StringUtils.isEmpty(this.getCode())) {
            return super.hashCode();
        }
        return this.getCode().hashCode();
    }

}
