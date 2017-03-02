package com.dudu.soa.messagecenter.message.api;

import java.util.List;

import com.dudu.soa.messagecenter.message.module.ParameterEntry;
/**
 * 发送短信消息
*/
public interface ApiSendSms {
	 /**
     * 
    * @Title:  发送短信消息
    * @param1: shopcode:店铺编码    
    * @param2: businessType:业务类型(与短信模板名称对应)
    * @param3: List<String>类型recnum:手机号码，多个手机号码可发送多条短信
    * @param4: ParameterEntry1 (构建实体类,只需要传入发送短信的参数即可,不传默认为空)        
    * @Date     
     */
	public void sendSMS(String shopcode, String businessType, List<String> recnum ,ParameterEntry parameterEntry);

}
