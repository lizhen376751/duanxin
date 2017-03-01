package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;

/*
 * 短信接口请求所需参数
 */
public class AccessKey implements Serializable {
	//主键id自增长
	private Integer id;
	
	//阿里云账号的accessKey
	private String appkey;
	
	//阿里云账号的appSecret
	private String appSecret;
	
	//短信签名名称
	private String signName;
	
	//店铺编码
	private String shopcode;
	
	//是否启用
	private String keyUse;

	public String getkeyuse() {
		return keyUse;
	}

	public void setkeyuse(String keyUse) {
		this.keyUse = keyUse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getShopcode() {
		return shopcode;
	}

	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}

	@Override
	public String toString() {
		return "AccessKey [id=" + id + ", appkey=" + appkey + ", appSecret="
				+ appSecret + ", signName=" + signName + ", shopcode="
				+ shopcode + ", keyUse=" + keyUse + "]";
	}
	
}
