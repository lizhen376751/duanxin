package com.dudu.soa.messagecenter.message.service;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;
import com.dudu.soa.messagecenter.message.mapper.MessageConfigDao;
import com.dudu.soa.messagecenter.message.mapper.SmsLogsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 新的短信接口
 * Created by lizhen on 2017/5/22.
 */

public class NewMessageService {
    //    $YourAccessId，阿里云AccessId，可在“步骤一”获取（登陆阿里云 AccessKey 管理页面创建、查看）
//    $YourAccessKey，阿里云AccessKey，可在“步骤一”获取（登陆阿里云 AccessKey 管理页面创建、查看）
//    $YourMNSEndpoint，访问MNS服务的接入地址，可在“步骤一”获取（登陆MNS控制台，单击右上角“获取Endpoint”查看，选择公网地址）
//    $YourTopic，发送短信使用的主题，可在“步骤二”获取，建议使用短信专用主题（进入控制台短信概览页，获取主题名称）
//    $YourSignName，发送短信使用的签名，可在here获取
//    $YourSMSTemplateCode，发送短信使用的模板Code，可在here获取
//    $YourSMSTemplateParamKey1，所指定短信模板中定义的参数名（“{}”中的内容），没有可不指定；可在here查看模板中的变量，注：key 和 value 都必须是字符串形式。
//LTAI1TaGHkgHnQlh     PVpsm30Lz2B1URtUZXs4wRa8sYNTHN
    /**
     * 日志打印
     */
    private static Logger log = LoggerFactory.getLogger(NewMessageService.class);
    /**
     * 创瑞短信发送网址
     */
    private final String aGOHOST = "http://web.cr6868.com/asmx/smsservice.aspx?";
    /**
     * 引入短信配置dao层
     */
    @Autowired
    private MessageConfigDao messageConfigDao;
    /**
     * 短信配置的方法
     */
    @Autowired
    private MessageConfigService messageConfigService;
    /**
     * 短信日志dao
     */
    @Autowired
    private SmsLogsDao smsLogsDao;

