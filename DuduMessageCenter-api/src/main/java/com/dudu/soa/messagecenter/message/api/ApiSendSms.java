package com.dudu.soa.messagecenter.message.api;

import java.util.List;

import com.dudu.soa.messagecenter.message.module.ParameterEntry;
/**
 * 发送短信消息
*/
public interface ApiSendSms {
	 /**
     * 
    * @Title:       发送短信消息
    * @Description: 
    * @param ParameterEntry1 (构建实体类,只需要传入发送短信的参数即可,不传默认为空)
    * @param: shopcode:店铺编码    
    * @param: recnum:手机号码,List集合用于发送多条短信
    * @param: businessType:业务类型(与模板名称对应)        
    * @Date     
     */
	public void sendSMS(String shopcode, String businessType, List<String> recnum ,ParameterEntry parameterEntry);

}
