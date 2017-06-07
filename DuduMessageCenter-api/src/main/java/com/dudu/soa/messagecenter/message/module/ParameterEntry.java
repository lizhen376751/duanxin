package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;

/**
 * 调用短信接口所需要的参数封装为实体类
 */
public class ParameterEntry implements Serializable {


    /**
     * 车牌号
     */
    private String carnum;

    /**
     * 日期(如:消费日期,生日日期...)
     */
    private String date;

    /**
     * 店铺名字
     */
    private String storeName;

    /**
     * 短信内容(用于原短信发送)
     */
    private String sms;
    /**
     * 用户名(用于原短信发送)
     */
    private String smsUser;

    /**
     * 密码(用于原短信发送)
     */
    private String smsPwd;

    /**
     * 参数1(用于短信内容赋值)
     */
    private String parameter1;

    /**
     * 参数2(用于短信内容赋值)
     */
    private String parameter2;

    /**
     * 参数3(用于短信内容赋值)
     */
    private String parameter3;

    /**
     * 参数4(用于短信内容赋值)
     */
    private String parameter4;


    /**
     * ParameterEntry(调用短信接口所需要的参数封装为实体类) 字符串形式
     *
     * @return ParameterEntry(调用短信接口所需要的参数封装为实体类)字符串
     */
    @Override
    public String toString() {
        return "carnum:" + carnum + ",date:" + date + ",storeName:" + storeName + ",sms:" + sms + ",smsUser:" + smsUser + ",smsPwd:" + smsPwd
                + ",parameter1:" + parameter1 + ",parameter2:" + parameter2 + ",parameter3:" + parameter3 + ",parameter4:" + parameter4;
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
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setCarnum(String carnum) {
        this.carnum = carnum;
        return this;
    }

    /**
     * 获取 日期(如:消费日期生日日期...)
     *
     * @return date 日期(如:消费日期生日日期...)
     */
    public String getDate() {
        return this.date;
    }

    /**
     * 设置 日期(如:消费日期生日日期...)
     *
     * @param date 日期(如:消费日期生日日期...)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * 获取 店铺名字
     *
     * @return storeName 店铺名字
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * 设置 店铺名字
     *
     * @param storeName 店铺名字
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * 获取 短信内容(用于原短信发送)
     *
     * @return sms 短信内容(用于原短信发送)
     */
    public String getSms() {
        return this.sms;
    }

    /**
     * 设置 短信内容(用于原短信发送)
     *
     * @param sms 短信内容(用于原短信发送)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setSms(String sms) {
        this.sms = sms;
        return this;
    }

    /**
     * 获取 用户名(用于原短信发送)
     *
     * @return smsUser 用户名(用于原短信发送)
     */
    public String getSmsUser() {
        return this.smsUser;
    }

    /**
     * 设置 用户名(用于原短信发送)
     *
     * @param smsUser 用户名(用于原短信发送)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setSmsUser(String smsUser) {
        this.smsUser = smsUser;
        return this;
    }

    /**
     * 获取 密码(用于原短信发送)
     *
     * @return smsPwd 密码(用于原短信发送)
     */
    public String getSmsPwd() {
        return this.smsPwd;
    }

    /**
     * 设置 密码(用于原短信发送)
     *
     * @param smsPwd 密码(用于原短信发送)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setSmsPwd(String smsPwd) {
        this.smsPwd = smsPwd;
        return this;
    }

    /**
     * 获取 参数1(用于短信内容赋值)
     *
     * @return parameter1 参数1(用于短信内容赋值)
     */
    public String getParameter1() {
        return this.parameter1;
    }

    /**
     * 设置 参数1(用于短信内容赋值)
     *
     * @param parameter1 参数1(用于短信内容赋值)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setParameter1(String parameter1) {
        this.parameter1 = parameter1;
        return this;
    }

    /**
     * 获取 参数2(用于短信内容赋值)
     *
     * @return parameter2 参数2(用于短信内容赋值)
     */
    public String getParameter2() {
        return this.parameter2;
    }

    /**
     * 设置 参数2(用于短信内容赋值)
     *
     * @param parameter2 参数2(用于短信内容赋值)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setParameter2(String parameter2) {
        this.parameter2 = parameter2;
        return this;
    }

    /**
     * 获取 参数3(用于短信内容赋值)
     *
     * @return parameter3 参数3(用于短信内容赋值)
     */
    public String getParameter3() {
        return this.parameter3;
    }

    /**
     * 设置 参数3(用于短信内容赋值)
     *
     * @param parameter3 参数3(用于短信内容赋值)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setParameter3(String parameter3) {
        this.parameter3 = parameter3;
        return this;
    }

    /**
     * 获取 参数4(用于短信内容赋值)
     *
     * @return parameter4 参数4(用于短信内容赋值)
     */
    public String getParameter4() {
        return this.parameter4;
    }

    /**
     * 设置 参数4(用于短信内容赋值)
     *
     * @param parameter4 参数4(用于短信内容赋值)
     * @return 返回 ParameterEntry(调用短信接口所需要的参数封装为实体类)
     */
    public ParameterEntry setParameter4(String parameter4) {
        this.parameter4 = parameter4;
        return this;
    }
}
