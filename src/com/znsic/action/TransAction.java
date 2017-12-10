package com.znsic.action;

import com.znsic.dao.AccountDao;
import com.znsic.model.AccountInfo;
import com.znsic.service.TransService;

public class TransAction {

	public static void main(String[] args) {
		try{
			String res = trans();
			System.out.println(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static String trans() throws Exception {
 
		AccountInfo accountDao = new AccountInfo();
		TransService transService = new TransService();
		
		AccountInfo from = null;
		AccountInfo to = null;
		
		from = AccountInfo.get(1);
		to = AccountInfo.get(2);
		return transService.trans(from, to, 10d);
	}
	
	//事务操作的方法
	
	
}
