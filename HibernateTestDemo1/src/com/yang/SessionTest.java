package com.yang;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class SessionTest {
    @Test
    public void testOpenSession(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();
        //打印出false，openSession方法每次创建的都是新的session,s使用openSession方法保存每次调用之后都要手动关闭，否则会造成连接池溢出
        System.out.println(session1==session2);
        if (session1!=null){
            System.out.println("session创建成功");
        }else{
            System.out.println("session创建失败");
        }
        assert session1 != null;
        session1.close();
    }

    @Test
    public void testGetCurrentSession()
    {

        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Session session1 = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();
        //打印出true，getCurrentSession使用的是单例模式，每次都是拿到同一个的session
        System.out.println(session1==session2);
        if (session!=null){
            System.out.println("session创建成功");
        }else{
            System.out.println("session创建失败");
        }
    }

}
