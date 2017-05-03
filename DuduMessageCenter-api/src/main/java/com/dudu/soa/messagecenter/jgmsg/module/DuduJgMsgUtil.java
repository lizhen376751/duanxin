package com.dudu.soa.messagecenter.jgmsg.module;

import java.util.List;

/**
 * Created by Z800 on 2017/5/2.
 */
public final class DuduJgMsgUtil {
    private DuduJgMsgUtil() {

    }

    /**
     * 获取默认默认的极光推送 通知title
     * @return
     */
    public static String getDefaultNotificationTitle() {
        return "嘟嘟店管家";
    }

    /**
     * 获取极光推送消息模板初始化配置   基于别名
     *
     * @param loadId     登录Id（标签）
     * @param targetPaths 目标标识
     * @return 消息模板
     */
    public static JgMsgTemplate getBaseJgMsgTemplateByAlias(String loadId, String... targetPaths) {
        return new JgMsgTemplate()
                .setAlias(loadId)
                .setTitle(DuduJgMsgUtil.getDefaultNotificationTitle())
                .putMap("path", getTargePath(targetPaths));
    }

    /**
     * 获取极光推送消息模板 初始化配置 基于 标签
     *
     * @param tags       标签
     * @param targetPaths 目标标识
     * @return 消息模板
     */
    public static JgMsgTemplate getBaseJgMsgTemplateByTags(List<String> tags, String... targetPaths) {
        return new JgMsgTemplate()
                .addAllTags(tags)
                .setTitle(DuduJgMsgUtil.getDefaultNotificationTitle())
                .putMap("path", getTargePath(targetPaths));
    }

    /**
     * 路径分隔符
     */
    private static final String SEPARATOR = ".";

    /**
     * 返回节点路径解析规则
     *
     * @param targetPaths  动态路径参数
     * @return 路径分隔符
     */
    private static String getTargePath(String... targetPaths) {
        StringBuilder key = new StringBuilder();
        for (String path : targetPaths) {
            if (key.length() == 0) {
                key.append(path);
            } else {
                key.append(SEPARATOR).append(path);
            }
        }
         return key.toString();
    }

}
