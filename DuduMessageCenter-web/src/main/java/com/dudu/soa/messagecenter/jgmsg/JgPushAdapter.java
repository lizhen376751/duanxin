package com.dudu.soa.messagecenter.jgmsg;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.Notification;
import com.dudu.soa.messagecenter.MsgTargetEnum;
import com.dudu.soa.messagecenter.jgmsg.api.ApiJgPushIntf;
import com.dudu.soa.messagecenter.jgmsg.module.JgMsgTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 极光推送 adapter
 * Created by Z800 on 2017/4/26.
 */
@Service
public class JgPushAdapter implements ApiJgPushIntf {
    /**
     * logg
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JgPushAdapter.class);

    /**
     * 极光客户端
     */
    @Autowired
    private JgPushClient jgPushClient;


    @Override
    public boolean pushMessage(JgMsgTemplate jgMsgTemplate) {
        if (!jgMsgTemplate.isMessage() && !jgMsgTemplate.isNotification()) {
            return false;
        }
        PushPayload.Builder builder = PushPayload.newBuilder();
        //目标客户端
        if (MsgTargetEnum.ANDROID.equals(jgMsgTemplate.getMsgTargetEnum())) {
            builder.setPlatform(Platform.android());
        } else {
            builder.setPlatform(Platform.all());
        }
        if (null != jgMsgTemplate && jgMsgTemplate.getTags().size() > 0) {
            builder.setAudience(Audience.newBuilder()
                    .addAudienceTarget(AudienceTarget.tag(jgMsgTemplate.getTags()))
                    .build());
        } else {
            builder.setAudience(Audience.newBuilder()
                    .addAudienceTarget(AudienceTarget.alias(jgMsgTemplate.getAlias()))
                    .build());
        }

        if (jgMsgTemplate.isNotification()) {
            builder.setNotification(Notification
                    .android(jgMsgTemplate.getContent(), jgMsgTemplate.getTitle(), jgMsgTemplate.getMap()));
        }

        if (jgMsgTemplate.isMessage()) {
            builder.setMessage(Message.newBuilder()
                    .setTitle(jgMsgTemplate.getTitle())
                    .setMsgContent(jgMsgTemplate.getContent())
                    .addExtras(jgMsgTemplate.getMap())
                    .build());
        }
        return this.push(builder.build());
    }

    /**
     * 消息推送具体实现逻辑
     *
     * @param payload 推送实体
     * @return 是否发送成功
     */
    private boolean push(PushPayload payload) {
        JPushClient jPushClient = jgPushClient.getJPushClient();
        try {
            jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
            LOGGER.error("APIConnectionException", e);
            return false;
        } catch (APIRequestException e) {
            e.printStackTrace();
            LOGGER.error("APIRequestException", e);
            return false;
        }
        return true;
    }


}
