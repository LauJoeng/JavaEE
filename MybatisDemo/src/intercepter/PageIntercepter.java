package intercepter;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})})
public class PageIntercepter implements Interceptor {

    @Override
    public java.lang.Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        return null;
    }

    @Override
    public java.lang.Object plugin(java.lang.Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
