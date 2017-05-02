package com.dudu.soa.messagecenter.jgmsg.api;

import com.dudu.soa.messagecenter.jgmsg.module.JgMsgTemplate;

/**
 * 极光推送
 * Created by Z800 on 2017/5/2.
 */
public interface ApiJgPushIntf {
    /**
     * 极光推送
     *
     * @param jgMsgTemplate 推送实体
     * @return 推送状态
     */
    boolean pushMessage(JgMsgTemplate jgMsgTemplate);
}
