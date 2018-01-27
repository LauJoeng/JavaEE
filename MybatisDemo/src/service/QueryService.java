package service;

import bean.Message;
import dao.MessageDao;
import util.Iconst;

import java.util.List;

/**
 * 列表相关的业务功能
 */
public class QueryService {
    public List<Message> queryMessageList(String command,String description)
    {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command,description);
    }

    public String queryByCommand(String command)
    {
        MessageDao messageDao = new MessageDao();
        List<Message>messageList = messageDao.queryMessageList(command,null);
        if (Iconst.HELP_COMMAND.equals(command))
        {
            messageList = messageDao.queryMessageList(null,null);
            StringBuilder result = new StringBuilder();
            for (int i=0;i<messageList.size();i++)
            {
                if (i!=0){
                    result.append("</br>");
                }
                result.append("回复[").append(messageList.get(i).getCommand()).append("]可以查看").append(messageList.get(i).getDescription());
            }
            return result.toString();
        }
        if (messageList.size()>0)
        {
            return messageList.get(0).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}
