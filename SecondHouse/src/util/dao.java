package util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.User;

import view.BuyerMain;
import view.mylister;

import java.util.*;
import java.io.*;
import java.sql.*;


public class dao {
	private static String IDStr;
	private JFrame jf=new JFrame("登录");
	private JPanel jp1=new JPanel();
	private JPanel jp2=new JPanel();
	private JPanel jp3=new JPanel();
	private JPanel jp4=new JPanel();
	private JButton jb1=new JButton("注册");
	private JTextField IDField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("登录");
	public  Object usename;
	Connection con=null;
	User username=new User();
	public dao() {
		//System.out.println(123);
	}
	public void init()throws Exception
	{
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

		// 加载驱动
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// 为登录按钮添加事件监听器
		loginButton.addActionListener(e -> {
			// 登录成功则显示“登录成功”
			if(IDStr=="管理员") {
				//System.out.println(IDField.getText() +"\t"+passField.getText()+"\t"+validateAdmin(IDField.getText(),passField.getText()));
				if (validateAdmin(IDField.getText(),passField.getText()))
				{	
					String Adminname=IDField.getText();
					JOptionPane.showMessageDialog(jf, "登录成功");
				}
				// 否则显示“登录失败”
				else
				{
					JOptionPane.showMessageDialog(jf, "登录失败");
				}
			}else if(IDStr=="买家") {
				System.out.println(IDField.getText()+"\t"+passField.getText()+"\t"+validateBuyer(IDField.getText(),passField.getText()));
				if (validateBuyer(IDField.getText(),passField.getText()))
				{	
					String Buyername=IDField.getText();
					dispose();
					new BuyerMain(Buyername).setVisible(true);
					JOptionPane.showMessageDialog(jf, "登录成功");
					System.out.println(usename);
					
				}
				// 否则显示“登录失败”
				else
				{
					JOptionPane.showMessageDialog(jf, "登录失败");
				}
			}else {
				System.out.println(IDField.getText() +"\t"+passField.getText()+"\t"+validateSeller(IDField.getText(),passField.getText()));
				if (validateSeller(IDField.getText(),passField.getText()))
				{
					String Sellername=IDField.getText();
					dispose();
					new BuyerMain(Sellername).setVisible(true);
					JOptionPane.showMessageDialog(jf, "登录成功");
				}
				// 否则显示“登录失败”
				else
				{
					JOptionPane.showMessageDialog(jf, "登录失败");
				}
			}
			
		});
		/*
		jb1.addActionListener(e -> {
			// 登录成功则显示“登录成功”
			if(IDStr=="管理员") {
				System.out.println(IDField.getText()+passField.getText()+"\t"+validateAdmin(IDField.getText(),passField.getText()));
				try {
					cheakAdmin(IDField.getText(),passField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(IDStr=="买家") {
				System.out.println(IDField.getText()+passField.getText()+"\t"+validateBuyer(IDField.getText(),passField.getText()));
				try {
					cheakBuyer(IDField.getText(),passField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				System.out.println(IDField.getText()+passField.getText()+"\t"+validateSeller(IDField.getText(),passField.getText()));
				try {
					cheakSeller(IDField.getText(),passField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	*/
			JLabel IDLabel = new JLabel("身份：");
			IDLabel.setBounds(20, 290, 50, 20);
			JRadioButton buyerRadioButton = new JRadioButton("买家");
			buyerRadioButton.setBounds(70, 290, 100, 20);
			buyerRadioButton.setSelected(true);
			buyerRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	 
					if (buyerRadioButton.isSelected()) {
						IDStr = buyerRadioButton.getText();
					}
				}
			});
	 
			JRadioButton sellerRadioButton = new JRadioButton("卖家");
			sellerRadioButton.setBounds(200, 290, 100, 20);
			sellerRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (sellerRadioButton.isSelected()) {
						IDStr = sellerRadioButton.getText();
					}
				}
			});
			JRadioButton adminRadioButton = new JRadioButton("管理员");
			adminRadioButton.setBounds(200, 290, 100, 20);
			adminRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (adminRadioButton.isSelected()) {
						IDStr = adminRadioButton.getText();
					}
				}
			});
			//此处代码是对JRadioButton进行分组操作以达到互斥效果
			ButtonGroup IDGroup = new ButtonGroup();
			IDGroup.add(buyerRadioButton);
			IDGroup.add(sellerRadioButton);
			IDGroup.add(adminRadioButton);
			JPanel contentPane = new JPanel();
			contentPane.add(IDLabel);
			contentPane.add(buyerRadioButton);
			contentPane.add(sellerRadioButton);
			contentPane.add(adminRadioButton);
	 
			jf.addWindowListener(new mylister());
			jp1.add(new Label("ID:"));
			jp1.add(IDField);
			jp2.add(new Label("密码："));
			jp2.add(passField);
			jp3.add(jb1);
			jp3.add(loginButton);
			jp4.add(jp2,BorderLayout.NORTH);
			jp4.add(contentPane,BorderLayout.SOUTH);
			jf.add(jp3,BorderLayout.SOUTH);
			jf.add(jp4,BorderLayout.CENTER);
			jf.add(jp1,BorderLayout.NORTH);


		
		jf.pack();
		jf.setSize(500, 300);
		
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	//注册用户和密码 （1）首先先检查数据库中是否有相应的数据，如果有的话提示"该用户存在，请直接登录。"
	private void cheakAdmin(String A_id,String A_password) throws Exception
	{    
		if (validateAdmin(IDField.getText(),passField.getText()))
		{
			JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
		}
 
		else
		{
			String sql="insert ignore into Admin values(?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, A_id);
			pstmt.setString(2, A_password);
		    pstmt.executeUpdate();
		    JOptionPane.showMessageDialog(jf, "注册成功请登录。。。。");
		}
	}
	private void cheakBuyer(String B_no,String B_password) throws Exception
	{    
		if (validateBuyer(IDField.getText(),passField.getText()))
		{
			JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
		}
 
		else
		{
			String sql="insert ignore into Buyer values(?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","19990310");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, B_no);
			pstmt.setString(2, B_password);
		    pstmt.executeUpdate();
		    JOptionPane.showMessageDialog(jf, "注册成功请登录。。。。");
		}
	}
	private void cheakSeller(String S_no,String S_password) throws Exception
	{    
		if (validateSeller(IDField.getText(),passField.getText()))
		{
			JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
		}
 
		else
		{
			String sql="insert ignore into Seller values(?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, S_no);
			pstmt.setString(2, S_password);
		    pstmt.executeUpdate();
		    JOptionPane.showMessageDialog(jf, "注册成功请登录。。。。");
		}
	}
	
	
	//判断数据库中是否有该用户名和密码
	private boolean validateAdmin(String id,String password)
	{
		
			String sql="select *from Admin where Admin.A_id='"+id+"'and Admin.A_password='"+password+"'";
			try(
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
				Statement pstmt = conn.createStatement();
				ResultSet rs=pstmt.executeQuery(sql))
		{	//如果查询的ResultSet里有超过一条的记录，则登录成功
				if (rs.next())
				{
					return true;
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return false;
		}
	
	private boolean validateBuyer(String no,String password)
	{
		
			String sql="select *from Buyer where Buyer.B_no='"+no+"'and Buyer.B_password='"+password+"'";
			try(
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
				Statement pstmt = conn.createStatement();
				ResultSet rs=pstmt.executeQuery(sql))
		{	//如果查询的ResultSet里有超过一条的记录，则登录成功
				if (rs.next())
				{
					return true;
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return false;
		}	
	private boolean validateSeller(String no,String password)
	{
		
			String sql="select *from Seller where Seller.S_no='"+no+"'and Seller.S_password='"+password+"'";
			try(
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
				Statement pstmt = conn.createStatement();
				ResultSet rs=pstmt.executeQuery(sql))
		{	//如果查询的ResultSet里有超过一条的记录，则登录成功
				if (rs.next())
				{
					return true;
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return false;
		}

 
	public static void main(String[] args) throws Exception
	{
		new dao().init();
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
