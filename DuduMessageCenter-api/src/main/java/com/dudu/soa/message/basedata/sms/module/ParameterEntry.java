package com.dudu.soa.message.basedata.sms.module;

import java.io.Serializable;
import java.util.List;

/*
 * 调用短信接口所需要的参数封装为实体类
 */
public class ParameterEntry implements Serializable{
	//车主名字
	public String ownerName;
	
	//日期(如:消费日期,生日日期...)
	public String date;
	
	//赠送金额
	public String giveMoney;
	
	//剩余金额
	public String residueMoney;
	
	//总金额
	public String allMoney;
	
	//店铺名字
	public String storeName;
	
	//消费详情(如购买什么物品..)
	public String consumptiondetails;
	
	//支付详情(支付方式)
	public String apliaydetails;
	
	//业务类型(不同业务应用短信模板不同)
	public String businessType;
	
	//店铺代码
	public String shopcode;
	
	//发送的手机号码
	public List<String> recnum;
	
	//消费金额
	public String consumptionMoney;

	public String getOwnerName() {
		return ownerName;
	}

	public String getConsumptionMoney() {
		return consumptionMoney;
	}

	public void setConsumptionMoney(String consumptionMoney) {
		this.consumptionMoney = consumptionMoney;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGiveMoney() {
		return giveMoney;
	}

	public void setGiveMoney(String giveMoney) {
		this.giveMoney = giveMoney;
	}

	public String getResidueMoney() {
		return residueMoney;
	}

	public void setResidueMoney(String residueMoney) {
		this.residueMoney = residueMoney;
	}

	public String getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getConsumptiondetails() {
		return consumptiondetails;
	}

	public void setConsumptiondetails(String consumptiondetails) {
		this.consumptiondetails = consumptiondetails;
	}

	public String getApliaydetails() {
		return apliaydetails;
	}

	public void setApliaydetails(String apliaydetails) {
		this.apliaydetails = apliaydetails;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getShopcode() {
		return shopcode;
	}

	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}

	public List<String> getRecnum() {
		return recnum;
	}

	public void setRecnum(List<String> recnum) {
		this.recnum = recnum;
	}

	@Override
	public String toString() {
		return "ParameterEntry [ownerName=" + ownerName + ", date=" + date
				+ ", giveMoney=" + giveMoney + ", residueMoney=" + residueMoney
				+ ", allMoney=" + allMoney + ", storeName=" + storeName
				+ ", consumptiondetails=" + consumptiondetails
				+ ", apliaydetails=" + apliaydetails + ", businessType="
				+ businessType + ", shopcode=" + shopcode + ", recnum="
				+ recnum + ", consumptionMoney=" + consumptionMoney + "]";
	}
	
}
