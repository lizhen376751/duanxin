package com.dudu.soa.messagecenter.message;

import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.messagecenter.TestBase;
import com.dudu.soa.messagecenter.message.module.SmsLogs;
import com.dudu.soa.messagecenter.message.service.SmsLogsService;

public class SmsLogsTest  extends TestBase{
	private static Logger logger = LoggerFactory.getLogger(SmsLogsTest.class); 
	@Autowired
	private SmsLogsService smsLogsService;
	
	@Test
	public void addSmsLogs(){
		try {
			SmsLogs smsLogs =  new SmsLogs();
			smsLogs.setCarnum("7788899");
			smsLogs.setCause("成功");
			smsLogs.setDate("2015.3.6");
			smsLogs.setPhonenum("18560042032");
			smsLogs.setShopcode("053300101");
			smsLogs.setSmsname("生日提醒");
			smsLogs.setState("成功");
			smsLogsService.addSmsLogs(smsLogs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getSmsLogs(){
		try {
			SmsLogs smsLogs = smsLogsService.getSmsLogs(1);
			
			logger.info("============lizhen"+JSONObject.toJSONString(smsLogs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void queryAllList(){
		try {
		 ArrayList<SmsLogs> queryAllList = smsLogsService.queryAllList("0533001");
			logger.info("============lizhen"+JSONObject.toJSONString(queryAllList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void queryByParams(){
		try {
			SmsLogs smsLogs =  new SmsLogs();
			smsLogs.setCarnum("7788899");
			smsLogs.setCause("成功");
			smsLogs.setDate("2015.3.6");
			smsLogs.setPhonenum("18560042032");
			smsLogs.setShopcode("0533001");
			smsLogs.setSmsname("生日提醒");
			smsLogs.setState("成功");
		 ArrayList<SmsLogs> queryAllList = smsLogsService.queryByParams(smsLogs);
			logger.info("mohuchaxun===="+JSONObject.toJSONString(queryAllList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void updateAccessKey(){
		try {
			SmsLogs smsLogs =  new SmsLogs();
			smsLogs.setCarnum("7788899");
			smsLogs.setCause("成功");
			smsLogs.setDate("2015.3.6");
			smsLogs.setPhonenum("18560042032");
			smsLogs.setShopcode("0533001");
			smsLogs.setSmsname("生日提醒4");
			smsLogs.setState("成功4");
			smsLogs.setId(4);
		  smsLogsService.updateAccessKey(smsLogs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void deleteSmsLogs(){
		try {
			
		  smsLogsService.deleteSmsLogs(4);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
