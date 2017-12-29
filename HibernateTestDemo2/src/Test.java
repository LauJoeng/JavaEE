import org.hibernate.Session;
import org.hibernate.Transaction;
import yang.entity.GradeEntity;
import yang.entity.StudentEntity;
import yang.util.HibernateUtil;

public class Test {
    public static void main(String[] args)
    {
        add();
    }

    public static void add()
    {
        GradeEntity g = new GradeEntity();
        g.setGname("java一班");
        g.setGdesc("java软件开发一班");
        StudentEntity stu1 = new StudentEntity();
        stu1.setSname("张三丰");
        stu1.setSex("男");
        StudentEntity stu2 = new StudentEntity();
        stu2.setSname("赵敏");
        stu2.setSex("女");

        g.getStudents().add(stu1);
        g.getStudents().add(stu2);

        Session session = HibernateUtil.getSession();
        Transaction ts = session.beginTransaction();
        session.save(g);
        session.save(stu1);
        session.save(stu2);
        ts.commit();
        HibernateUtil.closeSession(session);
    }
}
