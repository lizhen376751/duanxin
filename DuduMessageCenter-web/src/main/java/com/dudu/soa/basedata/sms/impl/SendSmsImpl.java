package com.dudu.soa.basedata.sms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.dudu.soa.basedata.sms.mapper.SendSmsDao;
import com.dudu.soa.message.basedata.sms.api.ApiSendSms;
import com.dudu.soa.message.basedata.sms.module.AccessKey;
import com.dudu.soa.message.basedata.sms.module.ParameterEntry;
import com.dudu.soa.message.basedata.sms.module.TemplateCode;

@Service
public class SendSmsImpl implements ApiSendSms{
	
	 @Autowired
	 private SendSmsDao sendSmsDao;
	
	 private final static String APP_KEY = "LTAIMIvaC6bOkP2t"; 
	 private final static String APP_SECRET = "01ioS3P5a5CabpN1dQxlLP9vOTe3xz"; //AppSecret从控制台获取
	 private final static String SIGN_NAME = "祝生日快乐"; // (传参)签名名称从控制台获取，必须是审核通过的,加载最前面的
	 private final static String TEMPLATE_CODE = "SMS_47015002"; //(传参)模板CODE从控制台获取，必须是审核通过的
	 private final static String HOST = "sms.aliyuncs.com"; //API域名从控制台获取
	 private final static String REGIONID = "";
	

public void sample() {  
	
    try {
    	
    IClientProfile profile = DefaultProfile.getProfile(REGIONID, APP_KEY, APP_SECRET);
     DefaultProfile.addEndpoint(REGIONID, REGIONID, "Sms",  HOST);
    IAcsClient client = new DefaultAcsClient(profile);
    SingleSendSmsRequest request = new SingleSendSmsRequest();
        request.setSignName(SIGN_NAME);//控制台创建的签名名称
         request.setTemplateCode(TEMPLATE_CODE);//控制台创建的模板CODE
        request.setParamString("{\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
        //request.setParamString("{}");
        request.setRecNum("18560042032");//接收号码
        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
    
    } catch (ServerException e) {
        e.printStackTrace();
    }
    catch (ClientException e) {
        e.printStackTrace();
    }
}


@Override
public void sendSMS(ParameterEntry parameterEntry)  {
	
	//获取参数用于赋值给短信中的内容参数
	////车主名字
	String ownerName = parameterEntry.getOwnerName();
	
	//日期(如:消费日期,生日日期...)
	String date = parameterEntry.getDate();
	
	//赠送金额
	String giveMoney = parameterEntry.getGiveMoney();
	
	//剩余金额
	String residueMoney = parameterEntry.getResidueMoney();
	
	//总金额
	String allMoney = parameterEntry.getAllMoney();
	
	//店铺名字
	String storeName = parameterEntry.getStoreName();
	
	//消费详情(购买物品..)
	String consumptiondetails = parameterEntry.getConsumptiondetails();
	
	//支付详情(支付方式)
	String apliaydetails = parameterEntry.getApliaydetails();
	
	//获取businessType业务类型用于查询短信模板的code
	String businessType = parameterEntry.getBusinessType();
	
	//获取shopcode用于查询店铺的短信签名
	String shopcode = parameterEntry.getShopcode();
	
	//发送的手机号码
	List<String> recnum = parameterEntry.getRecnum();
	String sendPhone ;
	for(int i=0;i<recnum.size();i++){
		
	}
	
	//获取AccessKey实体
	AccessKey queryAccessKey = sendSmsDao.queryAccessKey(shopcode);
	
	String appkey = queryAccessKey.getAppkey();
	
	String appSecret = queryAccessKey.getAppSecret();
	
	//短信签名
	String signName = queryAccessKey.getSignName();
	
	//获取短信模板TemplateCode实体
	TemplateCode queryTemplateCode = sendSmsDao.queryTemplateCode(shopcode, businessType);
	
	//短信模板code
	String templateCode = queryTemplateCode.getTemplateCode();
	

	try {
	IClientProfile profile = DefaultProfile.getProfile(REGIONID, appkey, appSecret);
	DefaultProfile.addEndpoint(REGIONID, REGIONID, "Sms",  HOST);
	IAcsClient client = new DefaultAcsClient(profile);
	    SingleSendSmsRequest request = new SingleSendSmsRequest();
	        request.setSignName(signName);//控制台创建的签名名称
	         request.setTemplateCode(templateCode);//控制台创建的模板CODE
	         String name="{\"ownerName\":\"嘟嘟客户\",\"date\":\"嘟嘟车网\","
	        		+ "\"giveMoney\":\"嘟嘟客户\",\"storeName\":\"嘟嘟车网\","
	        		+ "\"consumptiondetails\":\"嘟嘟客户\",\"apliaydetails\":\"嘟嘟车网\","
	        		+ "\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\"}";
	        request.setParamString("{\"ownerName\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\","
	        		+ "\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\","
	        		+ "\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\","
	        		+ "\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\","
	        		+ "\"name\":\"嘟嘟客户\",\"shopname\":\"嘟嘟车网\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
	        //request.setParamString("{}");
	        request.setRecNum("18560042032");//接收号码
	        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
	 } catch (ServerException e) {
	        e.printStackTrace();
	    }
	    catch (ClientException e) {
	        e.printStackTrace();
	    }
	
}
	
}
