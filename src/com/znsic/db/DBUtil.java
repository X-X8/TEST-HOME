package com.znsic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private final static String Driver="com.mysql.jdbc.Driver" ;
	private final static String URL ="jdbc:mysql://127.0.0.1:3306/jdbctest";
	private final static String USER="root";
	private final static String PASSWORD="123456";
	
	private static Connection conn;
	static{
		try{
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			 conn = DriverManager.getConnection(Driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//對外提供方法來获取链接
	public static Connection  getConnection(){
		//拿到连接
		return conn;
	}
	
public static void main(String[] args) throws Exception   {
	 
	//3.通过数据库的连接操作数据库，实现增删改查
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("" 
			+ "select user_name, sex, age, birthday, "
			+ "email, mobile, create_user,  update_user,  "
			+ "create_date,  update_date,  isdel from test "
			  );
	while(rs.next()){
		 
	}
}
}
