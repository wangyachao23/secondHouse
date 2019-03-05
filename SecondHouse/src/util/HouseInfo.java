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
	/*连接数据库*/
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
			sql=con.prepareStatement("select * from Houseinfo");//在where前面加空格，不然出错
			//sql.setObject(1,"朝阳");
             res=sql.executeQuery();
			//顺序查询
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
				System.out.print("房源编号:"+no);
				System.out.print("房源名称:"+name);
				System.out.print("所属地址:"+ad);
				System.out.print("建筑单位:"+itm);
				System.out.print("朝向:"+dir);
				System.out.print("户型:"+Stu_na);
				System.out.print("面积:"+area);
				System.out.print("楼层:"+floor);
				System.out.print("单元号:"+unit_no);
				System.out.print("车库面积:"+cararea);
				System.out.print("装修状况:"+fitment);
				System.out.print("物业管理费:"+serverfee);
				System.out.print("房源状态:"+status);
				System.out.println("售价"+money);
			}
	}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//关闭数据库连接,避免发生异常
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
