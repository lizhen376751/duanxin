package com.dudu.soa.messagecenter.message.api;

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
     * @param shopcode       店铺代码
     * @param businessType   业务类型
     * @param recnum         手机号码List集合
     * @param parameterEntry 参数实体
     * @return 是否发送成功
     */
    String sendSMS2(String shopcode, String businessType, List<String> recnum, ParameterEntry parameterEntry);
}
