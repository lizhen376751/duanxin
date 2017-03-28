package com.dudu.soa.messagecenter.message.module;

import java.io.Serializable;

/**
 * 短信模板实体类
 *
 * @author lizhen 2017年3月28日
 */
public class TemplateCode implements Serializable {
    /***
     * 主键id
     */
    private Integer id;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 短信模板Code码
     */
    private String templateCode;
    /**
     * 所属业务类型
     */
    private String businessType;
    /**
     * 是否启用
     */
    private String templateUse;

    /**
     *
     * @return String String类型
     */
    public String getTemplateUse() {
        return templateUse;
    }

    /**
     *
     * @param templateUse templateUse
     */
    public void setTemplateUse(String templateUse) {
        this.templateUse = templateUse;
    }

    /**
     *
     * @return Integer Integer类型
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return String String类型
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     *
     * @param shopCode 店铺编码
     */
    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    /**
     *
     * @return String String
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     *
     * @param templateCode templateCode
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    /**
     *
     * @return String String
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     *
     * @param businessType businessType
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "TemplateCode [id=" + id + ", shopCode=" + shopCode
                + ", templateCode=" + templateCode + ", businessType="
                + businessType + ", templateUse=" + templateUse + "]";
    }


}
