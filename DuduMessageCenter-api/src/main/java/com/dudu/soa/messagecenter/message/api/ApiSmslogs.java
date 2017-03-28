package com.dudu.soa.messagecenter.message.api;

import com.dudu.soa.messagecenter.message.module.SmsLogs;

import java.util.ArrayList;

/**
 * 短信记录
 */
public interface ApiSmslogs {

    /**
     * @param id id
     * @return 短信记录
     * @Title 查看短信记录详情
     */
    SmsLogs getSmsLogs(Integer id);

    /**
     * @param shopcode shopcode
     * @return 短信记录列表
     * @Title 查看所有的短信记录
     */
    ArrayList<SmsLogs> queryAllList(String shopcode);

    /**
     * @param smsLogs 实体参数
     * @return 短信记录列表
     * @Title 模糊查询
     */
    ArrayList<SmsLogs> queryByParams(SmsLogs smsLogs);


    /**
     * @param smsLogs 实体参数
     * @Title: 新增短信记录
     */

    void addSmsLogs(SmsLogs smsLogs);

    /**
     * @param id id
     * @Title: 短信记录的删除
     */

    void deleteSmsLogs(Integer id);

    /**
     * @param smsLogs 短信记录实体
     * @Title: 短信签名的修改
     */
    void updateAccessKey(SmsLogs smsLogs);
}
