import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener("this is my servlet 3.0 listener")
public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
