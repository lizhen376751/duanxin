package com.dudu.soa.messagecenter.message.mapper;

import java.util.ArrayList;
import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.TemplateCode;
//查询AccessKey实体用于获取调用阿里云接口的参数
public interface MessageConfigDao {
	/*
	 * 根据shopcode在AccessKey表中查询
	 * 一个shopcode对应一个短信签名
	 */
	public AccessKey getAccessKey(String shopcode);
	
	/**
     * @Title:       查看本店铺所有的短信签名
     */
	public  ArrayList<AccessKey> queryListAccessKey(String shopcode);
	
	/**
     * @Title:       短信签名的新增
     */
	
	public void addAccessKey(AccessKey accessKey);
	
	/**
     * @Title:       短信签名的删除
     */
	
	public void deleteAccessKey(Integer id);
	
	/**
     * @Title:       短信签名的修改
     */
	public void updateAccessKey(AccessKey accessKey);
	
	
	/*
	 * 根据shopcode和businessType在TemplateCode表中查询出templateCode
	 * shopcode和businessType对应一个短信模板
	 */
	public TemplateCode getTemplateCode(String shopcode,String businessType);
	/*
	 * 根据id短信模板的查看(查看本店铺所有的短信模板)
	 */
	public TemplateCode getByidTemplate(Integer id);
	/*
	 * 短信模板的查看(查看本店铺所有的短信模板)
	 */
	public ArrayList<TemplateCode> queryListTemplate(String shopcode);
	
	
	/**
     * @Title:       短信模板的新增
     */
	
	public void addTemplateCode(TemplateCode templateCode);
	
	/**
     * @Title:       短信模板的删除
     */
	
	public void deleteTemplateCode(Integer id);
	
	/**
     * @Title:       短信模板的删除
     */
	public void updateTemplate(TemplateCode templateCode);
	
}
