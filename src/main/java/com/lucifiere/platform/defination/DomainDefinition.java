package com.lucifiere.platform.defination;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lucifiere.platform.anotation.Domain;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 域定义
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Data
public class DomainDefinition extends Definition {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainDefinition.class);

    private String parentCode;

    private Set<AbilityDefinition> domainAbilities = Sets.newHashSet();

    private List<DomainServiceDefinition> domainServices = Lists.newArrayList();

    public static DomainDefinition of(String parentCode, String domainCode, String domainName, String domainDescription) {
        DomainDefinition definition = new DomainDefinition();
        if (StringUtils.isNotEmpty(parentCode)) {
            definition.setParentCode(parentCode);
        }
        definition.setCode(domainCode);
        definition.setName(domainName);
        definition.setDesc(domainDescription);
        return definition;
    }

    public static DomainDefinition of(String domainCode, String domainName, String domainDescription) {
        DomainDefinition definition = new DomainDefinition();
        definition.setCode(domainCode);
        definition.setName(domainName);
        definition.setDesc(domainDescription);
        return definition;
    }

    public static DomainDefinition of(Domain domain) {
        DomainDefinition definition = new DomainDefinition();
        definition.setCode(domain.code());
        definition.setName(domain.name());
        definition.setDesc(domain.desc());
        return definition;
    }

    public ExtDefinition getDomainExtByCode(String extCode) {
        return domainAbilities.stream()
                .flatMap(ability -> ability.getAbilityInstances().stream())
                .flatMap(inst -> inst.getAbilityExtSet().stream())
                .filter(ext -> Objects.equals(ext.getCode(), extCode))
                .findAny().orElse(null);
    }

}
