package com.dudu.soa.messagecenter.message.api;


import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;

import java.util.ArrayList;

/**
 * @Title: 短信参数与模板的管理
 */
public interface ApiMessageConfig {

    /**
     * @param shopcode 店铺编码
     * @return 短信参数的集合
     * @Title 查看本店铺所有的短信签名(暂时用不到)
     */
    ArrayList<AccessKey> queryListAccessKey(String shopcode);

    /**
     * @param shopcode 店铺编码
     * @return 短信签名
     * @Title 短信签名的查看
     */
    AccessKey getAccessKey(String shopcode);

    /**
     * @param accessKey 实体类
     * @Title 短信签名的新增
     */
    void addAccessKey(AccessKey accessKey);

    /**
     * @param id 主键id
     * @Title: 短信签名的删除
     */

    void deleteAccessKey(Integer id);

    /**
     * @param accessKey 实体类
     * @Title 短信签名的修改
     */
    void updateAccessKey(AccessKey accessKey);


    /**
     * @param shopcode 店铺编码
     * @return 短信模板集合
     * @Title 短信模板的查看(查看本店铺所有的短信模板)
     */
    ArrayList<TemplateCode> queryListTemplate(String shopcode);

    /**
     * @param shopcode     店铺编码
     * @param businessType 业务类型
     * @return 短信模板
     * @Title 短信模板的查看
     */
    TemplateCode getTemplateCode(String shopcode, String businessType);

    /**
     * @param id id
     * @return 短信模板
     * @Title 根据id查看短信模板
     */
    TemplateCode getByidTemplate(Integer id);

    /**
     * @param templateCode 短信模板
     * @Title 短信模板的新增
     */
    void addTemplateCode(TemplateCode templateCode);

    /**
     * @param id id
     * @Title 短信模板的删除
     */

    void deleteTemplateCode(Integer id);

    /**
     * @param templateCode 短信模板
     * @Title 短信模板的修改
     */
    void updateTemplate(TemplateCode templateCode);
}


