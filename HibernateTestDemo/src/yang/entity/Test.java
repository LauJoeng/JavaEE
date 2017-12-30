package yang.entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Test {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
//		Grade g = new Grade("Java一班","javaWeb一班");
//		
//		Student stu1 = new Student("张三","男");
//		Student stu2 = new Student("李四","女");
//		
//		g.getStudents().add(stu1);
//		g.getStudents().add(stu2);
//		
//		session.save(g);
//		session.save(stu1);
//		session.save(stu2);
//		session.flush();
		Grade grade = session.get(Grade.class, 1);
		System.out.println(grade.getGname() + ","+grade.getGdesc());
		Set<Student>students =grade.getStudents();
		for(Student s: students) {
			System.out.println(s.getSname()+","+s.getSex());
		}
		ts.commit();
		sf.close();
		session.close();
		
	}
}
