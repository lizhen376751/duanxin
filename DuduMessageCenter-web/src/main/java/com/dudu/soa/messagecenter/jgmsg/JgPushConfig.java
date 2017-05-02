package com.dudu.soa.messagecenter.jgmsg;

/**
 * 极光推送配置
 * Created by Z800 on 2017/4/26.
 */
public class JgPushConfig {
    /**
     * appKey
     */
    private String appKey;
    /**
     * secret
     */
    private String masterSecret;

    /**
     *  JgPushConfig(极光推送配置) 字符串形式
     * @return JgPushConfig(极光推送配置)字符串
     */
    @Override
    public String toString() {
        return "appKey:" + appKey + ",masterSecret:" + masterSecret;
    }

    /**
     * 获取 appKey
     * @return appKey appKey
     */
    public String getAppKey() {
        return this.appKey;
    }

    /**
     * 设置 appKey
     * @param appKey appKey
     * @return 返回 JgPushConfig(极光推送配置)
     */
    public JgPushConfig setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    /**
     * 获取 secret
     * @return masterSecret secret
     */
    public String getMasterSecret() {
        return this.masterSecret;
    }

    /**
     * 设置 secret
     * @param masterSecret secret
     * @return 返回 JgPushConfig(极光推送配置)
     */
    public JgPushConfig setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
        return this;
    }
}
