package com.lucifiere.platform.cache;

import com.lucifiere.platform.anotation.Ability;
import com.lucifiere.platform.anotation.Domain;
import com.lucifiere.platform.defination.AbilityDefinition;
import com.lucifiere.platform.defination.Definition;
import com.lucifiere.platform.defination.DomainDefinition;
import com.lucifiere.platform.defination.ExtDefinition;

import java.util.Collection;

/**
 * 平台组件缓存
 *
 * @author XD.Wang
 * @date 2018/4/25.
 */
public interface PlatformCache {

    /**
     * 从缓存获取扩展点缓存
     *
     * @param extCode 扩展点名称
     * @return 扩展点
     */
    ExtDefinition getCachedExtDefinition(String extCode);

    /**
     * 获取所有域缓存
     *
     * @return 所有域缓存
     */
    Collection<DomainDefinition> getAllCacheDomainDefinition();

    /**
     * 创建domain本地缓存
     *
     * @param domain 域
     * @return 域定义
     */
    DomainDefinition createDomainDefinitionCache(Domain domain);

    /**
     * 创建ability本地缓存
     *
     * @param ability 能力
     * @return 域定义
     */
    AbilityDefinition createAbilityDefinitionCache(Ability ability, Class<?> targetClass, Definition definition);

    /**
     * 域是否已经缓存过
     *
     * @param domainCode 域编码
     * @return 是否已经缓存过
     */
    boolean isDomainRegistered(String domainCode);

}
