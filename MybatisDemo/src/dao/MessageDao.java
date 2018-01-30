package dao;

import bean.Message;
import db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 和message表相关的数据操作
 */
public class MessageDao {
//    /**
//     * 根据查询条件查询消息列表
//     */
//    public List<Message> queryMessageList(String command,String description) {
//        List<Message> messages = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8", "root", "1909227160");
//            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1 = 1 ");
//            List<String> paramList = new ArrayList<>();
//            if (command != null && !"".equals(command.trim())) {
//                sql.append("and command=? ");
//                paramList.add(command);
//            }
//            if (description != null && !"".equals(description.trim())) {
//                sql.append("and description like '%' ? '%' ");
//                paramList.add(description);
//            }
//            System.out.println("查询sql:" + sql.toString());
//            PreparedStatement statement = connection.prepareStatement(sql.toString());
//            for (int i = 0; i < paramList.size(); i++) {
//                statement.setString(i + 1, paramList.get(i));
//            }
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                System.out.println("message :" + rs.getString("id"));
//                Message message = new Message();
//                message.setId(rs.getString("id"));
//                message.setCommand(rs.getString("command"));
//                message.setDescription(rs.getString("description"));
//                message.setContent(rs.getString("content"));
//                messages.add(message);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return messages;
//    }

    /**
     * 根据查询条件查询消息列表
     */
    public List<Message> queryMessageList(String command,String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message>messages = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            //通过sqlSession执行sql语句
            IMessage Imessage = sqlSession.getMapper(IMessage.class);
            messages = Imessage.queryMessageList(message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }
        return messages;
    }

    /**
     * 单条删除
     * @param id
     */
    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteOne",id);
            System.out.println("in deleteOne Method id = "+id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
            {
                sqlSession.close();
            }
        }

    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(List<Integer> ids){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
            {
                sqlSession.close();
            }
        }

    }

    public void insertOne(Message message) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Message.insertOne",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    public static void main(String args[])
    {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessageList("","");
    }
}

