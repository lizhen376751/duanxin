package com.dudu.soa.messagecenter.mapper;

import java.util.List;

import com.dudu.soa.messagecenter.module.AccessKey;
import com.dudu.soa.messagecenter.module.TemplateCode;
//查询AccessKey实体用于获取调用阿里云接口的参数
public interface SendSmsDao {
	/*
	 * 根据shopcode在AccessKey表中查询
	 * 一个shopcode对应一个短信签名
	 */
	public AccessKey queryAccessKey(String shopcode);
	
	/**
     * @Title:       查看本店铺所有的短信签名
     */
	public  List<AccessKey> queryListAccessKey(String shopcode);
	
	/**
     * @Title:       短信签名的新增
     */
	
	public void addAccessKey(AccessKey accessKey);
	
	/**
     * @Title:       短信签名的删除
     */
	
	public void deleteAccessKey(AccessKey accessKey);
	
	/**
     * @Title:       短信签名的修改
     */
	public void updateAccessKey(AccessKey accessKey);
	
	
	/*
	 * 根据shopcode和businessType在TemplateCode表中查询出templateCode
	 * shopcode和businessType对应一个短信模板
	 */
	public TemplateCode queryTemplateCode(String shopcode,String businessType);
	
	/*
	 * 短信模板的查看(查看本店铺所有的短信模板)
	 */
	public List<TemplateCode> queryListTemplate(String shopcode);
	
	
	/**
     * @Title:       短信模板的新增
     */
	
	public void addTemplateCode(TemplateCode templateCode);
	
	/**
     * @Title:       短信模板的删除
     */
	
	public void DeleteTemplateCode(TemplateCode templateCode);
	
	/**
     * @Title:       短信模板的删除
     */
	public void updateTemplate(TemplateCode templateCode);
	
}
