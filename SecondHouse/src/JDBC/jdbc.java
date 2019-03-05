package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	private static final String dir="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Second_hand House";
	private static final String user = "sa";
	private static final String password = "sa";
	public  static Connection conn =null;
	
	public Connection getConnection() {
		try {
			Class.forName(dir);//加载数据库驱动
			conn=DriverManager.getConnection(URL, user, password);
			
			}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}

	public void Closect(Connection con) throws SQLException {
		if(con!=null)
		con.close();
	}
}
