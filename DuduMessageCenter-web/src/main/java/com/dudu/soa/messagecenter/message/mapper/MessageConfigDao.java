package com.dudu.soa.messagecenter.message.mapper;

import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;

import java.util.ArrayList;


/**
 * 查询AccessKey实体用于获取调用阿里云接口的参数
 * 一个shopcode对应一个短信签名
 */
public interface MessageConfigDao {

    /**
     * 根据shopcode在AccessKey表中查询
     *
     * @param shopcode 店铺代码
     * @return appid和sercert
     */
    AccessKey getAccessKey(String shopcode);

    /**
     * 查看本店铺所有的短信签名
     *
     * @param shopcode 店铺代码
     * @return 集合
     */
    ArrayList<AccessKey> queryListAccessKey(String shopcode);

    /**
     * 短信签名的新增
     *
     * @param accessKey 短信设置
     */
    void addAccessKey(AccessKey accessKey);

    /**
     * 短信签名的删除
     *
     * @param id 主键id
     */
    void deleteAccessKey(Integer id);

    /**
     * 短信签名的修改
     *
     * @param accessKey 修改短信的appid配置
     */
    void updateAccessKey(AccessKey accessKey);


    /**
     * 根据shopcode和businessType在TemplateCode表中查询出templateCode
     * shopcode和businessType对应一个短信模板
     *
     * @param templateCode 模板
     * @return 模板实体类
     */
    TemplateCode getTemplateCode(TemplateCode templateCode);

    /*
     * 根据id短信模板的查看(查看本店铺所有的短信模板)
     */

    /**
     * 根据id查询模板
     *
     * @param id 主键id
     * @return 模板实体类
     */
    TemplateCode getByidTemplate(Integer id);

    /**
     * 短信模板的查看(查看本店铺所有的短信模板)
     *
     * @param shopcode 店铺代码
     * @return 模板的集合
     */
    ArrayList<TemplateCode> queryListTemplate(String shopcode);

    /**
     * 短信模板的新增
     *
     * @param templateCode 模板实体类
     */
    void addTemplateCode(TemplateCode templateCode);

    /**
     * 短信模板的删除
     *
     * @param id 主键id
     */
    void deleteTemplateCode(Integer id);

    /**
     * 短信模板的删除
     *
     * @param templateCode 模板
     */
    void updateTemplate(TemplateCode templateCode);

}
