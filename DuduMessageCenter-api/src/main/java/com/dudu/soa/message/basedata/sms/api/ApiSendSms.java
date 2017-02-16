package com.dudu.soa.message.basedata.sms.api;

import com.dudu.soa.message.basedata.sms.module.ParameterEntry;

public interface ApiSendSms {
	
	/*
	 * 短信发送
	 *  ParameterEntry实体类,没有配置默认为空
	 */
	public void sendSMS(ParameterEntry parameterEntry);
	
	
}
