package yang;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import yang.entity.GradeEntity;
import yang.entity.StudentEntity;


public class Test {
    public static void main(String[] args){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();

        save(session);

//        query(session);
//        findGradeByStudent(session);
        ts.commit();
        session.close();
        sessionFactory.close();
    }

    private static void query(Session session) {
        GradeEntity g = session.get(GradeEntity.class,1);
        for (StudentEntity s:g.getStudents()){
            System.out.println(s.getSname()+","+s.getSex());
        }
    }

    private static void save(Session session) {
        GradeEntity grade = new GradeEntity();
        grade.setGname("武当派");
        grade.setGdesc("武当派第七代");
//        grade.setGid(5);//当主键生成策略设置为increment时为entity设置主键无效

        StudentEntity stu1 = new StudentEntity();
        stu1.setSname("殷梨亭");
        stu1.setSex("男");
        stu1.setGrade(grade);
        StudentEntity stu2 = new StudentEntity();
        stu2.setSname("宋远桥");
        stu2.setSex("男");
        stu2.setGrade(grade);

//        grade.getStudents().add(stu1);
//        grade.getStudents().add(stu2);

//        session.save(grade);
        session.save(stu1);
        session.save(stu2);
    }

    public static void findGradeByStudent(Session session) {
        StudentEntity stu = session.get(StudentEntity.class, 1);
        System.out.println(stu.getSid() + "," + stu.getSname() + "," + stu.getSex());
        GradeEntity grade = stu.getGrade();
        System.out.println(grade.getGid()+ "," + grade.getGname() + "," + grade.getGdesc());
    }
}
