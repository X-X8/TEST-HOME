package com.znsic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.znsic.db.DBUtil;
import com.znsic.model.TransInfo;

public class TransDao {

	public static void insert(TransInfo TransInfo) throws Exception {
		// 获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		String sql = ""
				+"inster into Trans_Info"
				+ " (  sourAccountId, sourceAccount, distinationId, distinationAcceount, "
				+ "amount) values( ?,?,?,?,?,?,?);";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//传入参数		 
		ptmt.setInt(2, TransInfo.getSourAccountId());
		ptmt.setString (3, TransInfo.getSourceAccount());
		ptmt.setString(4, TransInfo.getDistinationAcceount());
		ptmt.setString (5, TransInfo.getDistinationAcceount());
		ptmt.setDouble (6, TransInfo.getAmount());		
		//执行语句
		ptmt.execute();

	}

	public void del(TransInfo TransInfo) throws Exception {
		//获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		String sql = ""
				+ " delete from Trans_Info"
				+ " where id=? ";
		//预编译语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//传入参数
		ptmt.setInt(1, TransInfo.getId());
		//执行语句
		ptmt.execute();
	}

	public void update(TransInfo TransInfo) throws Exception {

		//获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		String sql = ""
				+ " update Trans_Info "
				+ " set  sourAccountId=?, sourceAccount=?, distinationId=?,"
				+ " distinationAcceount=?,amount=?"
				+ " where id =?;";
		//预编译语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//传入参数
		ptmt.setInt(2, TransInfo.getSourAccountId());
		ptmt.setString (3, TransInfo.getSourceAccount());
		ptmt.setString(4, TransInfo.getDistinationAcceount());
		ptmt.setString (5, TransInfo.getDistinationAcceount());
		ptmt.setDouble (6, TransInfo.getAmount());		
		//执行语句
		ptmt.execute();
	}

	public List<TransInfo> quera(TransInfo TransInfo) throws Exception {

		List<TransInfo> result = new ArrayList<TransInfo>();
		//获取链接
		Connection conn = DBUtil.getConnection();
		//sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Trans_Info ");
		sb.append(" where account like ? ");
		 
		//预编译语句
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		//传入参数
		ptmt.setString(1, "%"+TransInfo.getId()+"%");
		//执行语句
		ResultSet rs = ptmt.executeQuery();
		return result;
		
	}
}
