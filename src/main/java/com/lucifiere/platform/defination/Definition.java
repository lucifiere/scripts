package com.lucifiere.platform.defination;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * 定义基础
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Data
public abstract class Definition {

    private String name;

    private String code;

    private String desc;

    public boolean in(Collection<? extends Definition> elements) {
        for (Definition baseSpec : elements) {
            if (!this.getClass().getName().equals(baseSpec.getClass().getName())) {
                continue;
            }
            if (StringUtils.equals(this.getCode(), baseSpec.getCode())) {
                return true;
            }
        }
        return false;
    }

}
