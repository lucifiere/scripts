package com.exceptions;

/**
 * Created by XD.Wang on 2017/5/31.
 * 错误码
 *
 * @author XD.Wang
 */
public enum ErrorCode {

    /**
     * 系统异常
     */
    SYSTEM_ERROR("系统异常", Level.FATAL, Type.SYSTEM, BizDomain.SYSTEM),
    API_ARGUMENT_ERROR("API入参有误", Level.SERIOUS, Type.SYSTEM, BizDomain.SYSTEM),
    BIZ_EXECUTE_FAILED("业务执行失败", Level.NORMAL, Type.BIZ, BizDomain.SYSTEM),;

    /**
     * 错误类型
     *
     * @author XD.Wang
     */
    public enum Type {
        /**
         * 系统级错误
         */
        SYSTEM,
        /**
         * 已检业务异常
         */
        BIZ,
        /**
         * 其他
         */
        OTHER
    }

    /**
     * 错误级别
     *
     * @author XD.Wang
     */
    public enum Level {
        /**
         * 不重要或者可忽略
         */
        IGNORE,
        /**
         * 优先级低的普通问题
         */
        NORMAL,
        /**
         * 优先级高的普通问题
         */
        SERIOUS,
        /**
         * 需要立即处理的严重问题
         */
        FATAL
    }

    /**
     * 业务域
     *
     * @author XD.Wang
     */
    public enum BizDomain {
        /**
         * 系统
         */
        SYSTEM
    }

    /**
     * 错误级别
     */
    private Level level;
    /**
     * 错误描述
     */
    private String desc;
    /**
     * 错误类型
     */
    private Type typ;

    /**
     * 业务域
     */
    private BizDomain bizDomain;

    public Level getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }

    public Type getTyp() {
        return typ;
    }

    public BizDomain getBizDomain() {
        return bizDomain;
    }

    ErrorCode(String desc, Level level, Type typ, BizDomain bizDomain) {
        this.desc = desc;
        this.level = level;
        this.typ = typ;
        this.bizDomain = bizDomain;
    }

}
