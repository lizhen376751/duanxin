package com.dudu.soa.messagecenter.message.service;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;
import com.dudu.soa.messagecenter.message.api.ApiSendSms;
import com.dudu.soa.messagecenter.message.mapper.MessageConfigDao;
import com.dudu.soa.messagecenter.message.mapper.SmsLogsDao;
import com.dudu.soa.messagecenter.message.module.AccessKey;
import com.dudu.soa.messagecenter.message.module.MessageEntry;
import com.dudu.soa.messagecenter.message.module.ParameterEntry;
import com.dudu.soa.messagecenter.message.module.SmsLogs;
import com.dudu.soa.messagecenter.message.module.TemplateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 短信发送的service
 */
@Service
public class SendSmsService implements ApiSendSms {
    /**
     * 日志打印
     */
    private static Logger log = LoggerFactory.getLogger(SendSmsService.class);
    /**
     * 发送网址
     */
    private final String aGOHOST = "http://web.cr6868.com/asmx/smsservice.aspx?";
    /**
     * API域名从控制台获取
     */
    private final String hOST = "sms.aliyuncs.com";
    /**
     *
     */
    private final String rEGIONID = "";
    /**
     * 引入短信配置dao层
     */
    @Autowired
    private MessageConfigDao messageConfigDao;
    /**
     * 短信日志dao
     */
    @Autowired
    private SmsLogsDao smsLogsDao;
    /**
     * 短信配置的方法
     */
    @Autowired
    private MessageConfigService messageConfigService;


    /**
     * @param shopcode       店铺编码
     * @param businessType   业务类型
     * @param recnum         发送的手机号码
     * @param parameterEntry 实体类
     * @return 是否发送成功或错误原因
     */
    @Transactional
    @Override
    public String sendSMS(String shopcode, String businessType,
                          List<String> recnum, ParameterEntry parameterEntry) {


        //返回的状态码
        String feedback = "";
        //获取车牌号
        String carnum = parameterEntry.getCarnum();
        //获取店铺名称
        String storeName = parameterEntry.getStoreName();
        //获取日期
        String date = parameterEntry.getDate();
        //获取短信内容的参数
        String parameter1 = parameterEntry.getParameter1();
        String parameter2 = parameterEntry.getParameter2();
        String parameter3 = parameterEntry.getParameter3();
        String parameter4 = parameterEntry.getParameter4();

        //获取创瑞短信相关的配置
        String sms = parameterEntry.getSms();
        String smsPwd = parameterEntry.getSmsPwd();
        String smsUser = parameterEntry.getSmsUser();


        //获取AccessKey实体
        String appkey = "";
        String appSecret = "";
        String signName = "";
        String endpoint = "";
        String topic1 = "";
        String keyuse = "";
        AccessKey accessKey = messageConfigDao.getAccessKey(shopcode);
        if (accessKey != null) {
            endpoint = accessKey.getEndpoint().trim();
            topic1 = accessKey.getTopic().trim();
            appkey = accessKey.getAppkey().trim();
            appSecret = accessKey.getAppSecret().trim();
            signName = accessKey.getSignName().trim();
            keyuse = accessKey.getKeyUse().trim();
        }

        //获取短信模板TemplateCode实体
        String templateCode = "";
        String templateUse = "";
        TemplateCode templateCodes = messageConfigService.getTemplateCode(shopcode, businessType);
        if (templateCodes != null && !"".equals(templateCodes)) {
            templateCode = templateCodes.getTemplateCode().trim();
            templateUse = templateCodes.getTemplateUse();
        }
        //短信发送状态
        String state = "";
        try {
            if ("true".equals(keyuse) && "true".equals(templateUse)) {
                log.info("阿里云短信===============================");
                /**
                 * Step 1. 获取主题引用
                 *
                 */
                CloudAccount account = new CloudAccount(appkey, appSecret, endpoint);
                MNSClient client = account.getMNSClient();
                CloudTopic topic = client.getTopicRef(topic1);
                /**
                 * Step 2. 设置SMS消息体（必须）
                 *
                 * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
                 */
                RawTopicMessage msg = new RawTopicMessage();
                msg.setMessageBody("sms-message");
                /**
                 * Step 3. 生成SMS消息属性
                 */
                MessageAttributes messageAttributes = new MessageAttributes();
                BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
                // 3.1 设置发送短信的签名（SMSSignName）
                batchSmsAttributes.setFreeSignName(signName);
                // 3.2 设置发送短信使用的模板（SMSTempateCode）
                batchSmsAttributes.setTemplateCode(templateCode);
                // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
                BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
                smsReceiverParams.setParam("carnum", carnum);
                smsReceiverParams.setParam("date", date);
                smsReceiverParams.setParam("storeName", storeName);
                smsReceiverParams.setParam("parameter1", parameter1);
                smsReceiverParams.setParam("parameter2", parameter2);
                smsReceiverParams.setParam("parameter3", parameter3);
                smsReceiverParams.setParam("parameter4", parameter4);
                // 3.4 增加接收短信的号码
                if (recnum.size() > 0) {
                    for (int i = 0; i < recnum.size(); i++) {
                        batchSmsAttributes.addSmsReceiver(recnum.get(i), smsReceiverParams);
                    }
                }
                messageAttributes.setBatchSmsAttributes(batchSmsAttributes);

                /**
                 * Step 4. 发布SMS消息
                 */
                TopicMessage ret = topic.publishMessage(msg, messageAttributes);
                log.info("MessageId: " + ret.getMessageId());
                log.info("MessageMD5: " + ret.getMessageBodyMD5());
                state = "成功";
                feedback = "阿里云短信发送成功";
                client.close();
            } else if (null != smsUser && smsUser.length() > 0 && !smsUser.isEmpty()
                    && null != recnum && recnum.size() > 0 && !recnum.isEmpty()
                    && null != smsPwd && smsPwd.length() > 0 && !smsPwd.isEmpty()
                    && null != sms && sms.length() > 0 && !sms.isEmpty()) {
                //封装手机号,多个手机号以逗号进行分割
                String sendPhone = "";
                if (recnum.size() > 0) {
                    for (int i = 0; i < recnum.size(); i++) {
                        sendPhone += recnum.get(i);
                        sendPhone += ",";
                    }
                }
                if (recnum.size() == 1) {
                    sendPhone = recnum.get(0);
                }
                //原来的短信发送模式
                StringBuilder sb = new StringBuilder(aGOHOST);
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
                log.info("创瑞短信发送模式");
                state = "成功";
                feedback = convertStreamToString(is); //返回值
            }
        } catch (Exception e) {
            e.printStackTrace();
            state = "失败";
            feedback = e.getMessage();
        }

        if (recnum.size() > 0) {
            for (int i = 0; i < recnum.size(); i++) {
                SmsLogs smsLogs = new SmsLogs();
                //创建短信记录的实体类
                smsLogs.setCarnum(carnum);
                SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                String date1 = sdf.format(new Date());
                smsLogs.setDate(date1);
                smsLogs.setShopcode(shopcode);
                smsLogs.setSmsname(businessType);
                smsLogs.setPhonenum(recnum.get(i));
                if (!state.equals("成功")) {
                    state = "失败";
                    if (accessKey == null) {
                        feedback = "阿里云账号配置错误!";
                    }
                    if (templateCodes == null) {
                        feedback = "短信模板配置错误!";
                    }
                    if (accessKey == null && templateCodes == null) {
                        feedback = "阿里云账号,短信模板配置错误!";
                    }
                }
                smsLogs.setState(state);
                smsLogs.setCause(feedback);
                smsLogsDao.addSmsLogs(smsLogs);
            }
        }
        return feedback;
    }


