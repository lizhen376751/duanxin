package com.dudu.soa.basedata.sms.sendsms.service;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dudu.soa.basedata.sms.service.SendSmsService;
import com.dudu.soa.message.basedata.sms.module.ParameterEntry;
import com.mchange.v2.beans.swing.TestBean;
import com.sun.tools.javac.util.List;

public class SendSmsTest {
	
	@Autowired
	private SendSmsService sendSmsService;
	
	@Test
	public void ss() throws Exception {
		try{
		sendSmsService.addIntroduced();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendSMS() throws Exception{
		try{
		ParameterEntry parameterEntry = new ParameterEntry();
		ArrayList<String> recnum = new ArrayList<String>();
		recnum.add("18560042032");
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
		sendSmsService.sendSMS(parameterEntry);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
