package com.yang;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jdbc.BinaryStream;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;


public class StudentTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        //创建配置对象
        Configuration config = new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    @Test
    public void testSaveStudents() throws IOException, SQLException {
        //下面的代码会使hibernate自动提交事务，即不调用transaction.commit()方法也会保存数据
//        session.doWork(new Work() {
//            @Override
//            public void execute(Connection connection) throws SQLException {
//                connection.setAutoCommit(true);
//            }
//        });
        //生成学生对象
        StudentsEntity student = new StudentsEntity();
        student.setName("张三丰");
        student.setAddress("武当山");
        student.setGender("男");
        student.setBirthday(new Date(System.currentTimeMillis()));
        File f = new File("C:\\Users\\Administrator\\Desktop\\test.jpg");
        InputStream in = new FileInputStream(f);
        Blob image = Hibernate.getLobCreator(session).createBlob(in,in.available());
        InputStream binaryStream = image.getBinaryStream();
        byte[] buff = new byte[1024*1024];
        binaryStream.read(buff);
        student.setPicture(buff);
        session.save(student);//保存对象到数据库

        session.flush();
    }

    @Test
    public void testReadBlob() throws IOException {
        StudentsEntity student = session.get(StudentsEntity.class,16);
        byte[] buff = student.getPicture();
        File f = new File("C:\\Users\\Administrator\\Desktop\\testdest.jpg");
        OutputStream out = new FileOutputStream(f);
        out.write(buff);
        out.close();
    }

    @Test
    public void testGetStudent(){
        StudentsEntity student = session.get(StudentsEntity.class,16);
        System.out.println(student.toString());
    }

    @Test
    public void testLoadStudent()
    {
        StudentsEntity student = session.load(StudentsEntity.class,16);
        System.out.println(student.toString());
    }

    @Test
    public void testUpdateStudent(){
        StudentsEntity student = session.get(StudentsEntity.class,16);
        student.setGender("女");
        session.update(student);
    }

    @Test
    public void testDeleteStudent(){
        StudentsEntity student = session.get(StudentsEntity.class,16);
        session.delete(student);
    }
    @After
    public void destroy()
    {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
