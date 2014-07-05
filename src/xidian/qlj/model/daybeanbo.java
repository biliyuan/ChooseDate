package xidian.qlj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class daybeanbo {
	
	//	定义一些变量[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	public daybean getdaybean(int u){
		   daybean dn= new daybean();
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from party where id_party=?");
			ps.setInt(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				
				dn.year=rs.getString(2);
				dn.year=rs.getString(3);
				dn.year=rs.getString(4);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("daybeanbO.getdaybean()");
			// TODO: handle exception
		}finally{
			this.close();
		}
		
		return dn;
	}
	public boolean newDay(daybean d){
		
		
		boolean b=false;
		try {
			
			//sql注入漏洞
			
            ct=new ConnDB().getConn();
            int choice=0;
            ps=ct.prepareStatement("select choices from choose where id_party=? and year1=? and month1=? and day1=?");
			ps.setInt(1, d.id_party);
			ps.setString(2, d.year);
			ps.setString(3,d.month);
			ps.setString(4, d.day);
			rs=ps.executeQuery();
			if(rs.next()){
				choice=rs.getInt(1)+1;
			
			ps=ct.prepareStatement("update choose set choices=? where id_party=? and year1=? and month1=? and day1=?");
            ps.setInt(1,choice);
            ps.setInt(2, d.id_party);
			ps.setString(3, d.year);
			ps.setString(4,d.month);
			ps.setString(5, d.day);
			ps.executeUpdate();
			b=true;
			}
			else{
					ps=ct.prepareStatement("insert into choose(id_party,year1,month1,day1,choices) values(?,?,?,?,?)");
		            ps.setInt(1,d.id_party);
		            ps.setString(2,d.year);
		            ps.setString(3,d.month);
		            ps.setString(4,d.day);
		            ps.setInt(5,1);
					ps.executeUpdate();
					b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		    System.out.println("daybeanbo.newDay()");
			// TODO: handle exception
		}finally{
			
			//关闭资源
			this.close();
		}
		
		return b;
		
	}
	
	public String goodDate(int id_party){
		
		
		String end="";
		try {
			
			//sql注入漏洞
			
            ct=new ConnDB().getConn();
            int choice=0;
            ps=ct.prepareStatement("select max(choices) from choose  where id_party=?");
			ps.setInt(1, id_party);
			rs=ps.executeQuery();
			if(rs.next()){
				choice=rs.getInt(1);
			ps=ct.prepareStatement("select * from choose  where choices=? and id_party=?");
            ps.setInt(1,choice);
            ps.setInt(2, id_party);
			rs=ps.executeQuery();
			daybean good = new daybean();
			while(rs.next())
			 {
		     good.year=rs.getString(2);
		     good.month=rs.getString(3);
		     good.day=rs.getString(4);
		     end=end+good.year+"年"+good.month+"月"+good.day+"日"+" ";
			 }
			}
		} catch (Exception e) {
			e.printStackTrace();
		    System.out.println("daybeanbo.newDay()");
			// TODO: handle exception
		}finally{
			
			//关闭资源
			this.close();
		}
		
		return end;
		
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
			System.out.println("PartyBeanBO.close()");
			// TODO: handle exception
		}
	}
}