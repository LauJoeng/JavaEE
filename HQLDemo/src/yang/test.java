package yang;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import yang.entity.CommodityEntity;
import yang.entity.CustomerEntity;
import yang.entity.SellerEntity;

import java.awt.*;
import java.util.List;

public class test {
    public static void main(String[] args){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

//        testquery1(session);
//        testquery2(session);
        testquery3(session);

        session.close();
        sf.close();
    }

    private static void testquery3(Session session) {
        String hql = "from CommodityEntity";
        Query query = session.createQuery(hql);
        List<CommodityEntity>commodities = query.list();
        for (CommodityEntity c:commodities)
        {
            System.out.println("commodity's name="+c.getName()+",seller's name:"+c.getSeller().getName());
        }
    }

    private static void testquery2(Session session) {
        String hql = "from CustomerEntity";
        Query query = session.createQuery(hql);
        List<CustomerEntity> customers= query.list();
        for (CustomerEntity c:customers)
        {
            System.out.println("name:"+c.getName());
        }
    }

    private static void testquery1(Session session) {
        String hql = "from SellerEntity ";
        Query query = session.createQuery(hql);
        List<SellerEntity> sellers = query.list();
        for (SellerEntity seller:sellers){
            System.out.println(seller.toString());
        }
    }
}
