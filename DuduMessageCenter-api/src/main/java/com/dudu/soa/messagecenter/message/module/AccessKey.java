package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;

/**
 * 短信接口请求所需参数
 */
public class AccessKey implements Serializable {
    /**
     * 主键id自增长
     */
    private Integer id;

    /**
     * 阿里云账号的accessKey
     */
    private String appkey;
    /**
     * 阿里云账号的appSecret
     */
    private String appSecret;

    /**
     * 短信签名名称
     */
    private String signName;

    /**
     * 店铺编码
     */
    private String shopcode;
    /**
     * 访问MNS服务的接入地址
     */
    private String endpoint;
    /**
     * 发送短信使用的主题
     */
    private String topic;

    /**
     * 是否启用
     */
    private String keyUse;


    /**
     * AccessKey(短信接口请求所需参数) 字符串形式
     *
     * @return AccessKey(短信接口请求所需参数)字符串
     */
    @Override
    public String toString() {
        return "id:" + id + ",appkey:" + appkey + ",appSecret:" + appSecret + ",signName:" + signName + ",shopcode:" + shopcode + ",endpoint:" + endpoint
                + ",topic:" + topic + ",keyUse:" + keyUse;
    }

    /**
     * 获取 主键id自增长
     *
     * @return id 主键id自增长
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 主键id自增长
     *
     * @param id 主键id自增长
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 阿里云账号的accessKey
     *
     * @return appkey 阿里云账号的accessKey
     */
    public String getAppkey() {
        return this.appkey;
    }

    /**
     * 设置 阿里云账号的accessKey
     *
     * @param appkey 阿里云账号的accessKey
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setAppkey(String appkey) {
        this.appkey = appkey;
        return this;
    }

    /**
     * 获取 阿里云账号的appSecret
     *
     * @return appSecret 阿里云账号的appSecret
     */
    public String getAppSecret() {
        return this.appSecret;
    }

    /**
     * 设置 阿里云账号的appSecret
     *
     * @param appSecret 阿里云账号的appSecret
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    /**
     * 获取 短信签名名称
     *
     * @return signName 短信签名名称
     */
    public String getSignName() {
        return this.signName;
    }

    /**
     * 设置 短信签名名称
     *
     * @param signName 短信签名名称
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    /**
     * 获取 店铺编码
     *
     * @return shopcode 店铺编码
     */
    public String getShopcode() {
        return this.shopcode;
    }

    /**
     * 设置 店铺编码
     *
     * @param shopcode 店铺编码
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setShopcode(String shopcode) {
        this.shopcode = shopcode;
        return this;
    }

    /**
     * 获取 访问MNS服务的接入地址
     *
     * @return endpoint 访问MNS服务的接入地址
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * 设置 访问MNS服务的接入地址
     *
     * @param endpoint 访问MNS服务的接入地址
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * 获取 发送短信使用的主题
     *
     * @return topic 发送短信使用的主题
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * 设置 发送短信使用的主题
     *
     * @param topic 发送短信使用的主题
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    /**
     * 获取 是否启用
     *
     * @return keyUse 是否启用
     */
    public String getKeyUse() {
        return this.keyUse;
    }

    /**
     * 设置 是否启用
     *
     * @param keyUse 是否启用
     * @return 返回 AccessKey(短信接口请求所需参数)
     */
    public AccessKey setKeyUse(String keyUse) {
        this.keyUse = keyUse;
        return this;
    }
}