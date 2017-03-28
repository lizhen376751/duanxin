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
     * @return carnum
     */
    public String getCarnum() {
        return carnum;
    }

    /**
     * @param carnum carnum
     */
    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * @return sms
     */
    public String getSms() {
        return sms;
    }

    /**
     * @param sms sms
     */
    public void setSms(String sms) {
        this.sms = sms;
    }

    /**
     * @return smsUser
     */
    public String getSmsUser() {
        return smsUser;
    }

    /**
     * @param smsUser smsUser
     */
    public void setSmsUser(String smsUser) {
        this.smsUser = smsUser;
    }

    /**
     * @return smsPwd
     */
    public String getSmsPwd() {
        return smsPwd;
    }

    /**
     * @param smsPwd smsPwd
     */
    public void setSmsPwd(String smsPwd) {
        this.smsPwd = smsPwd;
    }

    /**
     * @return parameter1
     */
    public String getParameter1() {
        return parameter1;
    }

    /**
     * @param parameter1 parameter1
     */
    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    /**
     * @return parameter2
     */
    public String getParameter2() {
        return parameter2;
    }

    /**
     * @param parameter2 parameter2
     */
    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    /**
     * @return parameter3
     */
    public String getParameter3() {
        return parameter3;
    }

    /**
     * @param parameter3 parameter3
     */
    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    /**
     * @return parameter4
     */
    public String getParameter4() {
        return parameter4;
    }

    /**
     * @param parameter4 parameter4
     */
    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }

    /**
     * @return 字符串
     */
    @Override
    public String toString() {
        return "ParameterEntry [carnum=" + carnum + ", date=" + date
                + ", storeName=" + storeName + ", sms=" + sms + ", smsUser="
                + smsUser + ", smsPwd=" + smsPwd + ", parameter1=" + parameter1
                + ", parameter2=" + parameter2 + ", parameter3=" + parameter3
                + ", parameter4=" + parameter4 + "]";
    }


}
