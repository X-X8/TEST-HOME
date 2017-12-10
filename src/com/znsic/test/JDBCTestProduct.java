package com.znsic.test;

import java.util.List;

import com.znsic.dao.ProductDao;
import com.znsic.model.Goddess;

public class JDBCTestProduct {
	public static void main(String[] args) {

//		ProductDao dao = new ProductDao();
//		
////		pd.sp_select_nofilter();//调用无参存储过程
//		
//		 
//		
//		//定义一个变量作为传入的参数
//		String sp_name = "";
//		//定义结果集来接受返回结果
//		List<Goddess> result = null;
//		 try {
//			result = dao.sp_select_nofilter_in(sp_name);//接受结果集	
//			//对结果集进行遍历
//			 for(int i = 0 ; i < result.size(); i++){
//				 System.out.println(result.get(i).getId()
//						 		+":"+result.get(i).getUser_name()
//						 		+":"+result.get(i).getMobile());
//			 }
//		
//		} catch (Exception e) {
// 			e.printStackTrace();
//		}
		
		//住方法中装只负责调用
		String sp_name = "";//传入参数按参数进行查询
//		String sp_name = null;//将返回所有数据
		List<Goddess> result = null;
		Integer count = 0;//定一變量接受返回結果
		try {
			//調用出參方法
			count = sp_select_nofilter_out();
			System.out.println(count);
			result = exectuceProductDao(sp_name); 
			showResult(result);
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	
	//盗用出参存储过程
	public static Integer sp_select_nofilter_out() throws Exception{
		ProductDao dao = new ProductDao();
		return dao.sp_select_nofilter_out();
	}
	//抽出值调用dao层的方法
	public static List<Goddess> exectuceProductDao(String sp_name ) throws Exception{
		ProductDao dao = new ProductDao(); 
		return  dao.sp_select_nofilter_in(sp_name);//接受结果集
		 
	}
	//抽出值查看结果的方法
	public static void  showResult(List<Goddess> result){
		for(int i = 0 ; i < result.size(); i++){
			 System.out.println(result.get(i).getId()
					 		+":"+result.get(i).getUser_name()
					 		+":"+result.get(i).getMobile());
		 }
	}
}
