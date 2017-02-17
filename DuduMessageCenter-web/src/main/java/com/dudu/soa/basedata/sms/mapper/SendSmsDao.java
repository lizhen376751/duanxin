package com.dudu.soa.basedata.sms.mapper;

import com.dudu.soa.message.basedata.sms.module.AccessKey;
//查询AccessKey实体用于获取调用阿里云接口的参数
public interface SendSmsDao {
	/*
	 * 根据shopcode和businessType在TemplateCode表中查询出templateCode
	 */
	public AccessKey queryEntry(String shopcode,String businessType);
}
