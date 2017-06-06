package com.dudu.soa.messagecenter.message;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dudu.soa.messagecenter.TestBase;
import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;
import com.dudu.soa.messagecenter.message.service.MessageConfigService;

public class MessageConfigServiceTest extends TestBase{
	
	private static Logger logger = LoggerFactory.getLogger(MessageConfigServiceTest.class);
	@Autowired
	private MessageConfigService messageConfigService;

	@Test
	public void queryAccessKey(){
		AccessKey queryListAccessKey = messageConfigService.getAccessKey("0533001");
		System.out.println(queryListAccessKey);
	}

	@Test
	public void queryListAccessKey(){
		try {
			java.util.List<AccessKey> queryListAccessKey = messageConfigService.queryListAccessKey("店铺名");
			System.out.println(queryListAccessKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void addAccessKey(){
		
		System.out.println("机内");
		AccessKey accessKey = new AccessKey();
		accessKey.setAppkey("短信key");
		accessKey.setAppSecret("短信Secret");
		accessKey.setShopcode("店铺名");
		accessKey.setSignName("短信签名");
		accessKey.setKeyUse("true");
		messageConfigService.addAccessKey(accessKey);
	}
	
	
	@Test
	public void deleteAccessKey(){
		messageConfigService.deleteAccessKey(13);
	};
	
	@Test
	public void updateAccessKey(){
		AccessKey accessKey = new AccessKey();
		accessKey.setId(14);
		accessKey.setAppkey("短信1");
		accessKey.setAppSecret("短信1Secret");
		accessKey.setShopcode("店铺1code");
		accessKey.setSignName("短信签名1");
		accessKey.setKeyUse("false");
		messageConfigService.updateAccessKey(accessKey);
	}
	
	
	@Test
	public void queryTemplateCode(){
		TemplateCode queryTemplateCode = messageConfigService.getTemplateCode("CS000", "验证码");
		logger.debug("TemplateCode实体为:"+queryTemplateCode.toString());
	}
	@Test
	public void getByidTemplate(){
		TemplateCode queryTemplateCode = messageConfigService.getByidTemplate(24);
		logger.debug("TemplateCode实体为:"+queryTemplateCode.toString());
	}
	
	@Test
	public void queryListTemplate(){
		java.util.List<TemplateCode> queryListTemplate = messageConfigService.queryListTemplate("0533001");
		System.out.println("list集合为:"+queryListTemplate);
		logger.debug("list集合为:"+queryListTemplate.toString());
	}
	
//	
	@Test
	
	public void addTemplateCode(){
		TemplateCode templateCode = new TemplateCode();
		templateCode.setBusinessType("businessType");
		templateCode.setShopCode("shopCode");
		templateCode.setTemplateCode("templateCode");
		templateCode.setTemplateUse("false");
		messageConfigService.addTemplateCode(templateCode);
	}
	
	@Test
	
	public void DeleteTemplateCode(){
		try {
			messageConfigService.deleteTemplateCode(21);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void updateTemplate(){
		TemplateCode templateCode = new TemplateCode();
		templateCode.setId(21);
		templateCode.setBusinessType("businessType1");
		templateCode.setShopCode("shopCode1");
		templateCode.setTemplateCode("templateCode1");
		messageConfigService.updateTemplate(templateCode);
	}
}

	


