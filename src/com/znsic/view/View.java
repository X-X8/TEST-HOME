package com.znsic.view;
/*z���l�y
 * 
 * */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.znsic.action.GoddessAction;
import com.znsic.model.Goddess;

public class View {
	private static final String CONTEXT="��ӭ����Ů�������\n"
			+"������Ů������Ĺ����б�\n"
			+"[MAIN/M]:���˵� \n"
			+"[QUERY/Q]:�鿴Ů���ȫ����Ϣ \n"
			+"[GET/G]:�鿴ĳλŮ�����ϸ��Ϣ \n"
			+"[ADD/A]:���Ů����Ϣ \n"
			+"[UPDATE/U]:����Ů����Ϣ \n"
			+"[DELETE/D]:ɾ��Ů�� \n"
			+"[SEARCH/S]:��ѯŮ����Ϣ�������������ֻ�������ѯ�� \n"
			+"[EXIT/E]:�˳�Ů����� \n"
			+"[BREAK/B]:�˳���ǰ���ܣ��������˵�"; 
	
	 private static final String OPERATION_MAIN="MAIN";
	 private static final String OPERATION_QUERY="QUERY";
	 private static final String OPERATION_GET="GET";
	 private static final String OPERATION_ADD="ADD";
	 private static final String OPERATION_UPDATE="UPDATE";
	 private static final String OPERATION_DELETE="DELETE";
	 private static final String OPERATION_SEARCH="SEARCH";
	 private static final String OPERATION_EXIT="EXIT";
	 private static final String OPERATION_BREAK="BREAK";

	private static Object praenious;
	 
	public static void main(String[] args) {
		 System.out.println(CONTEXT);
		 //����һֱ����
		 
		 Scanner scan = new Scanner(System.in);
		 Goddess goddess = new Goddess();
		 GoddessAction action = new GoddessAction();
		 String precious=null;//���ڼ�����һ����������ݵı�����
		 Integer step = 1;
		 while(scan.hasNext()){
			 String in = scan.next().toString();
			 if (OPERATION_EXIT.equals(in.toUpperCase())
					 || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				 System.out.println("���ѳɹ��˳���");
				 break;
			 }else if(OPERATION_QUERY.equals(in.toUpperCase())//��ѯ����
					 || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				 try{
					 List<Goddess> list = action.quear();
					 for(Goddess go : list){
						 System.out.println(go.getId()+ ",����" +go.getUser_name());
					 }
				 }catch(Exception e){
					 e.printStackTrace();
				 }
			 }else if (OPERATION_ADD.equals(in.toUpperCase())//���ӹ���
					 || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					 || OPERATION_ADD.equals(precious)){
				 precious=OPERATION_ADD;
				 
				 if(1==step){
					 System.out.println("Ոݔ��[����] ");
				 }else if (2==step){
					 goddess.setUser_name(in);
					 System.out.println("Ոݔ��[���g] ");
				 }else if(3==step){
					 goddess.setAge(Integer.valueOf(in));
					 System.out.println("Ոݔ��[����] , ��ʽ��yyyy_MM_dd");
				 }else if(4==step){
					 SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd");
					 Date birthday=null;
					 try{
						 birthday = sf.parse(in);
						 goddess.setBirthday(birthday);
						 System.out.println("Ոݔ��[�]�� ] ");
					 }catch(ParseException e){
						 e.printStackTrace();
						 System.out.println("��ݔ����]���ʽ���`��������ݔ��");
						 step=3;
					 }
				 }else if(5==step){
					 goddess.setEmail(in);
					 System.out.println("Ոݔ�� [�֙C̖] ");
				 }else if(6==step){
					 goddess.setMobile(in);
					 try{
						 action.add(goddess);
						 System.out.println("�����ɹ���");
					 }catch(Exception e){
						 e.printStackTrace();
						 System.out.println("����ʧ����");
					 }
				 }
				 if(OPERATION_ADD.equals(praenious)){
					 step++;
				 }
			 }else{
				 System.out.println("�㔵���ֵ�ǣ�" + in);
			 }
 
			 System.out.println("�������ֵ��" + scan.next().toString());
			 
		 }
 	}
}
