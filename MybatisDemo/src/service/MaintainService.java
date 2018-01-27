package service;

import bean.Message;
import dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护相关的业务功能
 */
public class MaintainService {
    public void deleteOne(String id) {
        if (id != null && !"".equals(id.trim())) {
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }

    public void deleteBatch(String[] ids) {
        if (ids != null) {
            MessageDao messageDao = new MessageDao();
            List<Integer> idList = new ArrayList<>();
            for (String id : ids) {
                idList.add(Integer.valueOf(id));
            }
            messageDao.deleteBatch(idList);
        }
    }

    public void insertOne(String command, String description, String content) {
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        MessageDao messageDao = new MessageDao();
        messageDao.insertOne(message);
    }
}
