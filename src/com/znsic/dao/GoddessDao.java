package com.znsic.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import com.znsic.db.DBUtil;
import com.znsic.model.Goddess;



public class GoddessDao {
	
	public void addGoddess(Goddess g) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql ="" 
					+" inster into jdbcTest"
					+" (user_name,sex,age,birthday,email,mobile,create_user,"
					+" create_date,update_user,update_date,isdel)"
					+" values("
					+" ?,?,?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);//预编译sql语句减少对数据库的操作
		//为了灵活操作我们通过model（表的映射）层获取数据
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setDate(8, (Date) g.getCreate_date());
		ptmt.setString(9, g.getUpdate_user());
		ptmt.setDate(10, (Date) g.getUpdate_date());
		ptmt.setString(11, g.getIsdel());
		
		ptmt.execute();//执行sql
}
	public void updateGoddess(Goddess g) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql ="" 
					+" update jdbcTest"
					+" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,create_user=?,"
					+" create_date=current_date(),update_user=?,update_date=current_date(),isdel=?)"
					+" where id=?";
					 
		
		PreparedStatement ptmt = conn.prepareStatement(sql);//预编译sql语句减少对数据库的操作
		//为了灵活操作我们通过model（表的映射）层获取数据
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setDate(8, (Date) g.getCreate_date());
		ptmt.setString(9, g.getUpdate_user());
		ptmt.setDate(10, (Date) g.getUpdate_date());
		ptmt.setString(11, g.getIsdel());
		ptmt.setInt(12, g.getId());
		ptmt.execute();//执行sql
}
	public void delGoddess(Integer id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql ="" 
					+" delete from jdbcTest"
					+" where id=?";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);//预编译sql语句减少对数据库的操作
		//为了灵活操作我们通过model（表的映射）层获取数据
		ptmt.setInt(1, id);
		 
		ptmt.execute();//执行sql
}
	public List<Goddess> query(List<Map<String,Object>> params)  throws Exception{

		List<Goddess> result = new ArrayList<Goddess>();
		
		Connection conn = DBUtil.getConnection();
		 
		StringBuilder sb = new StringBuilder();
		//添加查询参数  通过集合传参数
		sb.append("select I from jdbcTest where 1=1");
		 
		if (params != null && params.size() > 0){
			for (int i = 0; i < params.size(); i++){
				Map<String, Object> map = params.get(i);
				sb.append(" and"+map.get(" name")+ map.get(" rela")+map.get("value"));
				
				
			}
		}else{
			System.out.println("not find table or have error");
		}
		
		//预编译sql
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		 //传参数
		/*ptmt.setString(1, "%"+name+"%");
		ptmt.setString(2, "%"+mobile+"%");
		ptmt.setString(3, "%"+email+"%");
		ptmt.setString(4, "%"+create_user+"%");
		ptmt.setString(5, "%"+mobile+"%");
		ptmt.setString(6, "%"+mobile+"%");
		ptmt.setString(7, "%"+mobile+"%");
		ptmt.setString(8, "%"+mobile+"%");
		ptmt.setString(9, "%"+mobile+"%");
		ptmt.setString(10, "%"+mobile+"%");
		ptmt.setString(11, "%"+mobile+"%");
		*/
		//执行语句
		ResultSet rs = ptmt.executeQuery();
					
		Goddess g =  null;
		//遍历结果集
		while (rs.next()){
			
		g = new Goddess();//结果封装到对象里面
		g.setUser_name(rs.getString("user_name"));
		g.setAge(rs.getInt("age"));
		g = new Goddess();
		g.setId(rs.getInt("id"));
		g.setUser_name(rs.getString("user_name"));
		g.setAge(rs.getInt("age"));
		g.setSex(rs.getInt("sex"));
		g.setBirthday(rs.getDate("birthday"));
		g.setEmail(rs.getString("emile"));
		g.setMobile(rs.getString("moble"));
		g.setCreate_date(rs.getDate("create_date"));
		g.setCreate_user(rs.getString("create_user"));
		g.setUpdate_date(rs.getDate("update_date"));
		g.setUpdate_user(rs.getString("update_user"));
	 
		//加入到集合中
		return add(g);
		
	}
		return result;//返回集合
	
}

	 
	private List<Goddess> add(Goddess g) {
		// TODO Auto-generated method stub
		return null;
	}
	public Goddess get(Integer id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql ="" 
					+" select * from  jdbcTest"
					+" where id=?";
					 
		
		PreparedStatement ptmt = conn.prepareStatement(sql);//预编译sql语句减少对数据库的操作
		 	 
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();//执行sql
		Goddess g = new Goddess();
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("emile"));
			g.setMobile(rs.getString("moble"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
		 
		 
			
		}
		return g;//返回对象
}
	
}
