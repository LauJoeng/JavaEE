package yang.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test2 {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		
		
//		save(session);
		
		findGradeByStudent( session);
		ts.commit();
		sf.close();
		session.close();

	}
	
	public static void save(Session session) {
		Grade g = new Grade("大数据一班","大数据基础一班");
		Student stu1 = new Student("郭靖","男");
		Student stu2 = new Student("黄蓉","女");
		
		//设置关联关系
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		stu1.setGrade(g);
		stu2.setGrade(g);
		
		session.save(g);
//		session.save(stu1);
//		session.save(stu2);
	}
	
	public static void findGradeByStudent(Session session) {
		Student stu = session.get(Student.class, 2);
		System.out.println(stu.getSid() + "," + stu.getSname() + "," + stu.getSex());
		Grade grade = stu.getGrade();
		System.out.println(grade.getGid()+ "," + grade.getGname() + "," + grade.getGdesc());
	}

}
