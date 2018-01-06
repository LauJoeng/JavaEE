package yang;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import yang.entity.CommodityEntity;
import yang.entity.CustomerEntity;
import yang.entity.OrderformEntity;
import yang.entity.SellerEntity;

import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

//        testquery1(session);
//        testquery2(session);
//        testquery3(session);
//        testquery4(session);
//        testquery5(session);
//        testquery6(session);
//        testquery7(session);
//        testquery8(session);
//        testquery9(session);
//        testquery10(session);
//        testquery11(session);
//        testquery12(session);
//        testquery13(session);
//        testquery14(session);
//        testquery15(session);
        testquery16(session);
        session.close();
        sf.close();
    }

    private static void testquery16(Session session) {
        String hql = "from CommodityEntity order by price asc";//asc升序，desc降序
        Query query = session.createQuery(hql);
        List<CommodityEntity>commodity = query.list();
        for (CommodityEntity c:commodity){
            System.out.println("name:"+c.getName());
            System.out.println("price:"+c.getPrice());
        }
    }

    private static void testquery15(Session session) {
//        String hql="from CustomerEntity c where c.age>20";
        String hql="from CustomerEntity c where c.name='张三'";
        Query query = session.createQuery(hql);
        CustomerEntity c = (CustomerEntity) query.uniqueResult();
        System.out.println(c.getName());
    }

    private static void testquery14(Session session) {
        String hql = "from CommodityEntity c where c.price*5>3000";
        Query query = session.createQuery(hql);
        List<CommodityEntity>commodities = query.list();
        for (CommodityEntity c:commodities){
            System.out.println("name"+c.getName());
            System.out.println("price:"+c.getPrice()*5);
        }
    }

    private static void testquery13(Session session) {
        String hql = "from OrderformEntity o where o.orderItems is not empty";
        Query query = session.createQuery(hql);
        List<OrderformEntity> orders = query.list();
        for (OrderformEntity o:orders){
            System.out.println(o.getCustomer().getName());
            System.out.println(o.getAmount());
            System.out.println(o.getTradedate());
        }
    }

    private static void testquery12(Session session) {
//        String hql="from CommodityEntity c where c.price between 100 and 500 and c.category like '%电脑%'";
        String hql="from CommodityEntity c where c.price between 100 and 5000 or c.category like '%电脑%'";
        Query query = session.createQuery(hql);
        List<CommodityEntity>commodities = query.list();
        for (CommodityEntity c:commodities){
            System.out.println("name:"+c.getName());
            System.out.println("category:"+c.getCategory());
            System.out.println("price:"+c.getPrice());
        }
    }

    private static void testquery11(Session session) {
//        String hql="from CustomerEntity c where c.name like '张_'";
        String hql="from CustomerEntity c where c.address like '%北京%'";//%北京%表示只要存在北京两个字则匹配成功
        Query query = session.createQuery(hql);
        List<CustomerEntity>customer = query.list();
        for (CustomerEntity c:customer){
            System.out.println("name:"+c.getName());
            System.out.println("address:"+c.getAddress());
        }
    }

    private static void testquery10(Session session) {
//        String hql = "from CustomerEntity c where c.age in (20,40)";//in表示在这个集合里
//        String hql = "from CustomerEntity c where c.age not in (20,40)";
        String hql = "from CustomerEntity c where c.age between 20 and 40";//between表示在两个中间
        Query query = session.createQuery(hql);
        List<CustomerEntity> customers = query.list();
        for (CustomerEntity c:customers){
            System.out.println("name:"+c.getName());
            System.out.println("age:"+c.getAge());
        }
    }

    private static void testquery9(Session session) {
//        String hql="from CommodityEntity c where c.price>400";
//        String hql = "from CommodityEntity c where c.description is null";
        String hql = "from CommodityEntity c where c.description = null";//此处采用“=”不会发生错误，后台会自动转化为is null
        Query query = session.createQuery(hql);
        List<CommodityEntity> commodityEntities = query.list();
        for (CommodityEntity c:commodityEntities){
            System.out.println("name:"+c.getName());
            System.out.println("price"+c.getPrice());
            System.out.println("description:"+c.getDescription());
        }
    }

    private static void testquery8(Session session) {
        String hql="select distinct c.sex from CustomerEntity c";
        Query query = session.createQuery(hql);
        List<Object> list = query.list();
        for (Object obj:list){
            System.out.println(obj);
        }
    }

    private static void testquery7(Session session) {
        String hql = "select new SellerEntity(s.name,s.tel,s.address) from SellerEntity s";
        Query query = session.createQuery(hql);
        List<SellerEntity>sellers = query.list();
        for (SellerEntity s:sellers){
            System.out.println("name:"+s.getName());
            System.out.println("tel:"+s.getTel());
            System.out.println("address:"+s.getAddress());
        }
    }

    private static void testquery6(Session session) {
        String hql = "select new map(s.name,s.tel,s.address as address) from SellerEntity s";
        Query query = session.createQuery(hql);
        List<Map>maps  = query.list();
        for (Map m:maps){
            System.out.println("name"+m.get("0"));
            System.out.println("tel:"+m.get("1"));
            System.out.println("address:"+m.get("address"));
        }
    }

    private static void testquery5(Session session) {
        String hql="select new list(s.name,s.tel,s.address) from SellerEntity s";
        Query query = session.createQuery(hql);
        List<List> lists = query.list();
        for (List list:lists){
            System.out.println("name:"+list.get(0));
            System.out.println("tel:"+list.get(1));
            System.out.println("address"+list.get(2));
        }
    }

    private static void testquery4(Session session) {
        //如果hql语句select字句只指定了一个属性，那么query.list()方法返回的是对象，而不是对象数组
        String hql = "select s.name from SellerEntity s";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        for (Object[] objs:list){
            System.out.println("name:"+objs[0]);
        }
    }

    private static void testquery3(Session session) {
        String hql = "from CommodityEntity as seller";
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
