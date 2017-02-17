package com.dudu.soa.basedata.sms.mapper;

import com.dudu.soa.message.basedata.sms.module.AccessKey;
import com.dudu.soa.message.basedata.sms.module.TemplateCode;
//查询AccessKey实体用于获取调用阿里云接口的参数
public interface SendSmsDao {
	/*
	 * 根据shopcode在AccessKey表中查询
	 * 一个shopcode对应一个短信签名
	 */
	public AccessKey queryAccessKey(String shopcode);
	
	
	/*
	 * 根据shopcode和businessType在TemplateCode表中查询出templateCode
	 * shopcode和businessType对应一个短信模板
	 */
	public TemplateCode queryTemplateCode(String shopcode,String businessType);
}
