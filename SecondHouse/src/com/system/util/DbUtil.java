package com.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	String dbUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Second_hand house";//���ݿ��ַ
	String userName="sa";
	String userPwd="sa";
	String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//����
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, userName, userPwd);
		return con;
	}
	public void closeCon(Connection con) throws Exception {
		if(con!=null) {
			
			con.close();
		}
	}
	  public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
