package yang.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    static{
        Configuration config = new Configuration().configure();
        ServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session){
        sessionFactory.close();
        if(session!=null){
            session.close();
        }
    }
}
