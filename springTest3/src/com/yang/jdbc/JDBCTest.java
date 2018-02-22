package com.yang.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mchange.v2.c3p0.util.TestUtils;

import junit.extensions.TestSetup;


public class JDBCTest {
	private static  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	
	
	
	public static void main(String[] args) {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
//		testUpdate();
//		testBatchUpdate();
//		testQueryForObject();
//		testQueryForList();
//		testQueryForObject2();
		testNamedParameterJdbcTemplate();	
	}
	
	/*
	 * 可以为参数起名字。
	 * 好处是若有多个参数则不用再去对应位置，直接对应参数名，便于维护。缺点是较为麻烦，适合参数多的时候使用
	 */
	public static void testNamedParameterJdbcTemplate() {
		String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:ln,:email,:dept_id)";
		Map<String, Object>paramMap = new HashMap<>();
		paramMap.put("ln","FF");
		paramMap.put("email", "ss@189.com");
		paramMap.put("dept_id", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

	public static void testNamedParameterJdbcTemplate2() {
		String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:lastName,:email,:deptid)";
	}

	/*
	 * 执行insert update，delete
	 */
	public static void testUpdate() {
		String sql = "UPDATE employees set last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql,"rose",3);
		
	}
	
	/*
	 * 执行批量更新
	 * 最后一个参数是Object[]的list类型：因为修改一条记录需要一个Object的数组，name多条就需要多个Object的数组
	 */
	public static void testBatchUpdate() {
		String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(?,?,?)";
		List<Object[]>batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] {"aa","aa@163.com",1});
		batchArgs.add(new Object[] {"bb","bb@163.com",2});
		batchArgs.add(new Object[] {"cc","cc@163.com",3});
		jdbcTemplate.batchUpdate(sql,batchArgs);
	}
	
	/*
	 * 从数据库中获取一条数据，实际得到一个对应的对象
	 * 注意不是调用org.springframework.jdbc.core.JdbcTemplate.queryForObject(String, Class<Employee>, Object...)这个方法
	 * 而需要调用org.springframework.jdbc.core.JdbcTemplate.queryForObject(String, RowMapper<Employee>, Object...)这个方法
	 * 1. 其中RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
	 * 2. 使用sql中列的别名完成列名和类的属性名的映射，如last_name和lastName
	 * 3. 不支持级联属性，JdbcTemplate知识一个JDB小工具，而不是orm框架
	 */
	public static void testQueryForObject() {
		String sql = "SELECT id,last_name lastName,email,dept_id as \"department.id\" FROM employees WHERE ID = ?";
		RowMapper<Employee>rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);
		System.out.println(employee);
	}
	
	/*
	 * 查询实体类集合
	 * 注意调用的不是queryForList方法
	 */
	public static void testQueryForList() {
		String sql = "SELECT id,last_name lastName,email,dept_id as \"department.id\" FROM employees WHERE ID > 1";
		RowMapper<Employee>rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
		
		System.out.println(employees);
	}
	
	/*
	 * 获取单列的值，或做统计查询
	 */
	public static void testQueryForObject2() {
		String sql = "SELECT  count(id) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	
}
