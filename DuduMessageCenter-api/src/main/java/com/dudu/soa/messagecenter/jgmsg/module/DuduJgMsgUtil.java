package com.dudu.soa.messagecenter.jgmsg.module;

import java.util.List;

/**
 * Created by Z800 on 2017/5/2.
 */
public final class DuduJgMsgUtil {
    private DuduJgMsgUtil() {

    }

    /**
     * 获取极光推送消息模板初始化配置   基于别名
     *
     * @param loadId     登录Id（标签）
     * @param targetPath 目标标识
     * @return 消息模板
     */
    public static JgMsgTemplate getBaseJgMsgTemplateByAlias(String loadId, String targetPath) {
        return new JgMsgTemplate()
                .setAlias(loadId)
                .putMap("path", targetPath);
    }

    /**
     * 获取极光推送消息模板 初始化配置 基于 标签
     *
     * @param tags       标签
     * @param targetPath 目标标识
     * @return 消息模板
     */
    public static JgMsgTemplate getBaseJgMsgTemplateByTags(List<String> tags, String targetPath) {
        return new JgMsgTemplate()
                .addAllTags(tags)
                .putMap("path", targetPath);
    }

}
