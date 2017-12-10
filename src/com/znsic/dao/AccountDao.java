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
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		String sql = ""
				+"inster into account_info (account, amount) values(?,?);";
		//Ԥ����Sql���
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//�������
		ptmt.setString(1, account.getAccount());
		ptmt.setDouble(2, account.getAmount());
		//ִ�����
		ptmt.execute();

	}

	public void del(AccountInfo account) throws Exception {
		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		String sql = ""
				+ " delete from account_info"
				+ " where id=? ";
		//Ԥ�������
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//�������
		ptmt.setInt(1, account.getId());
		//ִ�����
		ptmt.execute();
	}

	public void update(AccountInfo from) throws Exception {

		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		String sql = ""
				+ " update account_info "
				+ " set account =?,amount =?"
				+ " where id =?;";
		//Ԥ�������
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//�������
		ptmt.setString(1, from.getAccount());
		ptmt.setDouble(2, from.getAmount());
		ptmt.setInt(3, from.getId());
		//ִ�����
		ptmt.execute();
	}

	public List<AccountInfo> quera(AccountInfo account) throws Exception {

		List<AccountInfo> result = new ArrayList<AccountInfo>();
		//��ȡ����
		Connection conn = DBUtil.getConnection();
		//sql���
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from accont_info ");
		sb.append(" where account like ? ");
		 
		//Ԥ�������
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		//�������
		ptmt.setString(1, "%"+account.getId()+"%");
		//ִ�����
		ResultSet rs = ptmt.executeQuery();
		return result;
		
	}

	public static AccountDao get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	 
}
