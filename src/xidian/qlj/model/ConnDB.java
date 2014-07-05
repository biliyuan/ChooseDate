//这是一个model类
//完成得到一个数据库连接
package xidian.qlj.model;
import java.sql.*;

public class ConnDB {

	private Connection ct=null;
	
	public Connection getConn(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChooseDate","root","199343");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ConnDB.getConn()");
			
			// TODO: handle exception
		}
		
		return ct;
	}
}