    /**
     * 发送短信
     *
     * @param args 数组
     */
    public static void main(String[] args) {

        /**
         * Step 1. 获取主题引用
         *
         */
//        CloudAccount account = new CloudAccount("LTAI1TaGHkgHnQlh", "bmjmiW2SYYGnqmSyNLWXA94yP5AKGj", "https://1865687059384333.mns.cn-hangzhou.aliyuncs.com/");
        CloudAccount account = new CloudAccount("LTAItFAKjkOvqssX", "PVpsm30Lz2B1URtUZXs4wRa8sYNTHN", "https://1458672996257650.mns.cn-hangzhou.aliyuncs.com/");
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef("sms.topic-cn-hangzhou");
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

//        // 3.1 设置发送短信的签名（SMSSignName）
//        batchSmsAttributes.setFreeSignName("生日祝福");
//        // 3.2 设置发送短信使用的模板（SMSTempateCode）
//        batchSmsAttributes.setTemplateCode("SMS_62615074");

        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName("怡人怡车");
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode("SMS_62615074");
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("parameter1", "你好");
        smsReceiverParams.setParam("parameter1", "18560042032");
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver("18560042032", smsReceiverParams);
//        batchSmsAttributes.addSmsReceiver("$YourReceiverPhoneNumber2", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. 发布SMS消息
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            System.out.println(ret.getMessageBody() + "少时诵诗书: " + ret.getMessageTag());
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        } catch (ServiceException se) {
            log.info(se.getErrorCode() + se.getRequestId());
            log.info(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        client.close();
    }

//    /**
//     * @param shopcode       店铺编码
//     * @param businessType   业务类型
//     * @param recnum         发送的手机号码
//     * @param parameterEntry 实体类
//     * @return 是否发送成功或错误原因
//     */
//    public String sendSMS(String shopcode, String businessType,
//                      List<String> recnum, ParameterEntry parameterEntry) {
//        //返回的状态码
//        String feedback = "";
//        //获取车牌号
//        String carnum = parameterEntry.getCarnum();
//        //获取店铺名称
//        String storeName = parameterEntry.getStoreName();
//        //获取日期
//        String date = parameterEntry.getDate();
//        //获取短信内容的参数
//        String parameter1 = parameterEntry.getParameter1();
//        String parameter2 = parameterEntry.getParameter2();
//        String parameter3 = parameterEntry.getParameter3();
//        String parameter4 = parameterEntry.getParameter4();
//
//        //获取创瑞短信相关的配置
//        String sms = parameterEntry.getSms();
//        String smsPwd = parameterEntry.getSmsPwd();
//        String smsUser = parameterEntry.getSmsUser();
//
//
//        //获取AccessKey实体
//        String appkey = "";
//        String appSecret = "";
//        String signName = "";
//        String endpoint = "";
//        String topic1 = "";
//        String keyuse = "";
//        AccessKey accessKey = messageConfigDao.getAccessKey(shopcode);
//        if (accessKey != null) {
//            endpoint = accessKey.getEndpoint();
//            topic1 = accessKey.getTopic();
//            appkey = accessKey.getAppkey();
//            appSecret = accessKey.getAppSecret();
//            signName = accessKey.getSignName();
//            keyuse = accessKey.getKeyUse();
//        }
//
//        //获取短信模板TemplateCode实体
//        String templateCode = "";
//        String templateUse = "";
//        TemplateCode templateCodes = messageConfigService.getTemplateCode(shopcode, businessType);
//        if (templateCodes != null && !"".equals(templateCodes)) {
//            templateCode = templateCodes.getTemplateCode();
//            templateUse = templateCodes.getTemplateUse();
//        }
//        //短信发送状态
//        String state = "";
//        try {
//            if ("true".equals(keyuse) && "true".equals(templateUse)) {
//                log.info("阿里云短信===============================");
//                /**
//                 * Step 1. 获取主题引用
//                 *
//                 */
//                CloudAccount account = new CloudAccount(appkey, appSecret, endpoint);
//                MNSClient client = account.getMNSClient();
//                CloudTopic topic = client.getTopicRef(topic1);
//                /**
//                 * Step 2. 设置SMS消息体（必须）
//                 *
//                 * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
//                 */
//                RawTopicMessage msg = new RawTopicMessage();
//                msg.setMessageBody("sms-message");
//                /**
//                 * Step 3. 生成SMS消息属性
//                 */
//                MessageAttributes messageAttributes = new MessageAttributes();
//                BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
//                // 3.1 设置发送短信的签名（SMSSignName）
//                batchSmsAttributes.setFreeSignName(signName);
//                // 3.2 设置发送短信使用的模板（SMSTempateCode）
//                batchSmsAttributes.setTemplateCode(templateCode);
//                // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
//                BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
//                smsReceiverParams.setParam("parameter1", parameter1);
//                smsReceiverParams.setParam("parameter2", parameter2);
//                smsReceiverParams.setParam("parameter3", parameter3);
//                smsReceiverParams.setParam("parameter4", parameter4);
//                // 3.4 增加接收短信的号码
//                if (recnum.size() > 0) {
//                    for (int i = 0; i < recnum.size(); i++) {
//                        batchSmsAttributes.addSmsReceiver(recnum.get(i), smsReceiverParams);
//                    }
//                }
//                messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
//
//                /**
//                 * Step 4. 发布SMS消息
//                 */
//                TopicMessage ret = topic.publishMessage(msg, messageAttributes);
//                log.info("MessageId: " + ret.getMessageId());
//                log.info("MessageMD5: " + ret.getMessageBodyMD5());
//                state = "成功";
//                feedback = "发送成功";
//                client.close();
//            } else if (null != smsUser && smsUser.length() > 0 && !smsUser.isEmpty()
//                    && null != recnum && recnum.size() > 0 && !recnum.isEmpty()
//                    && null != smsPwd && smsPwd.length() > 0 && !smsPwd.isEmpty()
//                    && null != sms && sms.length() > 0 && !sms.isEmpty()) {
//                //封装手机号,多个手机号以逗号进行分割
//                String sendPhone = "";
//                if (recnum.size() > 0) {
//                    for (int i = 0; i < recnum.size(); i++) {
//                        sendPhone += recnum.get(i);
//                        sendPhone += ",";
//                    }
//                }
//                if (recnum.size() == 1) {
//                    sendPhone = recnum.get(0);
//                }
//                //原来的短信发送模式
//                StringBuilder sb = new StringBuilder(aGOHOST);
//                sb.append("name=" + smsUser);
//                sb.append("&pwd=" + smsPwd);
//                sb.append("&mobile=" + sendPhone);
//                sb.append("&content=" + URLEncoder.encode(sms, "UTF-8"));
//                sb.append("&stime=");
//                sb.append("&sign=");
//                sb.append("&type=pt&extno=");
//                URL url = new URL(sb.toString());
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                InputStream is = url.openStream();
//                log.info("创瑞短信发送模式");
//                state = "成功";
//                feedback = convertStreamToString(is); //返回值
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            state = "失败";
//            feedback = e.getMessage();
//        }
//
//        if (recnum.size() > 0) {
//            for (int i = 0; i < recnum.size(); i++) {
//                SmsLogs smsLogs = new SmsLogs();
//                //创建短信记录的实体类
//                smsLogs.setCarnum(carnum);
//                SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
//                String date1 = sdf.format(new Date());
//                smsLogs.setDate(date1);
//                smsLogs.setShopcode(shopcode);
//                smsLogs.setSmsname(businessType);
//                smsLogs.setPhonenum(recnum.get(i));
//                if (!state.equals("成功")){
//                    state = "失败";
//                    if (accessKey == null) {
//                        feedback = "阿里云账号配置错误!";
//                    }
//                    if (templateCodes == null) {
//                        feedback = "短信模板配置错误!";
//                    }
//                    if (accessKey == null && templateCodes == null) {
//                        feedback = "阿里云账号,短信模板配置错误!";
//                    }
//                }
//                smsLogs.setState(state);
//                smsLogs.setCause(feedback);
//                smsLogsDao.addSmsLogs(smsLogs);
//            }
//        }
//        return feedback;
//    }
//
//    /**
//     * 字符串的转换
//     *
//     * @param is 流
//     * @return 字符串
//     */
//    private String convertStreamToString(InputStream is) {
//        StringBuilder sb1 = new StringBuilder();
//        byte[] bytes = new byte[4096];
//        int size = 0;
//
//        try {
//            while ((size = is.read(bytes)) > 0) {
//                String str = new String(bytes, 0, size, "UTF-8");
//                sb1.append(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb1.toString();
//    }
}
