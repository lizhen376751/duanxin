package com.dudu.soa.messagecenter;

import java.io.Serializable;

/**
 * 消息抽象
 *
 * @param <T> 实现类类型
 */
public abstract class MsgTemplateBaseDefine<T> implements Serializable {

    /**
     * 消息来源AppName
     */
    private String appName;

    /**
     * 消息类型
     */
    private MsgTypeEnum msgTypeEnum;

    /**
     * 消息受众目标
     */
    private MsgTargetEnum msgTargetEnum;

    /**
     * 消息版本号
     */
    private String version;

    /**
     * MsgTemplateBaseDefine(消息模板抽象类) 字符串形式
     *
     * @return MsgTemplateBaseDefine(消息模板抽象类)字符串
     */
    @Override
    public String toString() {
        return "appName:" + appName + ",msgTypeEnum:" + msgTypeEnum + ",msgTargetEnum:" + msgTargetEnum + ",version:" + version;
    }

    /**
     * 获取 消息来源AppName
     *
     * @return appName 消息来源AppName
     */
    public String getAppName() {
        return this.appName;
    }

    /**
     * 设置 消息来源AppName
     *
     * @param appName 消息来源AppName
     * @return 返回 MsgTemplateBaseDefine(消息模板抽象类)
     */
    public T setAppName(String appName) {
        this.appName = appName;
        return (T) this;
    }

    /**
     * 获取 消息类型
     *
     * @return msgTypeEnum 消息类型
     */
    public MsgTypeEnum getMsgTypeEnum() {
        return this.msgTypeEnum;
    }

    /**
     * 设置 消息类型
     *
     * @param msgTypeEnum 消息类型
     * @return 返回 MsgTemplateBaseDefine(消息模板抽象类)
     */
    public T setMsgTypeEnum(MsgTypeEnum msgTypeEnum) {
        this.msgTypeEnum = msgTypeEnum;
        return (T) this;
    }

    /**
     * 获取 消息受众目标
     *
     * @return msgTargetEnum 消息受众目标
     */
    public MsgTargetEnum getMsgTargetEnum() {
        return this.msgTargetEnum;
    }

    /**
     * 设置 消息受众目标
     *
     * @param msgTargetEnum 消息受众目标
     * @return 返回 MsgTemplateBaseDefine(消息模板抽象类)
     */
    public T setMsgTargetEnum(MsgTargetEnum msgTargetEnum) {
        this.msgTargetEnum = msgTargetEnum;
        return (T) this;
    }

    /**
     * 获取 消息版本号
     *
     * @return version 消息版本号
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * 设置 消息版本号
     *
     * @param version 消息版本号
     * @return 返回 MsgTemplateBaseDefine(消息模板抽象类)
     */
    public T setVersion(String version) {
        this.version = version;
        return (T) this;
    }
}
