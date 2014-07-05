/**
 * ����һ��model(������users����ص�ҵ���߼�)
 */
package xidian.qlj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class UserBeanBO {
	
	//	����һЩ����[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;

	/**
	 * �����û������ظ��û���ȫ����Ϣ
	 * @param u���û���
	 * @return userbean
	 */
	
	public UserBean getUserBean(String u){
		
		UserBean ub=new UserBean();
		try {
			
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from users where user_name=?");
			ps.setString(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				//here
			   
				ub.setId_user(rs.getInt(1));
				ub.setMail(rs.getString(2));
				ub.setUser_name(rs.getString(3));
				ub.setSex(rs.getString(4));
				ub.setUser_password(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			System.out.println("UserBeanBO.getUserBean()");
		}finally{
			this.close();
		}
		
		return ub;
	}
	
	/**
	 * ��֤�û��Ƿ�Ϸ�
	 * @param u
	 * @param p
	 * @return
	 */
	public boolean checkUser(String u,String p){
		
		
		boolean b=false;
		
		
		try {
			
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select user_password  from users where user_name=?");
			
			ps.setString(1, u);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				//ȡ�����ݿ������
				String dbPasswd=rs.getString(1);
				
				if(dbPasswd.equals(p)){
					
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserBeanBO.checkUser()");
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return b;
		
	}
   public boolean newUser(String m,String p,String n,String s){
		
		
		boolean b=false;
		try {
            ct=new ConnDB().getConn();
			ps=ct.prepareStatement("insert into users(mail,user_name,sex,user_password) values(?,?,?,?)");	
            ps.setString(1,m);
            ps.setString(2,n);
            ps.setString(3,s);
            ps.setString(4,p);
			ps.executeUpdate();
			System.out.println("��ϲע��ɹ���");
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
	   System.out.println("UserBeanBO.newUser()");
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return b;
		
	}
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;//
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			
			if(!ct.isClosed()){
				
				ct.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserBeanBO.close()");
			// TODO: handle exception
		}
	}
}
