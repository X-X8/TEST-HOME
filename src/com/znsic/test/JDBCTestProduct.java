package com.znsic.test;

import java.util.List;

import com.znsic.dao.ProductDao;
import com.znsic.model.Goddess;

public class JDBCTestProduct {
	public static void main(String[] args) {

//		ProductDao dao = new ProductDao();
//		
////		pd.sp_select_nofilter();//�����޲δ洢����
//		
//		 
//		
//		//����һ��������Ϊ����Ĳ���
//		String sp_name = "";
//		//�������������ܷ��ؽ��
//		List<Goddess> result = null;
//		 try {
//			result = dao.sp_select_nofilter_in(sp_name);//���ܽ����	
//			//�Խ�������б���
//			 for(int i = 0 ; i < result.size(); i++){
//				 System.out.println(result.get(i).getId()
//						 		+":"+result.get(i).getUser_name()
//						 		+":"+result.get(i).getMobile());
//			 }
//		
//		} catch (Exception e) {
// 			e.printStackTrace();
//		}
		
		//ס������װֻ�������
		String sp_name = "";//����������������в�ѯ
//		String sp_name = null;//��������������
		List<Goddess> result = null;
		Integer count = 0;//��һ׃�����ܷ��ؽY��
		try {
			//�{�ó�������
			count = sp_select_nofilter_out();
			System.out.println(count);
			result = exectuceProductDao(sp_name); 
			showResult(result);
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	
	//���ó��δ洢����
	public static Integer sp_select_nofilter_out() throws Exception{
		ProductDao dao = new ProductDao();
		return dao.sp_select_nofilter_out();
	}
	//���ֵ����dao��ķ���
	public static List<Goddess> exectuceProductDao(String sp_name ) throws Exception{
		ProductDao dao = new ProductDao(); 
		return  dao.sp_select_nofilter_in(sp_name);//���ܽ����
		 
	}
	//���ֵ�鿴����ķ���
	public static void  showResult(List<Goddess> result){
		for(int i = 0 ; i < result.size(); i++){
			 System.out.println(result.get(i).getId()
					 		+":"+result.get(i).getUser_name()
					 		+":"+result.get(i).getMobile());
		 }
	}
}
