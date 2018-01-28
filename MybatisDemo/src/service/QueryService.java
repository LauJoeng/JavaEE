package service;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import dao.CommandDao;
import dao.MessageDao;
import util.Iconst;

import java.util.List;
import java.util.Random;

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
        CommandDao commandDao = new CommandDao();
        List<Command>commandList;
        if (Iconst.HELP_COMMAND.equals(command))
        {
            commandList = commandDao.queryCommandList(null,null);
            StringBuilder result = new StringBuilder();
            for (int i=0;i<commandList.size();i++)
            {
                if (i!=0){
                    result.append("</br>");
                }
                result.append("回复[").append(commandList.get(i).getName()).append("]可以查看").append(commandList.get(i).getDescription());
            }
            return result.toString();
        }
        commandList = commandDao.queryCommandList(command,null);
        if (commandList.size()>0)
        {
            List<CommandContent>contentList = commandList.get(0).getContentList();
            return contentList.get(new Random().nextInt(contentList.size())).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}
