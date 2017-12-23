import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class FirstListener implements ServletRequestListener {

    // Public constructor is required by servlet spec
    public FirstListener() {
    }
//
//    // -------------------------------------------------------
//    // ServletContextListener implementation
//    // -------------------------------------------------------
//    public void contextInitialized(ServletContextEvent sce) {
//      /* This method is called when the servlet context is
//         initialized(when the Web application is deployed).
//         You can initialize servlet context related data here.
//      */
//      String s = sce.getServletContext().getInitParameter("initParam");
////      sce.getServletContext().setAttribute("");
//      System.out.println("contextInitialized : initParam = " +s);
//    }
//
//    public void contextDestroyed(ServletContextEvent sce) {
//      /* This method is invoked when the Servlet Context
//         (the Web application) is undeployed or
//         Application Server shuts down.
//      */
//      System.out.println("contextDestroyed");
//    }
//
//    // -------------------------------------------------------
//    // HttpSessionListener implementation
//    // -------------------------------------------------------
//    public void sessionCreated(HttpSessionEvent se) {
//        /* Session is created. */
//        System.out.println("session created");
//    }
//
//    public void sessionDestroyed(HttpSessionEvent se) {
//        /* Session is destroyed. */
//        System.out.println("session destroyed");
//    }
//
//    // -------------------------------------------------------
//    // HttpSessionAttributeListener implementation
//    // -------------------------------------------------------
//
//    public void attributeAdded(HttpSessionBindingEvent sbe) {
//      /* This method is called when an attribute
//         is added to a session.
//      */
//    }
//
//    public void attributeRemoved(HttpSessionBindingEvent sbe) {
//      /* This method is called when an attribute
//         is removed from a session.
//      */
//    }
//
//    public void attributeReplaced(HttpSessionBindingEvent sbe) {
//      /* This method is invoked when an attibute
//         is replaced in a session.
//      */
//    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request destroyed initParam=" + servletRequestEvent.getServletContext().getAttribute("initParam"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        servletRequestEvent.getServletContext().setAttribute("intiParam","yang");
        System.out.println("request initialized");
    }
}
