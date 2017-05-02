package com.dudu.soa.messagecenter.jgmsg.module;

import com.dudu.soa.messagecenter.MsgTemplateBaseDefine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 极光消息模板
 * Created by Z800 on 2017/4/26.
 */
public class JgMsgTemplate extends MsgTemplateBaseDefine<JgMsgTemplate> {

    /**
     * 别名
     */
    private String alias;
    /**
     * 标签
     */
    private List<String> tags = new ArrayList<String>();

    /**
     * 标签是否全匹配
     */
    private boolean tagAnd = false;

    /**
     * 主题
     */
    private String title;
    /**
     * 消息体
     */
    private String content;
    /**
     * 参数
     */
    private Map<String, String> map = new HashMap<String, String>();
    /**
     * 是否是通知
     */
    private boolean notification = false;
    /**
     * 是否是消息
     */
    private boolean message = false;

    /**
     *  JgMsgTemplate(极光消息模板) 字符串形式
     * @return JgMsgTemplate(极光消息模板)字符串
     */
    @Override
    public String toString() {
        return "alias:" + alias + ",tags:" + tags + ",title:" + title + ",content:" + content + ",map:" + map + ",notification:" + notification
                + ",message:" + message;
    }

    /**
     * 获取 别名
     * @return alias 别名
     */
    public String getAlias() {
        return this.alias;
    }

    /**
     * 设置 别名
     * @param alias 别名
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * 新增 标签
     * @param item 标签 元素
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate addTags(String item) {
        this.tags.add(item);
        return this;
    }

    /**
     * 批量新增 标签
     * @param tags 标签 元素集合
     * @return JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate addAllTags(List<String> tags) {
        this.tags.addAll(tags);
        return this;
    }

    /**
     * 获取 标签
     * @return tags 标签
     */
    public List<String> getTags() {
        return this.tags;
    }

    /**
     * 设置 标签
     * @param tags 标签
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * 获取 主题
     * @return title 主题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 主题
     * @param title 主题
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 获取 消息体
     * @return content 消息体
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置 消息体
     * @param content 消息体
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 新增设置 参数
     * @param key 参数 元素 key
     * @param value 参数 元素 value
     * @return JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate putMap(String key, String value) {
        this.map.put(key, value);
        return this;
    }

    /**
     * 批量新增设置 参数
     * @param map 参数 元素集合
     * @return JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate putAllMap(Map<String, String> map) {
        this.map.putAll(map);
        return this;
    }

    /**
     * 获取 参数
     * @return map 参数
     */
    public Map<String, String> getMap() {
        return this.map;
    }

    /**
     * 设置 参数
     * @param map 参数
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setMap(Map<String, String> map) {
        this.map = map;
        return this;
    }

    /**
     * 获取 是否是通知
     * @return notification 是否是通知
     */
    public boolean isNotification() {
        return this.notification;
    }

    /**
     * 设置 是否是通知
     * @param notification 是否是通知
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setNotification(boolean notification) {
        this.notification = notification;
        return this;
    }

    /**
     * 获取 是否是消息
     * @return message 是否是消息
     */
    public boolean isMessage() {
        return this.message;
    }

    /**
     * 设置 是否是消息
     * @param message 是否是消息
     * @return 返回 JgMsgTemplate(极光消息模板)
     */
    public JgMsgTemplate setMessage(boolean message) {
        this.message = message;
        return this;
    }
}
