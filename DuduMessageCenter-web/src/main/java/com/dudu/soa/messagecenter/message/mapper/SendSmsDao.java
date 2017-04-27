package com.dudu.soa.messagecenter.message.mapper;

import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;

import java.util.ArrayList;

/**
 * 查询AccessKey实体用于获取调用阿里云接口的参数
 */
public interface SendSmsDao {

    /**
     * 根据shopcode在AccessKey表中查询
     * 一个shopcode对应一个短信签名
     *
     * @param shopcode 店铺代码
     * @return 短信的appid和sercert
     */
    AccessKey queryAccessKey(String shopcode);


    /**
     * 查看本店铺所有的短信签名
     *
     * @param shopcode 店铺代码
     * @return 短信配置列表
     */
    ArrayList<AccessKey> queryListAccessKey(String shopcode);

    /**
     * 短信签名的新增
     *
     * @param accessKey 短信配置
     */
    void addAccessKey(AccessKey accessKey);

    /**
     * 短信签名的删除
     *
     * @param accessKey 短信配置
     */
    void deleteAccessKey(AccessKey accessKey);

    /**
     * 短信签名的修改
     *
     * @param accessKey 短信配置
     */
    void updateAccessKey(AccessKey accessKey);

    /**
     * 根据shopcode和businessType在TemplateCode表中查询出templateCode
     * shopcode和businessType对应一个短信模板
     *
     * @param shopcode     店铺代码
     * @param businessType 业务类型
     * @return 短信模板
     */
    TemplateCode queryTemplateCode(String shopcode, String businessType);

    /**
     * 根据id短信模板的查看(查看本店铺所有的短信模板)
     *
     * @param id 模板id
     * @return 短信模板
     */
    TemplateCode getByidTemplate(Integer id);


    /**
     * 短信模板的查看(查看本店铺所有的短信模板)
     *
     * @param shopcode 店铺编码
     * @return 短信模板的集合
     */
    ArrayList<TemplateCode> queryListTemplate(String shopcode);

    /**
     * 短信模板的新增
     *
     * @param templateCode 短信模板
     */
    void addTemplateCode(TemplateCode templateCode);

    /**
     * 短信模板的删除
     *
     * @param templateCode 短信模板
     */
    void deleteTemplateCode(TemplateCode templateCode);

    /**
     * 短信模板的删除
     *
     * @param templateCode 短信模板
     */
    void updateTemplate(TemplateCode templateCode);

}
