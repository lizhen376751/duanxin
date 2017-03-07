package com.dudu.soa.messagecenter.message.api;

import java.util.ArrayList;

import com.dudu.soa.messagecenter.message.module.SmsLogs;

public interface ApiSmslogs {
	/*
	*查看短信记录详情
	 */
	public SmsLogs getSmsLogs(Integer id);
	
	/**
     * @Title:查看所有的短信记录
     */
	public  ArrayList<SmsLogs> queryAllList(String shopcode);
	
	/**
     * @Title:模糊查询
     */
	public  ArrayList<SmsLogs> queryByParams(SmsLogs smsLogs);
	
	
	/**
     * @Title: 新增短信记录
     */
	
	public void addSmsLogs(SmsLogs smsLogs);
	
	/**
     * @Title:  短信记录的删除
     */
	
	public void deleteSmsLogs(Integer id);
	
	/**
     * @Title:  短信签名的修改
     */
	public void updateAccessKey(SmsLogs smsLogs);
}
