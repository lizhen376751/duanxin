package com.dudu.soa.messagecenter.api;

import java.util.ArrayList;
import java.util.List;

import com.dudu.soa.messagecenter.module.AccessKey;
import com.dudu.soa.messagecenter.module.ParameterEntry;
import com.dudu.soa.messagecenter.module.TemplateCode;

public interface ApiSendSms {
	
	 /**
     * 
    * @Title:       发送短信消息
    * @Description: 
    * @param ParameterEntry (构建实体类,只需要传入发送短信的参数即可,不传默认为空)
    * @param:          
    * @Date     
     */
	public void sendSMS(ParameterEntry parameterEntry);
	
	/**
     * @Title:       查看本店铺所有的短信签名
     */
	public ArrayList queryListAccessKey(String shopcode);
	
	/**
     * @Title:       短信签名的查看
     */
	public AccessKey queryAccessKey(String shopcode);
	
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
	 * 短信模板的查看(查看本店铺所有的短信模板)
	 */
	public ArrayList queryListTemplate(String shopcode);
	
	/**
     * @Title:       短信模板的查看
     */
	public TemplateCode queryTemplateCode(String shopcode, String businessType);
	
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
