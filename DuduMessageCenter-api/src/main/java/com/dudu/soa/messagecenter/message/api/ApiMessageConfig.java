package com.dudu.soa.messagecenter.message.api;


import java.util.ArrayList;

import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;
/**
 * @Title:       短信参数与模板的管理
 */
public interface ApiMessageConfig {
	
	/**
     * @Title: 查看本店铺所有的短信签名(暂时用不到)
     * @param: shopcode:店铺编码    
     */
	public ArrayList<AccessKey> queryListAccessKey(String shopcode);
	
	/**
     * @Title:       短信签名的查看
     * @param: shopcode:店铺编码
     */
	public AccessKey getAccessKey(String shopcode);
	
	/**
     * @Title:       短信签名的新增
     * @param:  AccessKey实体类
     */
	public void addAccessKey(AccessKey accessKey);
	
	/**
     * @Title:       短信签名的删除
     * 
     */
	
	public void deleteAccessKey(Integer id);
	
	/**
     * @Title:       短信签名的修改
     * @param:  AccessKey实体类
     */
	public void updateAccessKey(AccessKey accessKey);
	
	
	/**
     * @Title:    短信模板的查看(查看本店铺所有的短信模板)
     *  @param:   shopcode:店铺编码
     */
	public ArrayList<TemplateCode> queryListTemplate(String shopcode);
	
	/**
     * @Title:       短信模板的查看
     * @param:   shopcode:店铺编码
     * @param:   businessType:业务类型
     */
	public TemplateCode getTemplateCode(String shopcode, String businessType);
	/**
     * @Title:       根据id查看短信模板
     */
	public TemplateCode getByidTemplate(Integer id);
		
	/**
     * @Title:       短信模板的新增
     */
	public void addTemplateCode(TemplateCode templateCode);
	
	/**
     * @Title:       短信模板的删除
     */
	
	public void deleteTemplateCode(Integer id);
	
	/**
     * @Title:       短信模板的修改
     */
	public void updateTemplate(TemplateCode templateCode);
}


