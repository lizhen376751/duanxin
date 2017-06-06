package com.dudu.soa.messagecenter.message;

import com.dudu.soa.messagecenter.TestBase;
import com.dudu.soa.messagecenter.message.module.ParameterEntry;
import com.dudu.soa.messagecenter.message.service.SendSmsService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SendSmsTest extends TestBase{
	
	private static Logger logger = LoggerFactory.getLogger(SendSmsTest.class); 
	@Autowired
	private SendSmsService sendSmsService;
	@Test
	public void sendSMS() throws Exception{
		try{
			ParameterEntry  parameterEntry = new ParameterEntry();
			List<String> list = new ArrayList();
			list.add("18560042032");
			parameterEntry.setCarnum("carnum");
			parameterEntry.setDate("date");
			parameterEntry.setParameter1("063233");
			parameterEntry.setParameter2("parameter2");
			parameterEntry.setParameter3("parameter3");
			parameterEntry.setParameter4("parameter4");
//			parameterEntry.setSms("尊敬的鲁a2032车主，感谢您在福州美车会汽车美容会所进行的消费，您有任何问题和意见可以随时进行咨询及反馈,请您对本次服务进行评,感谢您的支持，祝您生活愉快!(回复1为不满意，2为满意）【天成业主】");
//			parameterEntry.setSmsPwd("A3934081D6F869C3295618159571");
//			parameterEntry.setSmsUser("GL_tiancheng");
			parameterEntry.setStoreName("storeName");
			System.out.println("+++=======短信实体类"+parameterEntry);
		    sendSmsService.sendSMS("000001", "验证码", list, parameterEntry);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	
	@Test
	public void sendSMS2() throws Exception{
		try{
			ParameterEntry  parameterEntry = new ParameterEntry();
			List<String> list = new ArrayList();
			list.add("18560042");
			parameterEntry.setCarnum("carnum");
			parameterEntry.setDate("date");
			parameterEntry.setParameter1("parameter1");
			parameterEntry.setParameter2("parameter2");
			parameterEntry.setParameter3("parameter3");
			parameterEntry.setParameter4("parameter4");
			parameterEntry.setSms("尊敬的12车主，您的车辆保险将于12到期。【天成车业】");
			parameterEntry.setSmsPwd("A3934081D6F869C3295618159571");
			parameterEntry.setSmsUser("GL_tiancheng");
			parameterEntry.setStoreName("storeName");
			System.out.println("+++=======短信实体类"+parameterEntry);
		    String sendSMS2 = sendSmsService.sendSMS2("", "测试", list, parameterEntry);
		    System.out.println(sendSMS2);
		}catch(Exception e){
		e.printStackTrace();
	}
	}
}

