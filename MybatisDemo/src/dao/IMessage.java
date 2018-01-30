package dao;

import bean.Message;

import java.util.List;

/**
 * 与Message配置文件向对应的接口
 */
public interface IMessage {
    public List<Message> queryMessageList(Message message);
}
