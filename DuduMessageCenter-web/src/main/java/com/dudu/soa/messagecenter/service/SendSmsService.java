package com.dudu.soa.messagecenter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SendSmsService implements ApiSendSms{
	
	 @Autowired
	 private SendSmsDao sendSmsDao;
	 
	 private final static String HOST = "sms.aliyuncs.com"; //API域名从控制台获取
	 private final static String REGIONID = "";
	
	 private static Logger logger = LoggerFactory.getLogger(SendSmsService.class); 

	 @Override
	 @Transactional
	 public void sendSMS(ParameterEntry parameterEntry)  {
	
		//获取参数用于赋值给短信中的内容参数
		//车主名字
		String ownerName = parameterEntry.getOwnerName();
		
		//项目卡号
		String cardnum = parameterEntry.getCardnum();
		
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
		AccessKey queryAccessKey = sendSmsDao.queryAccessKey(shopcode);
		
		String appkey = queryAccessKey.getAppkey();
		
		String appSecret = queryAccessKey.getAppSecret();
		
		//短信签名
		String signName = queryAccessKey.getSignName();
		
		//获取短信模板TemplateCode实体
		TemplateCode queryTemplateCode = sendSmsDao.queryTemplateCode(shopcode, businessType);
		if(queryTemplateCode != null){
			//短信模板code
			String templateCode = queryTemplateCode.getTemplateCode();
			
			if(!templateCode.isEmpty() && !"".equals(templateCode) && templateCode!=null){
				try {
					IClientProfile profile = DefaultProfile.getProfile(REGIONID, appkey, appSecret);
					DefaultProfile.addEndpoint(REGIONID, REGIONID, "Sms",  HOST);
					IAcsClient client = new DefaultAcsClient(profile);
					    SingleSendSmsRequest request = new SingleSendSmsRequest();
					        request.setSignName(signName);//控制台创建的签名名称
					        request.setTemplateCode(templateCode);//控制台创建的模板CODE
					        JSONObject node = new JSONObject();
					        node.put("ownerName", ownerName);
					        node.put("storeName", storeName);
					        node.put("date", date);
					        node.put("giveMoney", giveMoney);
					        node.put("residueMoney", residueMoney);
					        node.put("allMoney", allMoney);
					        node.put("consumptiondetails", consumptiondetails);
					        node.put("consumptionMoney", consumptionMoney);
					        node.put("apliaydetails", apliaydetails);
					        node.put("cardnum",cardnum);
					        request.setParamString(node.toString());//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
					        request.setRecNum(sendPhone);//接收号码
					        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
					 } catch (ServerException e) {
					        e.printStackTrace();
					    }
					    catch (ClientException e) {
					        e.printStackTrace();
					    }
			}
		
		
	}
}

	 @Override
	 @Transactional
	 public List<AccessKey> queryListAccessKey(String shopcode){
		 	logger.info("=========进入查询====================");
			return sendSmsDao.queryListAccessKey(shopcode);
	 };
	 
	@Override
	@Transactional
	public AccessKey queryAccessKey(String shopcode) {
		// TODO Auto-generated method stub
		return sendSmsDao.queryAccessKey(shopcode);
	}



	@Override
	@Transactional
	public void addAccessKey(AccessKey accessKey) {
		sendSmsDao.addAccessKey(accessKey);
		
	}



	@Override
	@Transactional
	public void deleteAccessKey(AccessKey accessKey) {
		// TODO Auto-generated method stub
		sendSmsDao.deleteAccessKey(accessKey);
	}



	@Override
	@Transactional
	public void updateAccessKey(AccessKey accessKey) {
		// TODO Auto-generated method stub
		sendSmsDao.updateAccessKey(accessKey);
	}


	/*
	 * 短信模板的查看(查看本店铺所有的短信模板)
	 */
	@Override
	@Transactional
	public List<TemplateCode> queryListTemplate(String shopcode){
		// TODO Auto-generated method stub
		return sendSmsDao.queryListTemplate(shopcode);
	};
	
	@Override
	@Transactional
	public TemplateCode queryTemplateCode(String shopcode, String businessType) {
		// TODO Auto-generated method stub
		return sendSmsDao.queryTemplateCode(shopcode, businessType);
	}

	

	@Override
	@Transactional
	public void addTemplateCode(TemplateCode templateCode) {
		// TODO Auto-generated method stub
		sendSmsDao.addTemplateCode(templateCode);
	}



	@Override
	@Transactional
	public void DeleteTemplateCode(TemplateCode templateCode) {
		// TODO Auto-generated method stub
		sendSmsDao.DeleteTemplateCode(templateCode);
	}



	@Override
	@Transactional
	public void updateTemplate(TemplateCode templateCode) {
		// TODO Auto-generated method stub
		sendSmsDao.updateTemplate(templateCode);
	}
		

	
}
