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
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		String sql = ""
				+"inster into Trans_Info"
				+ " (  sourAccountId, sourceAccount, distinationId, distinationAcceount, "
				+ "amount) values( ?,?,?,?,?,?,?);";
		//Ԥ����sql���
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//�������		 
		ptmt.setInt(2, TransInfo.getSourAccountId());
		ptmt.setString (3, TransInfo.getSourceAccount());
		ptmt.setString(4, TransInfo.getDistinationAcceount());
		ptmt.setString (5, TransInfo.getDistinationAcceount());
		ptmt.setDouble (6, TransInfo.getAmount());		
		//ִ�����
		ptmt.execute();

	}

	public void del(TransInfo TransInfo) throws Exception {
		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		String sql = ""
				+ " delete from Trans_Info"
				+ " where id=? ";
		//Ԥ�������
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//�������
		ptmt.setInt(1, TransInfo.getId());
		//ִ�����
		ptmt.execute();
	}

	public void update(TransInfo TransInfo) throws Exception {

		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		String sql = ""
				+ " update Trans_Info "
				+ " set  sourAccountId=?, sourceAccount=?, distinationId=?,"
				+ " distinationAcceount=?,amount=?"
				+ " where id =?;";
		//Ԥ�������
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//�������
		ptmt.setInt(2, TransInfo.getSourAccountId());
		ptmt.setString (3, TransInfo.getSourceAccount());
		ptmt.setString(4, TransInfo.getDistinationAcceount());
		ptmt.setString (5, TransInfo.getDistinationAcceount());
		ptmt.setDouble (6, TransInfo.getAmount());		
		//ִ�����
		ptmt.execute();
	}

	public List<TransInfo> quera(TransInfo TransInfo) throws Exception {

		List<TransInfo> result = new ArrayList<TransInfo>();
		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Trans_Info ");
		sb.append(" where account like ? ");
		 
		//Ԥ�������
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		//�������
		ptmt.setString(1, "%"+TransInfo.getId()+"%");
		//ִ�����
		ResultSet rs = ptmt.executeQuery();
		return result;
		
	}
}
