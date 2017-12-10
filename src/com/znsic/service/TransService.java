package com.znsic.service;

import java.sql.Connection;
import com.znsic.dao.AccountDao;
import com.znsic.dao.TransDao;
import com.znsic.db.DBUtil;
import com.znsic.model.AccountInfo;
import com.znsic.model.TransInfo;

public class TransService {

	// û���������ķ���
	public String trans(AccountInfo from, AccountInfo to, Double amount) throws Exception {
		AccountDao accountdao = new AccountDao();
		TransDao transdao = new TransDao();

		from.setAmount(from.getAmount() - amount);
		accountdao.update(from);

		to.setAmount(to.getAmount() + amount);
		accountdao.update(to);

		TransInfo info = new TransInfo();
		info.setDistinationId(to.getId());
		info.setDistinationAcceount(to.getAccount());
		info.setSourAccountId(from.getId());
		info.setSourceAccount(from.getAccount());
		info.setAmount(amount);
		TransDao.insert(info);
		return "sccess";

	}
	//����������ķ���
	public static String transaction(AccountInfo from, AccountInfo to, Double amount) throws Exception{
		Connection conn = DBUtil.getConnection();
		conn.setAutoCommit(false);//�P�] �ر������Զ��ύ
		try {
			
			
			AccountDao accountdao = new AccountDao();
			TransDao transDao = new TransDao();
			
			from.setAmount(from.getAmount() - amount);
			accountdao.update(from);
			 
			
			to.setAmount(to.getAmount() + amount);
			accountdao.update(to);	
			
			TransInfo info = new TransInfo();
			info.setSourAccountId(from.getId());
			info.setSourceAccount(from.getAccount());
			
			info.setDistinationId(to.getId());
			info.setDistinationAcceount(to.getAccount());
			
			info.setAmount(amount);
			TransDao.insert(info);
			return "sccess";	 
		} catch (Exception e) {
		 conn.rollback();
			e.printStackTrace();
		}
			return "fail";
	}

}
