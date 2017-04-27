package com.dudu.soa.messagecenter.message.mapper;

import java.util.ArrayList;

import com.dudu.soa.messagecenter.message.module.SmsLogs;

/**
 * 短信记录
 */
public interface SmsLogsDao {

	/**
	 * 短信日志
	 * @param id 主键id
	 * @return 短信日志
	 */
	 SmsLogs getSmsLogs(Integer id);

	/**
	 * 查看所有的短信记录
	 * @param shopcode 店铺编码
	 * @return 短信集合
	 */
	  ArrayList<SmsLogs> queryAllList(String shopcode);

	/**
	 * 模糊查询
	 * @param smsLogs 短信日志
	 * @return
	 */
	  ArrayList<SmsLogs> queryByParams(SmsLogs smsLogs);

	/**
	 * 新增短信记录
	 * @param smsLogs 短信日志
	 */
	 void addSmsLogs(SmsLogs smsLogs);

	/**
	 * 短信记录的删除
	 * @param id 逐渐id
	 */
	 void deleteSmsLogs(Integer id);

	/**
	 * 短信签名的修改
	 * @param smsLogs 短信日志
	 */
	 void updateAccessKey(SmsLogs smsLogs);

}
