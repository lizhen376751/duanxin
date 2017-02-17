package com.dudu.soa.basedata.sms.service;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
public class SendMessage{
	
	 private final static String APP_KEY = "LTAItFAKjkOvqssX"; //AppKey从控制台获取
	 private final static String APP_SECRET = "bmjmiW2SYYGnqmSyNLWXA94yP5AKGj"; //AppSecret从控制台获取
	 private final static String SIGN_NAME = "生日祝福"; // (传参)签名名称从控制台获取，必须是审核通过的,加载最前面的
	 private final static String TEMPLATE_CODE = "SMS_47430145"; //(传参)模板CODE从控制台获取，必须是审核通过的
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
        request.setParamString("{\"ownerName\":\"嘟嘟客户\",\"storeName\":\"嘟嘟车网\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
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
public  static void main(String agrs[]){
	SendMessage sms = new SendMessage();
	sms.sample();
}
}