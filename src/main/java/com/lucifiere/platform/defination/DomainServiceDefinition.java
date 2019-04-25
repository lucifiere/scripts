package com.lucifiere.platform.defination;

/**
 * 域服务定义
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
public class DomainServiceDefinition extends Definition {

    public static DomainServiceDefinition of(String code, String name, String desc) {
        DomainServiceDefinition definition = new DomainServiceDefinition();
        definition.setCode(code);
        definition.setDesc(desc);
        definition.setName(name);
        return definition;
    }

}
