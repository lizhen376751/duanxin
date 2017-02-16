package com.dudu.soa.basedata.sms.impl;

import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.dudu.soa.message.basedata.sms.api.ApiSendSms;
import com.dudu.soa.message.basedata.sms.module.ParameterEntry;


/*
 * 短信发送实现类
 */
@Service
public class SendSmsImpl implements ApiSendSms{
	
	private final static String HOST = "sms.aliyuncs.com"; //API域名:用于连接阿里云的url
	@Override
	public void sendSMS(ParameterEntry parameterEntry) {
//		try {
//	    	
//		    IClientProfile profile = DefaultProfile.getProfile(REGIONID, APP_KEY, APP_SECRET);
//		     DefaultProfile.addEndpoint(REGIONID, REGIONID, "Sms",  HOST);
//		    IAcsClient client = new DefaultAcsClient(profile);
//		    SingleSendSmsRequest request = new SingleSendSmsRequest();
//		        request.setSignName(SIGN_NAME);//控制台创建的签名名称
//		         request.setTemplateCode(TEMPLATE_CODE);//控制台创建的模板CODE
//		        request.setParamString("{\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
//		        //request.setParamString("{}");
//		        request.setRecNum("18560042032");//接收号码
//		        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
//		    
//		    } catch (ServerException e) {
//		        e.printStackTrace();
//		    }
//		    catch (ClientException e) {
//		        e.printStackTrace();
//		    }
//		
	}
	
}