    /**
     * 字符串的转换
     *
     * @param is 流
     * @return 字符串
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
        String ss = "";
        if (sb1.toString().length() > 51) {
            ss = sb1.toString().substring(0, 50);
        } else {
            ss = sb1.toString();
        }
        return ss;
    }


    /**
     * 短信发送和第一个一样的,只不过入参不一样
     *
     * @param messageEntry 短信参数实体类
     * @return
     */
    @Override
    public String sendSMS2(MessageEntry messageEntry) {
        ParameterEntry parameterEntry = new ParameterEntry();
        parameterEntry.setCarnum(messageEntry.getCarnum());
        parameterEntry.setDate(messageEntry.getDate());
        parameterEntry.setStoreName(messageEntry.getStoreName());
        parameterEntry.setSms(messageEntry.getSms());
        parameterEntry.setSmsPwd(messageEntry.getSmsPwd());
        parameterEntry.setSms(messageEntry.getSms());
        parameterEntry.setSmsUser(messageEntry.getSmsUser());
        parameterEntry.setParameter1(messageEntry.getParameter1());
        parameterEntry.setParameter2(messageEntry.getParameter2());
        parameterEntry.setParameter3(messageEntry.getParameter3());
        parameterEntry.setParameter4(messageEntry.getParameter4());
        String shopcode = messageEntry.getShopcode();
        String businessType = messageEntry.getBusinessType();
        List<String> list = messageEntry.getList();
        String sendSMS = sendSMS(shopcode, businessType, list, parameterEntry);
        return sendSMS;
    }


    /**
     * 错误提示
     *
     * @param errorMess 错误代码
     * @return 字符串
     */
    private String feedback(String errorMess) {
        errorMess = errorMess.toString();
        String error1 = "The specified dayu status is wrongly formed";
        String mess1 = "账户短信开通状态不正确!";
        String error2 = "The specified sign name is wrongly formed";
        String mess2 = "短信签名不正确或签名状态不正确!";
        String error3 = "The specified templateCode is wrongly formed";
        String mess3 = "短信模板Code不正确或者模板状态不正确!";
        String error4 = "The specified recNum is wrongly formed";
        String mess4 = "目标手机号不正确，单次发送数量不能超过100!";
        String error5 = "The specified paramString and template is wrongly formed";
        String mess5 = "短信模板中变量与模板内容不匹配!";
        String error6 = "The specified paramString and template is wrongly formed";
        String mess6 = "参数变量过长,已超过15个字符!";
        if (errorMess.contains(error1)) {
            errorMess = mess1;
        }
        if (errorMess.contains(error2)) {
            errorMess = mess2;
        }
        if (errorMess.contains(error3)) {
            errorMess = mess3;
        }
        if (errorMess.contains(error4)) {
            errorMess = mess4;
        }
        if (errorMess.contains(error5)) {
            errorMess = mess5;
        }
        if (errorMess.contains(error6)) {
            errorMess = mess6;
        }
        return errorMess;
    }

}
