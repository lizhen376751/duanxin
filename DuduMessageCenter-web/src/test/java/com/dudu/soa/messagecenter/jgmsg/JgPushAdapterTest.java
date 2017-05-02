package com.dudu.soa.messagecenter.jgmsg;

import com.dudu.soa.messagecenter.TestBase;
import com.dudu.soa.messagecenter.jgmsg.module.DuduJgMsgUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Z800 on 2017/5/2.
 */
public class JgPushAdapterTest extends TestBase {

    @Autowired
    JgPushAdapter jgPushAdapter;

    @Test
    public void pushMessage() throws Exception {
      jgPushAdapter.pushMessage(DuduJgMsgUtil
                      .getBaseJgMsgTemplateByAlias("053300101","app/shop/workorder/excution")
                    .setNotification(true)
                    .setTitle("嘟嘟：自定义标题")
                    .setContent("嘟嘟：自定义内容")
                );
    }

}