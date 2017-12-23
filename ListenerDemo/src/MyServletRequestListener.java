
import com.yang.entity.User1;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebListener
public class MyServletRequestListener implements ServletRequestListener{

    private ArrayList<User1> user1List;

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        user1List = (ArrayList<User1>) servletRequestEvent.getServletContext().getAttribute("user1List");
        if (user1List == null){
            user1List = new ArrayList<>();
        }
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionId = request.getSession().getId();
        if (SessionUtil.getUserBySessionId(user1List,sessionId) == null){
            User1 user1 = new User1();
            user1.setSessionString(sessionId);
            user1.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user1.setIpString(request.getRemoteAddr());
            user1List.add(user1);
        }
        servletRequestEvent.getServletContext().setAttribute("user1List", user1List);
    }
}
