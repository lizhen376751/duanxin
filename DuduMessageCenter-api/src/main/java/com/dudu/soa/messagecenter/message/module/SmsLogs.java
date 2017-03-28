package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;


/**
 * 记录短信发送记录
 */
public class SmsLogs implements Serializable {


    /**
     * 主键id自增长
     */
    private Integer id;


    /**
     * 店铺代码
     */
    private String shopcode;


    /**
     * 手机号码
     */
    private String phonenum;

    /**
     * 车牌号码
     */
    private String carnum;


    /**
     * 短信模板名称
     */
    private String smsname;


    /**
     * 发送日期
     */
    private String date;


    /**
     * 发送状态
     */
    private String state;


    /**
     * 失败原因
     */
    private String cause;

    /**
     * @return 字符串
     */
    @Override
    public String toString() {
        return "SmsLogs [id=" + id + ", shopcode=" + shopcode
                + ", phonenum=" + phonenum + ", carnum=" + carnum
                + ", smsname=" + smsname + ", date=" + date + ", state="
                + state + ", cause=" + cause + "]";
    }

    /**
     * @return  shopcode
     */
    public String getShopcode() {
        return shopcode;
    }

    /**
     * @param shopcode shopcode
     */
    public void setShopcode(String shopcode) {
        this.shopcode = shopcode;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return phonenum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum phonenum
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

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
     * @return smsname
     */
    public String getSmsname() {
        return smsname;
    }

    /**
     * @param smsname smsname
     */
    public void setSmsname(String smsname) {
        this.smsname = smsname;
    }

    /**
     * @return String
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date 日期
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return String String类型
     */
    public String getState() {
        return state;
    }

    /**
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String String类型
     */
    public String getCause() {
        return cause;
    }

    /**
     * @param cause cause
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

}
