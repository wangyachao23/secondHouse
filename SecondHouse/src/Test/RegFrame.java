package Test;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegFrame {
	private JFrame jf=new JFrame("注册");
	private JButton adminButton=new JButton("管理员注册");
	private JButton sellerButton=new JButton("卖方注册");
	private JButton buyerButton=new JButton("买方注册");
	 
	public void Init() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		jf.setLayout(new FlowLayout());
		jf.add(adminButton);
		jf.add(sellerButton);
		jf.add(buyerButton);
	
	
		jf.setVisible(true);
		jf.setSize(500, 300);
		jf.setLocationRelativeTo(null);
		
		adminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				regAdmin();
			}

			private void closeThis() {
				// TODO Auto-generated method stub
				jf.dispose();
			}
			
		});
	
		buyerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				regBuyer();
			}

			private void closeThis() {
				// TODO Auto-generated method stub
				jf.dispose();
			}
			
		});
		
		sellerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeThis();
				regSeller();
			}

			private void closeThis() {
				// TODO Auto-generated method stub
				jf.dispose();
			}
			
		});
		
	}
	
	public void regAdmin() {
		JFrame jf1=new JFrame("管理员注册");
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		JPanel jp6=new JPanel();
		JTextField adIDField=new JTextField(20);
		JTextField adNameField=new JTextField(20);
		JTextField adTelField=new JTextField(20);
		JTextField adPassField=new JTextField(20);
		JButton adminRegButton=new JButton("注册");
		JButton returnButton=new JButton("返回");
		jp1.add(new Label("用户ID:"));
		jp1.add(adIDField);
		jp2.add(new Label("姓    名:"));
		jp2.add(adNameField);
		jp3.add(new Label("电    话:"));
		jp3.add(adTelField);
		jp4.add(new Label("密    码:"));
		jp4.add(adPassField);
		jp5.add(adminRegButton);
		jp5.add(returnButton);
		
		jp6.add(jp2,BorderLayout.NORTH);
		jp6.add(jp3, BorderLayout.CENTER);
		jp6.add(jp4, BorderLayout.SOUTH);
		
		jf1.add(jp1, BorderLayout.NORTH);
		jf1.add(jp6, BorderLayout.CENTER);
		jf1.add(jp5, BorderLayout.SOUTH);
		jf1.addWindowListener(new mylister());
		
		jf1.setSize(500, 300);
		jf1.setLocationRelativeTo(null);
		jf1.setVisible(true);
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					jf1.dispose();
					new login().Init();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		adminRegButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					cheakAdmin(adIDField.getText(),adPassField.getText(),adNameField.getText(),adTelField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			private void cheakAdmin(String A_id,String A_password,String A_name,String A_tel) throws Exception{    
				if (validateAdmin(adIDField.getText(),adPassField.getText()))
				{
					JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
				}else if(validateAdminID(adIDField.getText())) {
					JOptionPane.showMessageDialog(jf, "该账号已被注册");
				}
 
				else
				{
					String sql="insert into Admin(A_id,A_password,A_name,A_tel) values(?,?,?,?)";
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, A_id);
					pstmt.setString(2, A_password);
					pstmt.setString(3, A_name);
					pstmt.setString(4, A_tel);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(jf, "注册成功请登录。。。。");
				}
			}
			private boolean validateAdmin(String id,String password){
			
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
			private boolean validateAdminID(String id){
				
				String sql="select *from Admin where Admin.A_id='"+id+"'";
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
		});
		
		}
	
	public void regBuyer() {
		JFrame jf2=new JFrame("买方注册");
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		JPanel jp6=new JPanel();
		JPanel jp7=new JPanel();
		JPanel jp8=new JPanel();
		JPanel jp9=new JPanel();
		JPanel jp10=new JPanel();
		JPanel jp11=new JPanel();
		JButton returnButton=new JButton("返回");
		JButton buyerRegButton=new JButton("注册");
		JTextField buyNoField=new JTextField(20);
		JTextField buyIDField=new JTextField(20);
		JTextField buyNameField=new JTextField(20);
		JTextField buyPassField=new JTextField(20);
		JTextField buyEmailField=new JTextField(11);
		JTextField buyAddField=new JTextField(20);
		JTextField buyTelField=new JTextField(20);
		JComboBox comboBox=new JComboBox();
		comboBox.addItem("@163.com");
		comboBox.addItem("@126.com");
		comboBox.addItem("@sohu.com");
		comboBox.addItem("@qq.com");
		
		jp1.add(new Label("NO:"));
		jp1.add(buyNoField);
		jp2.add(new Label("ID:"));
		jp2.add(buyIDField);
		jp3.add(new Label("姓名:"));
		jp3.add(buyNameField);
		jp4.add(new Label("密码:"));
		jp4.add(buyPassField);
		jp5.add(new Label("邮箱:"));
		jp5.add(buyEmailField);
		jp5.add(comboBox);
		jp6.add(new Label("地址:"));
		jp6.add(buyAddField);
		jp7.add(new Label("电话:"));
		jp7.add(buyTelField);
		jp8.add(buyerRegButton);
		jp8.add(returnButton);
	
		jp9.add(jp1);
		jp9.add(jp2);
		jp9.add(jp3);
		jp10.add(jp4);
		jp10.add(jp5);
		jp10.add(jp6);
		jp11.add(jp10,BorderLayout.NORTH);
		jp11.add(jp7,BorderLayout.SOUTH);
	
		
		jf2.add(jp9, BorderLayout.NORTH);
		jf2.add(jp11, BorderLayout.CENTER);
		jf2.add(jp8, BorderLayout.SOUTH);
		jf2.setSize(1000, 300);
		jf2.setLocationRelativeTo(null);
		jf2.setVisible(true);
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					jf2.dispose();
					new login().Init();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		buyerRegButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					cheakBuyer(buyNoField.getText(),buyIDField.getText(),buyNameField.getText(),buyPassField.getText(),buyEmailField.getText()+comboBox.getSelectedItem(),buyAddField.getText(),buyTelField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			private void cheakBuyer(String no,String id,String name,String password,String email,String add,String tel) throws Exception{    
				if (validateBuyer(buyNoField.getText(),buyPassField.getText()))
				{
					JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
				}else if(validateBuyerID(buyNoField.getText())) {
					JOptionPane.showMessageDialog(jf, "该账号已被注册。");
				}
				else
				{
					String sql="insert into Buyer(B_no,B_id,B_name,B_password,B_email,B_add,B_tel) values(?,?,?,?,?,?,?)";
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, no);
					pstmt.setString(2, id);
					pstmt.setString(3, name);
					pstmt.setString(4, password);
					pstmt.setString(5, email);
					pstmt.setString(6, add);
					pstmt.setString(7, tel);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(jf, "注册成功请登录。。。。");
				}
			}
			private boolean validateBuyer(String no,String password){
			
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
			private boolean validateBuyerID(String no){
				
				String sql="select *from Buyer where Buyer.B_no='"+no+"'";
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
		});
		
	
	}
	
	
	public void regSeller() {
		JFrame jf3=new JFrame("卖方注册");
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		JPanel jp6=new JPanel();
		JPanel jp7=new JPanel();
		JPanel jp8=new JPanel();
		JPanel jp9=new JPanel();
		JPanel jp10=new JPanel();
		JPanel jp11=new JPanel();
		JButton returnButton=new JButton("返回");
		JButton sellerRegButton=new JButton("注册");
		JTextField sellNoField=new JTextField(20);
		JTextField sellIDField=new JTextField(20);
		JTextField sellNameField=new JTextField(20);
		JTextField sellPassField=new JTextField(20);
		JTextField sellEmailField=new JTextField(11);
		JTextField sellAddField=new JTextField(20);
		JTextField sellTelField=new JTextField(20);
		JComboBox comboBox=new JComboBox();
		comboBox.addItem("@163.com");
		comboBox.addItem("@126.com");
		comboBox.addItem("@sohu.com");
		comboBox.addItem("@qq.com");
		
		jp1.add(new Label("NO:"));
		jp1.add(sellNoField);
		jp2.add(new Label("ID:"));
		jp2.add(sellIDField);
		jp3.add(new Label("姓名:"));
		jp3.add(sellNameField);
		jp4.add(new Label("密码:"));
		jp4.add(sellPassField);
		jp5.add(new Label("邮箱:"));
		jp5.add(sellEmailField);
		jp5.add(comboBox);
		jp6.add(new Label("地址:"));
		jp6.add(sellAddField);
		jp7.add(new Label("电话:"));
		jp7.add(sellTelField);
		jp8.add(sellerRegButton);
		jp8.add(returnButton);
	
		jp9.add(jp1);
		jp9.add(jp2);
		jp9.add(jp3);
		jp10.add(jp4);
		jp10.add(jp5);
		jp10.add(jp6);
		jp11.add(jp10,BorderLayout.NORTH);
		jp11.add(jp7,BorderLayout.SOUTH);
	
		
		jf3.add(jp9, BorderLayout.NORTH);
		jf3.add(jp11, BorderLayout.CENTER);
		jf3.add(jp8, BorderLayout.SOUTH);
		jf3.setSize(1000, 300);
		jf3.setLocationRelativeTo(null);
		jf3.setVisible(true);
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					jf3.dispose();
					new login().Init();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		sellerRegButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					cheakSeller(sellNoField.getText(),sellIDField.getText(),sellNameField.getText(),sellPassField.getText(),sellEmailField.getText()+comboBox.getSelectedItem(),sellAddField.getText(),sellTelField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			private void cheakSeller(String no,String id,String name,String password,String email,String add,String tel) throws Exception{    
				if (validateSeller(sellNoField.getText(),sellPassField.getText()))
				{
					JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
				}
				else if(validateSellerID(sellNoField.getText())) {
					JOptionPane.showMessageDialog(jf, "该账号已被注册。");
				}
 
				else
				{
					String sql="insert into Seller(S_no,S_id,S_name,S_password,S_email,S_add,S_tel) values(?,?,?,?,?,?,?)";
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Second_hand house", "sa","sa");
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, no);
					pstmt.setString(2, id);
					pstmt.setString(3, name);
					pstmt.setString(4, password);
					pstmt.setString(5, email);
					pstmt.setString(6, add);
					pstmt.setString(7, tel);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(jf, "注册成功请登录。。。。");
				}
			}
			private boolean validateSellerID(String no){
				
				String sql="select *from Seller where Seller.S_no='"+no+"'";
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
			private boolean validateSeller(String no,String password){
			
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
		});
	
	}
	
	
	public static void main(String args[]) throws Exception {
		RegFrame rf=new RegFrame();
		rf.Init();
		
	}
}
