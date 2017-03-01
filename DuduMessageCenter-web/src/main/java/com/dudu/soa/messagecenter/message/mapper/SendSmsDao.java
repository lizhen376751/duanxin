package com.dudu.soa.messagecenter.message.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dudu.soa.messagecenter.module.AccessKey1;
import com.dudu.soa.messagecenter.module.TemplateCode1;
//查询AccessKey实体用于获取调用阿里云接口的参数
public interface SendSmsDao {
	/*
	 * 根据shopcode在AccessKey表中查询
	 * 一个shopcode对应一个短信签名
	 */
	public AccessKey1 queryAccessKey(String shopcode);
	
	/**
     * @Title:       查看本店铺所有的短信签名
     */
	public  ArrayList<AccessKey1> queryListAccessKey(String shopcode);
	
	/**
     * @Title:       短信签名的新增
     */
	
	public void addAccessKey(AccessKey1 accessKey);
	
	/**
     * @Title:       短信签名的删除
     */
	
	public void deleteAccessKey(AccessKey1 accessKey);
	
	/**
     * @Title:       短信签名的修改
     */
	public void updateAccessKey(AccessKey1 accessKey);
	
	
	/*
	 * 根据shopcode和businessType在TemplateCode表中查询出templateCode
	 * shopcode和businessType对应一个短信模板
	 */
	public TemplateCode1 queryTemplateCode(String shopcode,String businessType);
	/*
	 * 根据id短信模板的查看(查看本店铺所有的短信模板)
	 */
	public TemplateCode1 getByidTemplate(Integer id);
	/*
	 * 短信模板的查看(查看本店铺所有的短信模板)
	 */
	public ArrayList<TemplateCode1> queryListTemplate(String shopcode);
	
	
	/**
     * @Title:       短信模板的新增
     */
	
	public void addTemplateCode(TemplateCode1 templateCode);
	
	/**
     * @Title:       短信模板的删除
     */
	
	public void DeleteTemplateCode(TemplateCode1 templateCode);
	
	/**
     * @Title:       短信模板的删除
     */
	public void updateTemplate(TemplateCode1 templateCode);
	
}
