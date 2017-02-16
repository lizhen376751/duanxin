package com.dudu.soa.message.basedata.sms.module;

import java.io.Serializable;

/*
 * 短信模板实体类
 */
public class TemplateCode implements Serializable {
	//主键id
	private Integer id;
	
	//店铺编码
	private String shopCode;
	
	//短信模板Code码
	private String templateCode;
	
	//所属业务类型
	private String businessType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "TemplateCode [id=" + id + ", shopCode=" + shopCode
				+ ", templateCode=" + templateCode + ", businessType="
				+ businessType + "]";
	}
	
	
	
}
