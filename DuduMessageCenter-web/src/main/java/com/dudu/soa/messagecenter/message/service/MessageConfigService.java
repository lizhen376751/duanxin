package com.dudu.soa.messagecenter.message.service;

import com.dudu.soa.messagecenter.message.api.ApiMessageConfig;
import com.dudu.soa.messagecenter.message.mapper.MessageConfigDao;
import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service

public class MessageConfigService implements ApiMessageConfig {
    private static Logger logger = LoggerFactory.getLogger(MessageConfigService.class);
    @Autowired
    private MessageConfigDao messageConfigDao;

    @Override
    public ArrayList<AccessKey> queryListAccessKey(String shopcode) {
        logger.info("=========进入查询====================");
        return messageConfigDao.queryListAccessKey(shopcode);
    }

    ;

    @Override
    public AccessKey getAccessKey(String shopcode) {
        return messageConfigDao.getAccessKey(shopcode);
    }

    @Override
    @Transactional
    public void addAccessKey(AccessKey accessKey) {
        messageConfigDao.addAccessKey(accessKey);

    }


    @Override
    @Transactional
    public void deleteAccessKey(Integer id) {
        messageConfigDao.deleteAccessKey(id);
    }


    @Override
    @Transactional
    public void updateAccessKey(AccessKey accessKey) {
        messageConfigDao.updateAccessKey(accessKey);
    }


    /*
     * 短信模板的查看(查看本店铺所有的短信模板)
     */
    @Override
    public ArrayList<TemplateCode> queryListTemplate(String shopcode) {
        return messageConfigDao.queryListTemplate(shopcode);
    }


    //根据id查看短信模板
    @Override
    public TemplateCode getByidTemplate(Integer id) {
        return messageConfigDao.getByidTemplate(id);
    }

    @Override
    public TemplateCode getTemplateCode(String shopcode, String businessType) {
        TemplateCode templateCode = new TemplateCode();
        templateCode.setShopCode(shopcode);
        templateCode.setBusinessType(businessType);
        return messageConfigDao.getTemplateCode(templateCode);
    }


    @Override
    @Transactional
    public void addTemplateCode(TemplateCode templateCode) {
        messageConfigDao.addTemplateCode(templateCode);
    }


    @Override
    @Transactional
    public void deleteTemplateCode(Integer id) {
        messageConfigDao.deleteTemplateCode(id);
    }


    @Override
    @Transactional
    public void updateTemplate(TemplateCode templateCode) {
        messageConfigDao.updateTemplate(templateCode);
    }

}
