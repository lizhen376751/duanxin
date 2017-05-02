package com.dudu.soa.messagecenter.jgmsg;


import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.messagecenter.jgmsg.module.JgMsgTemplate;
import org.junit.Test;

/**
 * Created by Z800 on 2017/4/27.
 */
public class JgMsgTemplateTest {

    @Test
    public void test() {
        JgMsgTemplate jgMsgTemplate = new JgMsgTemplate()
                .setNotification(true)
                .setAlias("asdf");

        String str = JSONObject.toJSONString(jgMsgTemplate);
        System.out.println(str);
        System.out.println(JSONObject.parseObject(str,JgMsgTemplate.class));
    }
}