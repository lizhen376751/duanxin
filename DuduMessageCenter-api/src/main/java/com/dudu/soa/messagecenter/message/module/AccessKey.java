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
     * 是否启用
     */
    private String keyUse;

    /**
     *
     * @return keyUse
     */
    public String getkeyuse() {
        return keyUse;
    }

    /**
     *
     * @param keyUse keyUse
     */
    public void setkeyuse(String keyUse) {
        this.keyUse = keyUse;
    }

    /**
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return appkey
     */
    public String getAppkey() {
        return appkey;
    }

    /**
     *
     * @param appkey appkey
     */
    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    /**
     *
     * @return appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     *
     * @param appSecret appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     *
     * @return signName
     */
    public String getSignName() {
        return signName;
    }

    /**
     *
     * @param signName signName
     */
    public void setSignName(String signName) {
        this.signName = signName;
    }

    /**
     *
     * @return shopcode
     */
    public String getShopcode() {
        return shopcode;
    }

    /**
     *
     * @param shopcode shopcode
     */
    public void setShopcode(String shopcode) {
        this.shopcode = shopcode;
    }

    /**
     *
     * @return 字符串
     */
    @Override
    public String toString() {
        return "AccessKey [id=" + id + ", appkey=" + appkey + ", appSecret="
                + appSecret + ", signName=" + signName + ", shopcode="
                + shopcode + ", keyUse=" + keyUse + "]";
    }
}