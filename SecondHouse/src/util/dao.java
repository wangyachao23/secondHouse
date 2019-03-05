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
	private JFrame jf=new JFrame("��¼");
	private JPanel jp1=new JPanel();
	private JPanel jp2=new JPanel();
	private JPanel jp3=new JPanel();
	private JPanel jp4=new JPanel();
	private JButton jb1=new JButton("ע��");
	private JTextField IDField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("��¼");
	public  Object usename;
	Connection con=null;
	User username=new User();
	public dao() {
		//System.out.println(123);
	}
	public void init()throws Exception
	{
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

		// ��������
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Ϊ��¼��ť����¼�������
		loginButton.addActionListener(e -> {
			// ��¼�ɹ�����ʾ����¼�ɹ���
			if(IDStr=="����Ա") {
				//System.out.println(IDField.getText() +"\t"+passField.getText()+"\t"+validateAdmin(IDField.getText(),passField.getText()));
				if (validateAdmin(IDField.getText(),passField.getText()))
				{	
					String Adminname=IDField.getText();
					JOptionPane.showMessageDialog(jf, "��¼�ɹ�");
				}
				// ������ʾ����¼ʧ�ܡ�
				else
				{
					JOptionPane.showMessageDialog(jf, "��¼ʧ��");
				}
			}else if(IDStr=="���") {
				System.out.println(IDField.getText()+"\t"+passField.getText()+"\t"+validateBuyer(IDField.getText(),passField.getText()));
				if (validateBuyer(IDField.getText(),passField.getText()))
				{	
					String Buyername=IDField.getText();
					dispose();
					new BuyerMain(Buyername).setVisible(true);
					JOptionPane.showMessageDialog(jf, "��¼�ɹ�");
					System.out.println(usename);
					
				}
				// ������ʾ����¼ʧ�ܡ�
				else
				{
					JOptionPane.showMessageDialog(jf, "��¼ʧ��");
				}
			}else {
				System.out.println(IDField.getText() +"\t"+passField.getText()+"\t"+validateSeller(IDField.getText(),passField.getText()));
				if (validateSeller(IDField.getText(),passField.getText()))
				{
					String Sellername=IDField.getText();
					dispose();
					new BuyerMain(Sellername).setVisible(true);
					JOptionPane.showMessageDialog(jf, "��¼�ɹ�");
				}
				// ������ʾ����¼ʧ�ܡ�
				else
				{
					JOptionPane.showMessageDialog(jf, "��¼ʧ��");
				}
			}
			
		});
		/*
		jb1.addActionListener(e -> {
			// ��¼�ɹ�����ʾ����¼�ɹ���
			if(IDStr=="����Ա") {
				System.out.println(IDField.getText()+passField.getText()+"\t"+validateAdmin(IDField.getText(),passField.getText()));
				try {
					cheakAdmin(IDField.getText(),passField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(IDStr=="���") {
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
			JLabel IDLabel = new JLabel("��ݣ�");
			IDLabel.setBounds(20, 290, 50, 20);
			JRadioButton buyerRadioButton = new JRadioButton("���");
			buyerRadioButton.setBounds(70, 290, 100, 20);
			buyerRadioButton.setSelected(true);
			buyerRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	 
					if (buyerRadioButton.isSelected()) {
						IDStr = buyerRadioButton.getText();
					}
				}
			});
	 
			JRadioButton sellerRadioButton = new JRadioButton("����");
			sellerRadioButton.setBounds(200, 290, 100, 20);
			sellerRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (sellerRadioButton.isSelected()) {
						IDStr = sellerRadioButton.getText();
					}
				}
			});
			JRadioButton adminRadioButton = new JRadioButton("����Ա");
			adminRadioButton.setBounds(200, 290, 100, 20);
			adminRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (adminRadioButton.isSelected()) {
						IDStr = adminRadioButton.getText();
					}
				}
			});
			//�˴������Ƕ�JRadioButton���з�������Դﵽ����Ч��
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
			jp2.add(new Label("���룺"));
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
	//ע���û������� ��1�������ȼ�����ݿ����Ƿ�����Ӧ�����ݣ�����еĻ���ʾ"���û����ڣ���ֱ�ӵ�¼��"
	private void cheakAdmin(String A_id,String A_password) throws Exception
	{    
		if (validateAdmin(IDField.getText(),passField.getText()))
		{
			JOptionPane.showMessageDialog(jf, "���Ѿ����˺�����ֱ�ӵ�¼��");
		}
 
		else
		{
			String sql="insert ignore into Admin values(?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, A_id);
			pstmt.setString(2, A_password);
		    pstmt.executeUpdate();
		    JOptionPane.showMessageDialog(jf, "ע��ɹ����¼��������");
		}
	}
	private void cheakBuyer(String B_no,String B_password) throws Exception
	{    
		if (validateBuyer(IDField.getText(),passField.getText()))
		{
			JOptionPane.showMessageDialog(jf, "���Ѿ����˺�����ֱ�ӵ�¼��");
		}
 
		else
		{
			String sql="insert ignore into Buyer values(?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","19990310");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, B_no);
			pstmt.setString(2, B_password);
		    pstmt.executeUpdate();
		    JOptionPane.showMessageDialog(jf, "ע��ɹ����¼��������");
		}
	}
	private void cheakSeller(String S_no,String S_password) throws Exception
	{    
		if (validateSeller(IDField.getText(),passField.getText()))
		{
			JOptionPane.showMessageDialog(jf, "���Ѿ����˺�����ֱ�ӵ�¼��");
		}
 
		else
		{
			String sql="insert ignore into Seller values(?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, S_no);
			pstmt.setString(2, S_password);
		    pstmt.executeUpdate();
		    JOptionPane.showMessageDialog(jf, "ע��ɹ����¼��������");
		}
	}
	
	
	//�ж����ݿ����Ƿ��и��û���������
	private boolean validateAdmin(String id,String password)
	{
		
			String sql="select *from Admin where Admin.A_id='"+id+"'and Admin.A_password='"+password+"'";
			try(
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
				Statement pstmt = conn.createStatement();
				ResultSet rs=pstmt.executeQuery(sql))
		{	//�����ѯ��ResultSet���г���һ���ļ�¼�����¼�ɹ�
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
		{	//�����ѯ��ResultSet���г���һ���ļ�¼�����¼�ɹ�
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
		{	//�����ѯ��ResultSet���г���һ���ļ�¼�����¼�ɹ�
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
