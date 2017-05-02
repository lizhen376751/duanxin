package com.dudu.soa.messagecenter.jgmsg;

import cn.jpush.api.JPushClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Z800 on 2017/4/26.
 */
@Service
public class JgPushClient {

    /**
     * 极光推送配置
     */
    @Autowired
    private JgPushConfig jgPushConfig;

    /**
     * 获取极光推送的client
     * @return 极光client
     */
    public JPushClient getJPushClient() {
        return new JPushClient(jgPushConfig.getMasterSecret(), jgPushConfig.getAppKey());
    }

}
