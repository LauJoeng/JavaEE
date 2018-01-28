package dao;

import bean.Command;
import bean.Message;
import db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 与指令表对应的数据库操作类
 */
public class CommandDao {
    /**
     * 根据查询条件查询指令列表
     */
    public List<Command> queryCommandList(String name, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Command>commands = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command command = new Command();
            command.setName(name);
            command.setDescription(description);
            //通过sqlSession执行sql语句
            commands = sqlSession.selectList("Command.queryCommandList",command);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }
        return commands;
    }
}
