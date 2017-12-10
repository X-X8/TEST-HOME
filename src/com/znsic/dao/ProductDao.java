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
	 * �����޲����Ĵ洢���̣�
	 * create procedure test_db.sp_select_nofilte()
	 * 	BEGIN
	 * 	select *from testtable;
	 * End.
	 * @throws Exception 
	 */
	public static void sp_select_nofilter() throws Exception{
		//��ȡ���ݿ�����
		Connection conn = DBUtil.getConnection();
		//��ȡcallablestatement
		CallableStatement cs = conn.prepareCall("call sp_select_nofilte");
		//ִ��
		cs.execute();
		//���������������������
		ResultSet rs = cs.getResultSet();
		
		//ѭ�����������
		while(rs.next()){
			System.out.println(rs.getString("user_name") 
								+ rs.getString("email")
								+ rs.getString("mobile"));
		}
	}
	/**
	 * ��������������Ĵ洢����
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
		//�������ս�����Ķ���
		List<Goddess> result = new ArrayList<Goddess>();
		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//���ô洢����callAblestatement
		CallableStatement cs = conn.prepareCall("sp_select_nofilter_in(?)");
		//��������ֵ
		cs.setString(1,sp_name);
		//ִ�д洢����
		cs.execute();
		//��ȡ�����
		ResultSet rs = cs.getResultSet();
		
		//��������
		Goddess g = null;
//		List<Goddess> result = new ArrayList<Goddess>();//������ս�����Ķ���
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
	 * ��������������Ĵ洢����
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
		 //��ȡ����
		 Connection conn = DBUtil.getConnection();
		 //��CallableStatement�ķ������� �洢����
		 CallableStatement cs = conn.prepareCall("sp_select_nofilter_out(?)");
		 //�������
		 cs.registerOutParameter(1, Types.INTEGER);
		 //ִ����䡢
		 cs.execute();
		 //��ȡ�����  ����
//		 Integer count = 0;
		 count = cs.getInt(1); 
		 //��������
		 return count;
	 }
}
