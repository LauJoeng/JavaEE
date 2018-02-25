package com.yang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener{

    /**
     * Default constructor. 
     */
    public ServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//获取spring配置文件的名称
    	ServletContext servletContext = sce.getServletContext();
    	String config = servletContext.getInitParameter("configLocation");
         //1.创建IOC容器
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    	//2.把IOC容器放在ServletContext属性中
    	servletContext.setAttribute("ApplicationContext", ctx);
    }
	
}
