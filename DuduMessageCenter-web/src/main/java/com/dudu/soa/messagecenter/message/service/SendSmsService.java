package com.dudu.soa.messagecenter.message.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.dudu.soa.framework.pagehelp.DuduPageHelpUtil;
import com.dudu.soa.framework.pagehelp.Page;
import com.dudu.soa.messagecenter.message.api.ApiSendSms;
import com.dudu.soa.messagecenter.message.mapper.MessageConfigDao;
import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.ParameterEntry;
import com.dudu.soa.messagecenter.message.module.TemplateCode;


@Service
public class SendSmsService implements ApiSendSms{
	
	 @Autowired
	 private MessageConfigDao messageConfigDao;
	 private final static String AGOHOST="http://web.cr6868.com/asmx/smsservice.aspx?";
	 private final static String HOST = "sms.aliyuncs.com"; //API域名从控制台获取
	 private final static String REGIONID = "";
	
	 private static Logger logger = LoggerFactory.getLogger(SendSmsService.class); 
	 /**
	     * 
	    * @Title:        创瑞短信发送方式
	    * @Description:  TODO(商品绑定直属下级) 
	    * @param:        @param shopProductAddOrUpd
	    * @param:        @return    
	    * 
	     */
	
	@Override
	public void sendSMS(String shopcode, String businessType,
			List<String> recnum,ParameterEntry parameterEntry) {
		String carnum = parameterEntry.getCarnum();
		String storeName = parameterEntry.getStoreName();
		String date = parameterEntry.getDate();
		String parameter1 = parameterEntry.getParameter1();
		String parameter2 = parameterEntry.getParameter2();
		String parameter3 = parameterEntry.getParameter3();
		String parameter4 = parameterEntry.getParameter4();
		
		String sms = parameterEntry.getSms();
		String smsPwd = parameterEntry.getSmsPwd();
		String smsUser = parameterEntry.getSmsUser();
		
		
		//获取AccessKey实体
		String appkey = "";
		String appSecret = "";
		String signName = "";
		String keyuse = "";
		AccessKey accessKey = messageConfigDao.getAccessKey(shopcode);
		if(accessKey!=null && !"".equals(accessKey)){
			 appkey = accessKey.getAppkey();
			 appSecret = accessKey.getAppSecret();
			 //获取短信签名
			 signName = accessKey.getSignName();
			 //获取是否启用
			 keyuse = accessKey.getkeyuse();
		}
		
		//获取短信模板TemplateCode实体
		String templateCode = "";
		String templateUse = "";
		TemplateCode templateCodes = messageConfigDao.getTemplateCode(shopcode, businessType);
		if(templateCodes != null && !"".equals(templateCodes)){
			//短信模板code
			 templateCode = templateCodes.getTemplateCode();
			 //获取是否启用
			 templateUse = templateCodes.getTemplateUse();
		}
		
		String sendPhone = "";
		if(recnum.size()>0){
			for(int i=0;i<recnum.size();i++){
				sendPhone+=recnum.get(i);
				sendPhone+=",";
					
			}
		}
		if(recnum.size()==1){
			sendPhone = recnum.get(0);
		}
		
		 
//	        原来的短信模式不需要添加
//	        node.put("sms", sms);
//	        node.put("smsPwd", smsPwd);
//	        node.put("smsUser", smsUser);
	       
		try 
		{	//现在的短信模式
			if("true".equals(keyuse) && "true".equals(templateUse)){
					JSONObject node = new JSONObject();
			        node.put("carnum", carnum);
			        node.put("date", date);
			        node.put("storeName", storeName);
			        node.put("parameter1", parameter1);
			        node.put("parameter2", parameter2);
			        node.put("parameter3",parameter3);
			        node.put("parameter4", parameter4);
					IClientProfile profile = DefaultProfile.getProfile(REGIONID, appkey, appSecret);
					DefaultProfile.addEndpoint(REGIONID, REGIONID, "Sms",  HOST);
					IAcsClient client = new DefaultAcsClient(profile);
				    SingleSendSmsRequest request = new SingleSendSmsRequest();
			        request.setSignName(signName);//控制台创建的签名名称
			        request.setTemplateCode(templateCode);//控制台创建的模板CODE
			        request.setParamString(node.toString());//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
			        request.setRecNum(sendPhone);//接收号码
			        SingleSendSmsResponse httpResponse = client.getAcsResponse(request);					 
			}else{
				if( null != smsUser && smsUser.length() > 0 && !smsUser.isEmpty() &&
						null != recnum && recnum.size() > 0 && !recnum.isEmpty() &&
						null != smsPwd && smsPwd.length() > 0 && ! smsPwd.isEmpty() &&
								null != sms && sms.length() > 0 && !sms.isEmpty())
				{
					//原来的短信发送模式
					StringBuilder sb = new StringBuilder(AGOHOST);
					sb.append("name=" + smsUser);
					sb.append("&pwd=" + smsPwd);
					sb.append("&mobile=" + sendPhone);
					sb.append("&content=" + URLEncoder.encode(sms, "UTF-8"));
					sb.append("&stime=");
					sb.append("&sign=");
					sb.append("&type=pt&extno=");
					URL url = new URL(sb.toString());
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("POST");
					InputStream is = url.openStream();
					String returnStr = convertStreamToString(is);//返回值
				}
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
        }
	}
		
	

/**
 * 转换返回值类型为UTF-8格式.
 * @param is
 * @return
 */
private String convertStreamToString(InputStream is) {    
    StringBuilder sb1 = new StringBuilder();    
    byte[] bytes = new byte[4096];  
    int size = 0;  
    
    try {    
    	while ((size = is.read(bytes)) > 0) {  
            String str = new String(bytes, 0, size, "UTF-8");  
            sb1.append(str);  
        }  
    } catch (IOException e) {    
        e.printStackTrace();    
    } finally {    
        try {    
            is.close();    
        } catch (IOException e) {    
           e.printStackTrace();    
        }    
    }    
    return sb1.toString();    
}
	

	
}


