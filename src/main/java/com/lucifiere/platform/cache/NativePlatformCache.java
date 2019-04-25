package com.lucifiere.platform.cache;

import com.lucifiere.platform.anotation.Ability;
import com.lucifiere.platform.anotation.Domain;
import com.lucifiere.platform.defination.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 缓存工具
 * 平台扩展的本地缓存
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
public class NativePlatformCache implements PlatformCache {

    private final ConcurrentMap<String, DomainDefinition> DOMAIN_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, AbilityDefinition> ABILITY_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, ExtDefinition> EXTENSION_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, BundleDefinition> BUNDLE_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, TemplateDefinition> TEMPLATE_CACHE = new ConcurrentHashMap<>();

    @Override
    public DomainDefinition createDomainDefinitionCache(Domain domain) {
        DomainDefinition domainSpec = getDomainDefinition(domain.code());
        if (null != domainSpec) {
            return domainSpec;
        }
        return putDomainDefinition(domain.code(), DomainDefinition.of(domain.nameSpace(), domain.code(), domain.name(), domain.desc()));
    }


    @Override
    public AbilityDefinition createAbilityDefinitionCache(Ability ability, Class<?> targetClass, Definition definition) {
        String abilityCode = StringUtils.isEmpty(ability.code()) ? targetClass.getName() : ability.code();
        AbilityDefinition aDefinition = getAbilityDefinition(abilityCode);
        if (null == aDefinition) {
            aDefinition = AbilityDefinition.of(abilityCode, ability.name(), ability.desc());
            aDefinition.setClazz(targetClass);
            aDefinition.setDomain(definition.getCode());
            return putAbilityDefinition(abilityCode, aDefinition);
        }
        return aDefinition;
    }

    @Override
    public ExtDefinition getCachedExtDefinition(String extCode) {
        ExtDefinition extensionPointSpec = getExtDefinition(extCode);
        if (null != extensionPointSpec) {
            return extensionPointSpec;
        }

        for (DomainDefinition curDomain : getAllCacheDomainDefinition()) {
            extensionPointSpec = curDomain.getDomainExtByCode(extCode);
            if (null != extensionPointSpec) {
                break;
            }
        }
        if (null != extensionPointSpec) {
            return putExtDefinition(extCode, extensionPointSpec);
        }

        putExtDefinition(extCode, null);
        return null;
    }

    @Override
    public Collection<DomainDefinition> getAllCacheDomainDefinition() {
        return DOMAIN_CACHE.values();
    }

    @Override
    public boolean isDomainRegistered(String key) {
        if (key == null) {
            return false;
        }
        return DOMAIN_CACHE.containsKey(key);
    }

    /**
     * 设置域定义缓存
     *
     * @param key 缓存键
     * @param obj 缓存的域
     * @return 域
     */
    private DomainDefinition putDomainDefinition(String key, DomainDefinition obj) {
        DOMAIN_CACHE.put(key, obj);
        return obj;
    }

    /**
     * 设置域定义的缓存
     *
     * @param key 缓存键
     * @param obj 缓存的域
     * @return 域
     */
    private AbilityDefinition putAbilityDefinition(String key, AbilityDefinition obj) {
        ABILITY_CACHE.put(key, obj);
        return obj;
    }

    /**
     * 设置扩展点定义的缓存
     *
     * @param key 缓存键
     * @param obj 缓存的域
     * @return 域
     */
    private ExtDefinition putExtDefinition(String key, ExtDefinition obj) {
        EXTENSION_CACHE.put(key, obj);
        return obj;
    }

    /**
     * 获取域定义缓存
     *
     * @param key 缓存键
     * @return 域
     */
    private DomainDefinition getDomainDefinition(String key) {
        if (key == null) {
            return null;
        }
        return DOMAIN_CACHE.get(key);
    }

    /**
     * 获取能力定义缓存
     *
     * @param key 缓存键
     * @return 域
     */
    private AbilityDefinition getAbilityDefinition(String key) {
        if (key == null) {
            return null;
        }
        return ABILITY_CACHE.get(key);
    }

    /**
     * 获取扩展点定义缓存
     *
     * @param key 缓存键
     * @return 域
     */
    private ExtDefinition getExtDefinition(String key) {
        if (key == null) {
            return null;
        }
        return EXTENSION_CACHE.get(key);
    }

    public boolean isProductRegistered(String key) {
        if (key == null) {
            return false;
        }
        return BUNDLE_CACHE.containsKey(key);
    }

    private boolean isBundleDefinitionRegistered(String key) {
        if (key == null) {
            return false;
        }
        return BUNDLE_CACHE.containsKey(key);
    }

    public DomainDefinition getCacheDomainDefinition(String code) {
        return DOMAIN_CACHE.get(code);
    }

    private Collection<AbilityDefinition> getAllCacheAbilityDefinition() {
        return ABILITY_CACHE.values();
    }

    private Collection<ExtDefinition> getAllCacheExtDefinition() {
        return EXTENSION_CACHE.values();
    }

    private void doRemoveObjectDomainDefinition(String key) {
        DOMAIN_CACHE.remove(key);
    }

    private void doRemoveObjectAbilityDefinition(String key) {
        ABILITY_CACHE.remove(key);
    }

    private void doRemoveObjectExtDefinition(String key) {
        EXTENSION_CACHE.remove(key);
    }

    private void doClearAllCache() {
        DOMAIN_CACHE.clear();
        ABILITY_CACHE.clear();
        EXTENSION_CACHE.clear();
        TEMPLATE_CACHE.clear();
    }

    private BundleDefinition putBundleDefinition(String key, BundleDefinition obj) {
        BUNDLE_CACHE.put(key, obj);
        return obj;
    }

    private TemplateDefinition putTemplateDefinition(String key, TemplateDefinition obj) {
        TEMPLATE_CACHE.put(key, obj);
        return obj;
    }

    private TemplateDefinition getTemplateDefinitionEntry(String key) {
        if (key == null) {
            return null;
        }
        return TEMPLATE_CACHE.get(key);
    }

    private Collection<TemplateDefinition> getAllCacheTemplateDefinition() {
        return TEMPLATE_CACHE.values();
    }

    private Collection<BundleDefinition> getAllCacheBundleDefinition() {
        return BUNDLE_CACHE.values();
    }

}
