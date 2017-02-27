package com.dudu.soa.messagecenter;

import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dudu.soa.messagecenter.module.AccessKey;
import com.dudu.soa.messagecenter.module.ParameterEntry;
import com.dudu.soa.messagecenter.module.TemplateCode;
import com.dudu.soa.messagecenter.service.SendSmsService;
import com.mchange.v2.beans.swing.TestBean;
import com.sun.tools.javac.util.List;


public class SendSmsTest extends TestBase{
	
	 private static Logger logger = LoggerFactory.getLogger(SendSmsTest.class); 
	@Autowired
	private SendSmsService sendSmsService;
	
	
	
	@Test
	public void sendSMS() throws Exception{
		try{
			ParameterEntry  parameterEntry = new ParameterEntry();
			ArrayList<String> recnum = new ArrayList<String>();
			recnum.add("18560042032");
			parameterEntry.setShopcode("");
			parameterEntry.setBusinessType("卡相关");
			parameterEntry.setRecnum(recnum);
			parameterEntry.setDate("2月23日23:20");
			parameterEntry.setOwnerName("鲁A01001");
			parameterEntry.setStoreName("福州美车会汽车美容会所");
			parameterEntry.setResidueMoney("9287.00元");
			parameterEntry.setConsumptionMoney("消费金额0.00元");
			parameterEntry.setCardnum("666666");
			System.out.println("+++=======短信实体类"+parameterEntry);
		    sendSmsService.sendSMS(parameterEntry);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	@Test
	public void queryAccessKey(){
		AccessKey queryListAccessKey = sendSmsService.queryAccessKey("0533001");
		System.out.println(queryListAccessKey);
	};
	
	@Test
	public void queryListAccessKey(){
		java.util.List<AccessKey> queryListAccessKey = sendSmsService.queryListAccessKey("店铺名");
		System.out.println(queryListAccessKey);
	};
	
	
	@Test
	public void addAccessKey(){
		
		System.out.println("机内");
		AccessKey accessKey = new AccessKey();
		accessKey.setAppkey("短信key");
		accessKey.setAppSecret("短信Secret");
		accessKey.setShopcode("店铺名");
		accessKey.setSignName("短信签名");
		sendSmsService.addAccessKey(accessKey);
	};
	
	
	@Test
	public void deleteAccessKey(){
		AccessKey accessKey = new AccessKey();
		accessKey.setId(2);
		sendSmsService.deleteAccessKey(accessKey);
	};
	
	@Test
	public void updateAccessKey(){
		AccessKey accessKey = new AccessKey();
		accessKey.setId(2);
		accessKey.setAppkey("短信1");
		accessKey.setAppSecret("短信1Secret");
		accessKey.setShopcode("店铺1code");
		accessKey.setSignName("短信签名1");
		sendSmsService.updateAccessKey(accessKey);
	};
	
	
	@Test
	public void queryTemplateCode(){
		TemplateCode queryTemplateCode = sendSmsService.queryTemplateCode("shopcode", "businessType");
		logger.debug("TemplateCode实体为:"+queryTemplateCode.toString());
	};
	
	@Test
	public void queryListTemplate(){
		java.util.List<TemplateCode> queryListTemplate = sendSmsService.queryListTemplate("0533001");
		System.out.println("list集合为:"+queryListTemplate);
		logger.debug("list集合为:"+queryListTemplate.toString());
	};
	
//	
	@Test
	
	public void addTemplateCode(){
		TemplateCode templateCode = new TemplateCode();
		templateCode.setBusinessType("businessType");
		templateCode.setShopCode("shopCode");
		templateCode.setTemplateCode("templateCode");
		sendSmsService.addTemplateCode(templateCode);
	};
	
	@Test
	
	public void DeleteTemplateCode(){
		TemplateCode templateCode = new TemplateCode();
		templateCode.setId(17);
		sendSmsService.DeleteTemplateCode(templateCode);
	};
	
	@Test
	public void updateTemplate(){
		TemplateCode templateCode = new TemplateCode();
		templateCode.setId(17);
		templateCode.setBusinessType("businessType1");
		templateCode.setShopCode("shopCode1");
		templateCode.setTemplateCode("templateCode1");
		
		sendSmsService.updateTemplate(templateCode);
	};
}


