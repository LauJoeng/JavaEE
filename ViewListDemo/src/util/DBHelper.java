package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
	private static String username="root";
	private static String password="1909227160";

	private static Connection conn = null;

	static
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception e)
		{
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		return conn;
	}

	public static void main(String[] args) {
		try {
			Connection conn = DBHelper.getConnection();
			if(conn != null)
			{
				System.out.println("数据库连接正常!");
			}
			else
			{
				System.out.println("数据库连接失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
