package com.znsic.dao;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.znsic.db.DBUtil;
import com.znsic.model.Goddess;

public class ProductDao {
	/**
	 * 调用无参数的存储过程；
	 * create procedure test_db.sp_select_nofilte()
	 * 	BEGIN
	 * 	select *from testtable;
	 * End.
	 * @throws Exception 
	 */
	public static void sp_select_nofilter() throws Exception{
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		//获取callablestatement
		CallableStatement cs = conn.prepareCall("call sp_select_nofilte");
		//执行
		cs.execute();
		//处理结果集：结果集，出参
		ResultSet rs = cs.getResultSet();
		
		//循环遍历结果集
		while(rs.next()){
			System.out.println(rs.getString("user_name") 
								+ rs.getString("email")
								+ rs.getString("mobile"));
		}
	}
	/**
	 * 调用有输入参数的存储过程
	 * 
	 * Create definer=`znsic`@localhost` procedure  `sp_select_nofilter_in`(IN sp_name VARCHAR(30))
	 * begin
	 * 	if sp_name is null or sp_name = '' then
	 * 		select * from testtable;
	 * 	else
	 * 	  if length(sp_name) = 11 and substring(sp_name,1,1) = 1 then
	 * 		select * from testtabel where mobile=sp_name;
	 * 	  else
	 * 		select *from testtable where user_name like concat('%",sp_name,'%');
	 * 	  end if;
	 * 	end if;
	 * end 
	 * @throws Exception 
	 */
	 
	public static List<Goddess> sp_select_nofilter_in(String sp_name) throws Exception{
		//创建接收结果集的对象
		List<Goddess> result = new ArrayList<Goddess>();
		//获取链接
		Connection conn = DBUtil.getConnection();
		//调用存储过程callAblestatement
		CallableStatement cs = conn.prepareCall("sp_select_nofilter_in(?)");
		//给参数赋值
		cs.setString(1,sp_name);
		//执行存储过程
		cs.execute();
		//获取结果集
		ResultSet rs = cs.getResultSet();
		
		//处理结果集
		Goddess g = null;
//		List<Goddess> result = new ArrayList<Goddess>();//定义接收结果集的对象
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setMobile(rs.getString("mobile"));
			result.add(g);
		}
		return result;
		
	}
	/**
	 * 调用有输出参数的存储过程
	 * 
	 * Create definer=`znsic`@localhost` procedure  `sp_select_nofilter_out`(OUT count INT(30))
	 * begin
	 * 	 select count(*) into count from testTable;
	 * end 
	 *  
	 * @throws Exception 
	 */
	 public static Integer sp_select_nofilter_out() throws Exception{
		 Integer count = 0;
		 //获取链接
		 Connection conn = DBUtil.getConnection();
		 //用CallableStatement的方法调用 存储过程
		 CallableStatement cs = conn.prepareCall("sp_select_nofilter_out(?)");
		 //出入参数
		 cs.registerOutParameter(1, Types.INTEGER);
		 //执行语句、
		 cs.execute();
		 //获取结果集  出参
//		 Integer count = 0;
		 count = cs.getInt(1); 
		 //处理结果集
		 return count;
	 }
}
