package com.dudu.soa.messagecenter.message.service;

import com.dudu.soa.framework.pagehelp.DuduPageHelpUtil;
import com.dudu.soa.messagecenter.message.api.ApiSmslogs;
import com.dudu.soa.messagecenter.message.mapper.SmsLogsDao;
import com.dudu.soa.messagecenter.message.module.SmsLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * 短信日志
 */
@Service
public class SmsLogsService implements ApiSmslogs {
    /**
     * 引入短信发送dao
     */
    @Autowired
    private SmsLogsDao smsLogsDao;

    @Override
    public SmsLogs getSmsLogs(Integer id) {
        return smsLogsDao.getSmsLogs(id);
    }

    @Override
    public ArrayList<SmsLogs> queryAllList(String shopcode) {

        return smsLogsDao.queryAllList(shopcode);
    }

    @Override
    public ArrayList<SmsLogs> queryByParams(SmsLogs smsLogs) {
        DuduPageHelpUtil.query("id");
        return smsLogsDao.queryByParams(smsLogs);
    }

    @Override
    @Transactional
    public void addSmsLogs(SmsLogs smsLogs) {

        smsLogsDao.addSmsLogs(smsLogs);
    }

    @Override
    @Transactional
    public void deleteSmsLogs(Integer id) {

        smsLogsDao.deleteSmsLogs(id);
    }

    @Override
    @Transactional
    public void updateAccessKey(SmsLogs smsLogs) {

        smsLogsDao.updateAccessKey(smsLogs);
    }

}
