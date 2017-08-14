package com.dudu.soa.messagecenter.message.api;

import com.dudu.soa.messagecenter.message.module.MessageEntry;
import com.dudu.soa.messagecenter.message.module.ParameterEntry;

import java.util.List;

/**
 * 发送短信消息
 */
public interface ApiSendSms {

    /**
     * @param shopcode       店铺代码
     * @param businessType   业务类型
     * @param recnum         手机号码List集合
     * @param parameterEntry 参数实体
     * @return 字符串
     */
    String sendSMS(String shopcode, String businessType, List<String> recnum, ParameterEntry parameterEntry);

    /**
     * 短信发送和第一个一样的,只不过入参不一样
     *
     * @param messageEntry 短信参数实体类
     * @return
     */
    String sendSMS2(MessageEntry messageEntry);
}
