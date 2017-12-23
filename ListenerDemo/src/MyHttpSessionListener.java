import com.yang.entity.User1;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

    private int userNum = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNum++;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNum",userNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNum--;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNum",userNum);

        ArrayList<User1> user1List = (ArrayList<User1>) httpSessionEvent.getSession().getServletContext().getAttribute("user1List");
        if (SessionUtil.getUserBySessionId(user1List,httpSessionEvent.getSession().getId())!=null){
            user1List.remove(SessionUtil.getUserBySessionId(user1List,httpSessionEvent.getSession().getId()));
        }
    }
}