package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

import org.eclipse.ui.part.ShowInContext;

public class HouseInfo extends JFrame{
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	/*�������ݿ�*/
	public Connection getConnection()
	 {
	  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Second_hand house";
	  String userName="sa";
	  String userPwd="sa";
	 try
	{
		Class.forName(driverName);
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		con=DriverManager.getConnection(dbURL,userName,userPwd);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}
/*
	public static void Show()
	{
		try {
			sql=con.prepareStatement("select * from Houseinfo");//��whereǰ��ӿո񣬲�Ȼ����
			//sql.setObject(1,"����");
             res=sql.executeQuery();
			//˳���ѯ
			//sql=con.createStatement();
			//res=sql.executeQuery("select * from Houseinfo");
			while(res.next()) {
				String no=res.getString(1);
				String name=res.getString(2);
				String ad=res.getString(3);
				String itm=res.getString(4);
				String dir=res.getString(5);
				String Stu_na=res.getString(6);
				String area=res.getString(7);
				String floor=res.getString(8);
				String unit_no=res.getString(9);
				String cararea=res.getString(10);
				String fitment=res.getString(11);
				String serverfee=res.getString(12);
				String status=res.getString(13);
				String money =res.getString(14);
				System.out.print("��Դ���:"+no);
				System.out.print("��Դ����:"+name);
				System.out.print("������ַ:"+ad);
				System.out.print("������λ:"+itm);
				System.out.print("����:"+dir);
				System.out.print("����:"+Stu_na);
				System.out.print("���:"+area);
				System.out.print("¥��:"+floor);
				System.out.print("��Ԫ��:"+unit_no);
				System.out.print("�������:"+cararea);
				System.out.print("װ��״��:"+fitment);
				System.out.print("��ҵ�����:"+serverfee);
				System.out.print("��Դ״̬:"+status);
				System.out.println("�ۼ�"+money);
			}
	}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//�ر����ݿ�����,���ⷢ���쳣
		finally {
			try {
				if(con!=null)
				{
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}*/
	public static  void main(String[] args) {
		HouseInfo c=new HouseInfo();
		con=c.getConnection();
		
		
}
}
