package com.dudu.soa.messagecenter.api;

import com.dudu.soa.messagecenter.module.ParameterEntry;

public interface ApiSendSms {
	
	 /**
     * 
    * @Title:       发送短信消息
    * @Description: 
    * @param ParameterEntry (构建实体类,只需要传入发送短信的参数即可,不传默认为空)
    * @param:          
    * @Date     
     */
	public void sendSMS(ParameterEntry parameterEntry);
}
