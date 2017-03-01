package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;
import java.util.List;

/*
 * 调用短信接口所需要的参数封装为实体类
 */
public class ParameterEntry implements Serializable{
	
	
	//车牌号
	public String carnum;
	
	//日期(如:消费日期,生日日期...)
	public String date;
	
	//店铺名字
	public String storeName;
	
	//短信内容(用于原短信发送)
	public String sms;
	
	//用户名(用于原短信发送)
	public String smsUser;
	
	//密码(用于原短信发送)
	public String smsPwd;
	
	//参数1(用于短信内容赋值)
	public String parameter1;
	
	//参数2(用于短信内容赋值)
	public String parameter2;
	
	//参数3(用于短信内容赋值)
	public String parameter3;
	
	//参数4(用于短信内容赋值)
	public String parameter4;

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getSmsUser() {
		return smsUser;
	}

	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
	}

	public String getSmsPwd() {
		return smsPwd;
	}

	public void setSmsPwd(String smsPwd) {
		this.smsPwd = smsPwd;
	}

	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public String getParameter3() {
		return parameter3;
	}

	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}

	public String getParameter4() {
		return parameter4;
	}

	public void setParameter4(String parameter4) {
		this.parameter4 = parameter4;
	}

	@Override
	public String toString() {
		return "ParameterEntry [carnum=" + carnum + ", date=" + date
				+ ", storeName=" + storeName + ", sms=" + sms + ", smsUser="
				+ smsUser + ", smsPwd=" + smsPwd + ", parameter1=" + parameter1
				+ ", parameter2=" + parameter2 + ", parameter3=" + parameter3
				+ ", parameter4=" + parameter4 + "]";
	}
	
	
	
	
}
