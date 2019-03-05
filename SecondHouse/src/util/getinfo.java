package util;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;
import java.awt.EventQueue;
import java.awt.geom.Area;
import java.security.interfaces.RSAKey;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.FactoryConfigurationError;

import org.eclipse.core.runtime.FileLocator;

import com.ibm.icu.text.ListFormatter.Style;

public class getinfo extends JFrame {

	private JPanel contentPane;
	dao dao=new dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getinfo frame = new getinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	//查询房源信息
	public ResultSet HouseList(Connection con) throws Exception
	{
		String sql ="select * from Houseinfo";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();	
	}
	//查询全部
	public ResultSet BuyerList(Connection con) throws Exception
	{
		String sql ="select * from Buyer";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();	
	}
	//查询购买者个人信息
	public ResultSet BuyerList1(Connection con,String usename) throws Exception
	{
		Object use =usename;
		String sql ="select * from Buyer where B_no=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1, use);
		return pstmt.executeQuery();	
	}
	
	//条件查询房源
	public ResultSet HouseList1(Connection con,Object s,Object s1,Object s2,Object s3,Object s4,Object s5) throws Exception
	{
		Object a = null,b=null,c=null;
		if(s=="50-150平")
		{
			a=">=50 and area<150";
		}
		else if(s=="150-200平")
		{
			a=">=150 and area<200";
		}
		else if(s=="200平以上")
		{
			a=">=200";
		}
		if(s3=="1-3层") {
			b=">=1 and floor<3";
		}
		else if(s3=="3-7层")
		{
			b=">=3 and floor<7";
		}
		else if (s3=="7层以上") {
			b=">=7";
		}
		if(s4=="100万以下") {
			c=">=0 and money<100";
		}
		else if(s4=="100万-200万") {
			c=">=100 and money<200";
		}
		else if (s4=="200万以上") {
			c=">=200";
		}
		String sql ="select * from Houseinfo where area"+a+" and dir=? and Stru_na=? and floor"+b+" and money"+c+" and fitment=?";
		//System.out.println(sql);
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1, s1);
		pstmt.setObject(2, s2);
		pstmt.setObject(3, s5);
		return pstmt.executeQuery();
	}
	
	//填写反馈
	public void fankui(Connection con,String s,String usename) throws Exception
	{
		String sql="insert into feedback (B_no,buyerfk) values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, usename);
		pstmt.setString(2, s);
		pstmt.execute();
	}
	
	//查看反馈信息
	public ResultSet seefankui(Connection con,String usename) throws Exception
	{
		String sql ="select buyerfk from feedback where B_no= ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, usename);
		return pstmt.executeQuery();
}
	
	public ResultSet AdminList(Connection con,String usename) throws Exception
	{
		Object use =usename;
		String sql ="select A_name,A_tel from Buyer where A_no=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1, use);
		return pstmt.executeQuery();	
	}
	
	//提交租房订单，提交买房订单
	public void selBS(Connection con,String s,String s1,String s2) throws Exception//s=usename,s1=H_no,s2=S_no
	{
		String sql ="insert into B_order(B_no,S_no,H_no,order_stu) values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1,s);
		pstmt.setObject(2, s2);
		pstmt.setObject(3,s1);
		pstmt.setObject(4, "提交租房订单");
		 pstmt.execute();
	}
	public void selBS1(Connection con,String s,String s1,String s2) throws Exception//s=usename,s1=H_no,s2=S_no
	{
		String sql ="insert into B_order(B_no,S_no,H_no,order_stu) values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1,s);
		pstmt.setObject(2, s2);
		pstmt.setObject(3,s1);
		pstmt.setObject(4, "提交买房订单");
		 pstmt.execute();
	}
	//上传合同情况（管理员操作）
	public void contract(Connection  con,String s,String s1,String s2,String s3,String s4,String s5) throws Exception
	{
		String sql="insert into contract (order_no,progress,con_style,A_name,con_time,A_tel)values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1,s);
		pstmt.setObject(2,s1);
		pstmt.setObject(3,s2);
		pstmt.setObject(4,s3);
		pstmt.setObject(5,s4);
		pstmt.setObject(6,s5);
		pstmt.execute();
	}
	//签订合同改变房源信息中的房源状态
	public void changehouseinfo(Connection con,String s) throws Exception
	{
		String sql="update Houseinfo set status=? where H_no in(select H_no from B_order where order_no=?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1,"2");
		pstmt.setObject(2,s);
		pstmt.execute();
	}
	//查看订单
	public ResultSet selectorder(Connection con,String usename) throws Exception
	{
		Object use =usename;
		
		String sql ="select * from contract where order_no=(select order_no from B_no where B_no=? )";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setObject(1, use);
		return pstmt.executeQuery();
		//String s=rs.getString("order_no");
		
	}
	//接受订单
	public void accorder(Connection con,String usename,String s) throws Exception {
		String sql="update order_stu from B_order where S_no=? and H_no=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, usename);
		pstmt.setString(2, s);
		pstmt.execute();
	}
	}