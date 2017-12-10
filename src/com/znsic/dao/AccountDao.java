package com.znsic.dao;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.znsic.db.DBUtil;
import com.znsic.model.AccountInfo;

public class AccountDao {
	public void insert(AccountInfo account) throws Exception {
		// 获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		String sql = ""
				+"inster into account_info (account, amount) values(?,?);";
		//预编译Sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//传入参数
		ptmt.setString(1, account.getAccount());
		ptmt.setDouble(2, account.getAmount());
		//执行语句
		ptmt.execute();

	}

	public void del(AccountInfo account) throws Exception {
		//获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		String sql = ""
				+ " delete from account_info"
				+ " where id=? ";
		//预编译语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//传入参数
		ptmt.setInt(1, account.getId());
		//执行语句
		ptmt.execute();
	}

	public void update(AccountInfo from) throws Exception {

		//获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		String sql = ""
				+ " update account_info "
				+ " set account =?,amount =?"
				+ " where id =?;";
		//预编译语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//传入参数
		ptmt.setString(1, from.getAccount());
		ptmt.setDouble(2, from.getAmount());
		ptmt.setInt(3, from.getId());
		//执行语句
		ptmt.execute();
	}

	public List<AccountInfo> quera(AccountInfo account) throws Exception {

		List<AccountInfo> result = new ArrayList<AccountInfo>();
		//获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from accont_info ");
		sb.append(" where account like ? ");
		 
		//预编译语句
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		//传入参数
		ptmt.setString(1, "%"+account.getId()+"%");
		//执行语句
		ResultSet rs = ptmt.executeQuery();
		return result;
		
	}

	public static AccountDao get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	 
}
