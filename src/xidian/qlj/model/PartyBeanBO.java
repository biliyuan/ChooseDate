
package xidian.qlj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PartyBeanBO {
	
	//	����һЩ����[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	public PartyBean getPartyBean(int u){
		
		PartyBean ub=new PartyBean();
		try {
			
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from party where id_party=?");
			ps.setInt(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				
				ub.setId_party(rs.getInt(1));
				ub.setParty_name(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PartyBeanBO.getPartyBean()");
			// TODO: handle exception
		}finally{
			this.close();
		}
		
		return ub;
	}
     public PartyBean getPartyBean2(String u){
		
		PartyBean ub=new PartyBean();
		try {
			
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from party where party_name=?");
			ps.setString(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				
				ub.setId_party(rs.getInt(1));
				ub.setParty_name(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PartyBeanBO.getPartyBean2()");
			// TODO: handle exception
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
	public boolean newParty(String u){
		
		
		boolean b=false;
		try {
			
			//sqlע��©��
			
            ct=new ConnDB().getConn();
			ps=ct.prepareStatement("insert into party(party_name) values(?)");
            ps.setString(1,u);
			ps.executeUpdate();
			System.out.println("��ϲ�����ۻ�ɹ���");
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		    System.out.println("PartyBeanBO.newParty()");
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return b;
		
	}
    public boolean checkParty(String u){
		
		
		boolean b=false;
		
		
		try {
			
			
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select *  from party where party_name=?");
            ps.setString(1, u);	
			rs=ps.executeQuery();
			if(rs.next()){
					b=true;
		    }
		}
			
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("PartyBeanBO.checkParty()");
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return b;
		
	}
//�رպ���
	
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
			System.out.println("PartyBeanBO.close()");
			// TODO: handle exception
		}
	}
}
