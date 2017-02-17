package com.dudu.soa.messagecenter.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.dudu.soa.messagecenter.api.ApiSendSms;
import com.dudu.soa.messagecenter.mapper.SendSmsDao;
import com.dudu.soa.messagecenter.module.AccessKey;
import com.dudu.soa.messagecenter.module.ParameterEntry;
import com.dudu.soa.messagecenter.module.TemplateCode;

@Service
public class copy implements ApiSendSms{
	
	 @Autowired
	 private SendSmsDao sendSmsDao;
	 
	 private final static String HOST = "sms.aliyuncs.com"; //API域名从控制台获取
	 private final static String REGIONID = "";
	

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
		
		//获取消费金额
		String consumptionMoney = parameterEntry.getConsumptionMoney();
		
		//发送的手机号码
		List<String> recnum = parameterEntry.getRecnum();
		String sendPhone = "";
		for(int i=0;i<recnum.size();i++){
			sendPhone+=recnum.get(i);
			sendPhone+=",";
				
		}
		
		//获取AccessKey实体
		AccessKey accessKey =  new AccessKey();
		accessKey.setAppkey("LTAItFAKjkOvqssX");
		accessKey.setAppSecret("bmjmiW2SYYGnqmSyNLWXA94yP5AKGj");
		accessKey.setSignName("生日祝福");
		accessKey.setShopcode("0533001");
//		AccessKey queryAccessKey = sendSmsDao.queryAccessKey(shopcode);
		
		String appkey = accessKey.getAppkey();
		
		String appSecret = accessKey.getAppSecret();
		
		//短信签名
		String signName = accessKey.getSignName();
		
		TemplateCode param = new TemplateCode();
		param.setId(1);
		param.setShopCode("0533001");
		param.setTemplateCode("SMS_47430145");
		param.setBusinessType("happybrithyday");
		//获取短信模板TemplateCode实体
//		TemplateCode queryTemplateCode = sendSmsDao.queryTemplateCode(shopcode, businessType);
		
		//短信模板code
		String templateCode = param.getTemplateCode();
		
	
		try {
		IClientProfile profile = DefaultProfile.getProfile(REGIONID, appkey, appSecret);
		DefaultProfile.addEndpoint(REGIONID, REGIONID, "Sms",  HOST);
		IAcsClient client = new DefaultAcsClient(profile);
		    SingleSendSmsRequest request = new SingleSendSmsRequest();
		        request.setSignName(signName);//控制台创建的签名名称
		        request.setTemplateCode(templateCode);//控制台创建的模板CODE
	//	        Map<String, String> params = new HashMap();
	//	        params.put("ownerName", ownerName);
	//	        params.put("ownerName", ownerName);
	//	        params.put("ownerName", ownerName);
	//	        params.put("ownerName", ownerName);
	//	        Object paramsJson = JSONArray.toJSON(params);
		        String ownerName1 = "lizhen";
		        String date1  = "2016.12.3";
		        JSONObject node = new JSONObject();
		        node.put("ownerName", ownerName);
		        node.put("storeName", date1);
		        node.put("date", date1);
		        String param1="ownerName :"+ownerName +",storeName :"+ date1;
		        String param2="{"+param1+"}";
//		        String params="{\"ownerName\":"+ownerName+",\"date\":"+date+",\"giveMoney\":"+giveMoney+",\"storeName\":"+storeName+",\"consumptiondetails\":"+consumptiondetails+",\"apliaydetails\":"+apliaydetails+"}";
//		        request.setParamString("{\"ownerName\":\"嘟嘟客户\",\"storeName\":\"嘟嘟车网\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
		        request.setParamString(node.toString());
		        request.setRecNum(sendPhone);//接收号码
		        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
		 } catch (ServerException e) {
		        e.printStackTrace();
		    }
		    catch (ClientException e) {
		        e.printStackTrace();
		    }
	
}
public  static void main(String agrs[]){
	copy sms = new copy();
	ParameterEntry parameterEntry = new ParameterEntry();
	ArrayList<String> recnum = new ArrayList<String>();
	recnum.add("18560042032");
	recnum.add("17076081635");
	parameterEntry.setShopcode("0533001");
	parameterEntry.setBusinessType("happybrithyday");
	parameterEntry.setRecnum(recnum);
	parameterEntry.setAllMoney("1000");
	parameterEntry.setApliaydetails("微信支付");
	parameterEntry.setConsumptiondetails("洗车打蜡一次");
	parameterEntry.setConsumptionMoney("100");
	parameterEntry.setDate("2017-2-17 12:27");
	parameterEntry.setGiveMoney("10");
	parameterEntry.setOwnerName("lizhen");
	parameterEntry.setResidueMoney("910");
	parameterEntry.setStoreName("嘟嘟洗车");
	sms.sendSMS(parameterEntry);
}
	
}
