package com.lucifiere.platform.utils;

import com.lucifiere.platform.defination.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 缓存工具
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
public class PlatformCache {

    private final ConcurrentMap<String, DomainDefinition> DOMAIN_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, AbilityDefinition> ABILITY_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, ExtDefinition> EXTENTION_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, BundleDefinition> BUNDLE_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, TemplateDefinition> TEAPLATE_CACHE = new ConcurrentHashMap<>();


}
