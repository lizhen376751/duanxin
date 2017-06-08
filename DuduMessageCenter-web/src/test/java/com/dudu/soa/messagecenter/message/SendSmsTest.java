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
	public void sendSMS(){
		try{
			ParameterEntry  parameterEntry = new ParameterEntry();
			List<String> list = new ArrayList();
			list.add("18560042032");
//			parameterEntry.setCarnum("鲁A15155");
			parameterEntry.setDate("6月8日17:01");
			parameterEntry.setParameter1("消费清洗座椅:1.00次");
			parameterEntry.setParameter2("203201");
			parameterEntry.setParameter3("清洗座椅:3.00次(2018-06-07)");
			parameterEntry.setParameter4(null);
			parameterEntry.setSms("尊敬的鲁a2032车主，您于6月8日17:01时在福州美车会汽车美容会所消费清洗座椅:1.00次，您卡内还剩余清洗座椅:3.00次(2018-06-07)。【天成业主】");
			parameterEntry.setSmsPwd("A3934081D6F869C3295618159571");
			parameterEntry.setSmsUser("GL_tiancheng");
			parameterEntry.setStoreName("福州美车会汽车美容会所");
			logger.info("+++=======短信实体类"+parameterEntry);
			String s = sendSmsService.sendSMS("0533001", "卡相关", list, parameterEntry);
			logger.info("+++=======短信发送状态"+s);

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

