package com.znsic.action;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.znsic.dao.GoddessDao;
import com.znsic.model.Goddess;

public class GoddessAction {

	public   void add(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.addGoddess(goddess);
		
	}
	public void get(Integer id) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.get(id);
	}

	public  void edit(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
		
	}
	public void del(Integer	id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);
	}
	public List<Goddess> quear( ) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query(null);
	}
	public  List<Goddess> quear(List<Map<String,Object>> params) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);		
	}
		
		
}
		 
	 

	 
