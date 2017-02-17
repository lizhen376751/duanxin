package com.dudu.soa.messagecenter.api;

import com.dudu.soa.messagecenter.module.ParameterEntry;

public interface ApiSendSms {
	
	/*
	 * 短信发送
	 *  ParameterEntry实体类,没有配置默认为空
	 */
	public void sendSMS(ParameterEntry parameterEntry);
	
	
}
