package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;
import java.util.List;


/**
 * 短信接口发送实体类
 * Created by lizhen on 2017/8/14.
 */

public class MessageEntry implements Serializable {
    /**
     * 店铺编码
     */
    private String shopcode;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 电话号码集合
     */
    private List<String> list;
    /**
     * 车牌号
     */
    private String carnum;
    /**
     * 日期
     */
    private String date;
    /**
     * 店铺名称
     */
    private String storeName;
    /**
     * 短信签名
     */
    private String sms;
    /**
     * 创瑞登录名
     */
    private String smsUser;
    /**
     * 创瑞密码
     */
    private String smsPwd;
    /**
     * 参数1
     */
    private String parameter1;
    /**
     * 参数2
     */
    private String parameter2;
    /**
     * 参数3
     */
    private String parameter3;
    /**
     * 参数4
     */
    private String parameter4;


    /**
     * MessageEntry(短信接口发送实体类) 字符串形式
     *
     * @return MessageEntry(短信接口发送实体类)字符串
     */
    @Override
    public String toString() {
        return "shopcode:" + shopcode + ",businessType:" + businessType + ",list:" + list + ",carnum:" + carnum + ",date:" + date + ",storeName:" + storeName
                + ",sms:" + sms + ",smsUser:" + smsUser + ",smsPwd:" + smsPwd + ",parameter1:" + parameter1 + ",parameter2:" + parameter2 + ",parameter3:" + parameter3
                + ",parameter4:" + parameter4;
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
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setShopcode(String shopcode) {
        this.shopcode = shopcode;
        return this;
    }

    /**
     * 获取 业务类型
     *
     * @return businessType 业务类型
     */
    public String getBusinessType() {
        return this.businessType;
    }

    /**
     * 设置 业务类型
     *
     * @param businessType 业务类型
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setBusinessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    /**
     * 获取 电话号码集合
     *
     * @return list 电话号码集合
     */
    public List<String> getList() {
        return this.list;
    }

    /**
     * 设置 电话号码集合
     *
     * @param list 电话号码集合
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setList(List<String> list) {
        this.list = list;
        return this;
    }

    /**
     * 获取 车牌号
     *
     * @return carnum 车牌号
     */
    public String getCarnum() {
        return this.carnum;
    }

    /**
     * 设置 车牌号
     *
     * @param carnum 车牌号
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setCarnum(String carnum) {
        this.carnum = carnum;
        return this;
    }

    /**
     * 获取 日期
     *
     * @return date 日期
     */
    public String getDate() {
        return this.date;
    }

    /**
     * 设置 日期
     *
     * @param date 日期
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * 获取 店铺名称
     *
     * @return storeName 店铺名称
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * 设置 店铺名称
     *
     * @param storeName 店铺名称
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * 获取 短信签名
     *
     * @return sms 短信签名
     */
    public String getSms() {
        return this.sms;
    }

    /**
     * 设置 短信签名
     *
     * @param sms 短信签名
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setSms(String sms) {
        this.sms = sms;
        return this;
    }

    /**
     * 获取 创瑞登录名
     *
     * @return smsUser 创瑞登录名
     */
    public String getSmsUser() {
        return this.smsUser;
    }

    /**
     * 设置 创瑞登录名
     *
     * @param smsUser 创瑞登录名
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setSmsUser(String smsUser) {
        this.smsUser = smsUser;
        return this;
    }

    /**
     * 获取 创瑞密码
     *
     * @return smsPwd 创瑞密码
     */
    public String getSmsPwd() {
        return this.smsPwd;
    }

    /**
     * 设置 创瑞密码
     *
     * @param smsPwd 创瑞密码
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setSmsPwd(String smsPwd) {
        this.smsPwd = smsPwd;
        return this;
    }

    /**
     * 获取 参数1
     *
     * @return parameter1 参数1
     */
    public String getParameter1() {
        return this.parameter1;
    }

    /**
     * 设置 参数1
     *
     * @param parameter1 参数1
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setParameter1(String parameter1) {
        this.parameter1 = parameter1;
        return this;
    }

    /**
     * 获取 参数2
     *
     * @return parameter2 参数2
     */
    public String getParameter2() {
        return this.parameter2;
    }

    /**
     * 设置 参数2
     *
     * @param parameter2 参数2
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setParameter2(String parameter2) {
        this.parameter2 = parameter2;
        return this;
    }

    /**
     * 获取 参数3
     *
     * @return parameter3 参数3
     */
    public String getParameter3() {
        return this.parameter3;
    }

    /**
     * 设置 参数3
     *
     * @param parameter3 参数3
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setParameter3(String parameter3) {
        this.parameter3 = parameter3;
        return this;
    }

    /**
     * 获取 参数4
     *
     * @return parameter4 参数4
     */
    public String getParameter4() {
        return this.parameter4;
    }

    /**
     * 设置 参数4
     *
     * @param parameter4 参数4
     * @return 返回 MessageEntry(短信接口发送实体类)
     */
    public MessageEntry setParameter4(String parameter4) {
        this.parameter4 = parameter4;
        return this;
    }
}
