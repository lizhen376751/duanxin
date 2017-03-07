package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;
//记录短信发送记录
public class SmsLogs implements Serializable{

		//主键id自增长
		private Integer id;
		
		//店铺代码
		private String shopcode;
		
		
		//手机号码
		private String phonenum;
		
		//车牌号码
		private String carnum;
		
		//短信模板名称
		private String smsname;
		
		//发送日期
		private String date;
		
		//发送状态
		private String state;
		
		//失败原因
		private String cause;

		@Override
		public String toString() {
			return "SmsLogs [id=" + id + ", shopcode=" + shopcode
					+ ", phonenum=" + phonenum + ", carnum=" + carnum
					+ ", smsname=" + smsname + ", date=" + date + ", state="
					+ state + ", cause=" + cause + "]";
		}
		public String getShopcode() {
			return shopcode;
		}

		public void setShopcode(String shopcode) {
			this.shopcode = shopcode;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getPhonenum() {
			return phonenum;
		}

		public void setPhonenum(String phonenum) {
			this.phonenum = phonenum;
		}

		public String getCarnum() {
			return carnum;
		}

		public void setCarnum(String carnum) {
			this.carnum = carnum;
		}

		public String getSmsname() {
			return smsname;
		}

		public void setSmsname(String smsname) {
			this.smsname = smsname;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCause() {
			return cause;
		}

		public void setCause(String cause) {
			this.cause = cause;
		}

}
