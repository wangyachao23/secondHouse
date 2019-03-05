package Test;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;

import com.system.view.SellerFrm;

import AdminDao.AdmDao;
import Admininfa.ADindex;
import view.BuyerMain;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame {
	JFrame picframe=new JFrame("二手房交易系统");
	private static String IDStr;
	private JPanel contentPane;
	private JTextField IDField = new JTextField();
	private JTextField textPassword=new JTextField();
	private JPasswordField passField = new JPasswordField();;
	private JButton regButton = new JButton("注册");
	private JButton loginButton = new JButton("登录");
	private JLabel idLabel = new JLabel("用户名：");
	private JLabel passLabel = new JLabel("密    码:");
	private JCheckBox checkBox = new JCheckBox("显示密码");
	private JLabel IDLabel = new JLabel("身     份:");
	private String IDHintText=new String("请输入用户名");
	private String PassHintText=new String("请输入六位以上字符");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new login().Init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setFocusable(true);

		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idLabel.setBounds(135, 118, 72, 18);
		contentPane.add(idLabel);
		

		IDField.setBounds(221, 115, 171, 24);
		contentPane.add(IDField);
		IDField.setColumns(10);
		IDField.setText(IDHintText);
		IDField.setForeground(Color.GRAY);
		
		IDField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				//获取焦点时，清空提示内容
					
				String temp = IDField.getText();
				if(temp.equals(IDHintText)) {
					IDField.setText("");
					IDField.setForeground(Color.BLACK);
				}
			
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				//失去焦点时，没有输入内容，显示提示内容
				
				String temp = IDField.getText();
				if(temp.equals("")) {
					IDField.setForeground(Color.GRAY);
					IDField.setText(IDHintText);
				}
			}
			
		});
		
	
		passLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		passLabel.setBounds(135, 171, 72, 18);
		contentPane.add(passLabel);
		
		textPassword.setBounds(221, 171, 171, 21);
		textPassword.setText(PassHintText);
		textPassword.setForeground(Color.GRAY);
		contentPane.add(textPassword);
		textPassword.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				 //改变输入框的样式
	          passField.setForeground(Color.black);
	           //为密码框添加内部类鼠标监听（鼠标经过事件）  当转换为密码框的时候，自动获取到焦点
	             passField.addMouseListener(new MouseAdapter(){ 
	             public void mouseEntered(MouseEvent e)
	              {
	            	 passField.requestFocus();
	              }
	             });
	           //移除密码输入框，添加文本输入框，面板重画
	             contentPane.remove(textPassword);
	             contentPane.add(passField);
	             passField.setBounds(221, 171, 171, 21);
	             passField.setForeground(Color.BLACK);
	             contentPane.updateUI();
	             contentPane.repaint();
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	
		
		checkBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				//失去焦点时，没有输入内容，显示提示内容
			
				if(new String(passField.getPassword()).length()== 0){
			           contentPane.remove(passField);
			           contentPane.add(textPassword);
			           textPassword.setBounds(221, 171, 171, 21);
			           textPassword.setForeground(Color.GRAY);
			           contentPane.updateUI();
			           contentPane.repaint();
			           }
			
			}
			
		});
		
	
		checkBox.setBounds(420, 169, 133, 27);
		checkBox.setOpaque(false);
		contentPane.add(checkBox);

	
		IDLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		IDLabel.setBounds(135, 229, 72, 18);
		contentPane.add(IDLabel);
		
		JRadioButton adminRadioButton = new JRadioButton("管理员");
		adminRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		adminRadioButton.setBounds(221, 221, 105, 35);
		adminRadioButton.setOpaque(false);
		
		contentPane.add(adminRadioButton);
		adminRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminRadioButton.isSelected()) {
					IDStr = adminRadioButton.getText();
				}
			}
		});
		
		JRadioButton buyerRadioButton = new JRadioButton("买家");
		buyerRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		buyerRadioButton.setBounds(334, 228, 77, 24);
		buyerRadioButton.setOpaque(false);
		contentPane.add(buyerRadioButton);

		buyerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
				if (buyerRadioButton.isSelected()) {
					IDStr = buyerRadioButton.getText();
				}
			}
		});
		
		JRadioButton sellerRadioButton = new JRadioButton("卖家");
		sellerRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sellerRadioButton.setBounds(440, 223, 77, 35);
		sellerRadioButton.setOpaque(false);
		contentPane.add(sellerRadioButton);
		sellerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sellerRadioButton.isSelected()) {
					IDStr = sellerRadioButton.getText();
				}
			}
		});
		ButtonGroup IDGroup = new ButtonGroup();
		IDGroup.add(buyerRadioButton);
		IDGroup.add(sellerRadioButton);
		IDGroup.add(adminRadioButton);
		
	
		loginButton.setBounds(196, 299, 91, 27);
		contentPane.add(loginButton);
		
	
		regButton.setBounds(347, 299, 113, 27);
		contentPane.add(regButton);
		
		
	}
	
	public void Init() throws ClassNotFoundException {
		
		// 加载驱动
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// 为登录按钮添加事件监听器
				loginButton.addActionListener(e -> {
					String str=new String(passField.getPassword());
					// 登录成功则显示“登录成功”
					if(IDStr=="管理员") {
						System.out.println(IDField.getText() +"\t"+str+"\t"+validateAdmin(IDField.getText(),str));
						if (validateAdmin(IDField.getText(),str))
						{
							String Adminname=IDField.getText();
							
							new ADindex(Adminname).setVisible(true);
							JOptionPane.showMessageDialog(picframe, "登录成功");
						}
						// 否则显示“登录失败”
						else
						{
							JOptionPane.showMessageDialog(picframe, "登录失败");
						}
					}else if(IDStr=="买家") {
						System.out.println(IDField.getText() +"\t"+str+"\t"+validateBuyer(IDField.getText(),str));
						if (validateBuyer(IDField.getText(),str))
						{
							String Buyername=IDField.getText();
							
							new BuyerMain(Buyername).setVisible(true);
							JOptionPane.showMessageDialog(picframe, "登录成功");
						}
						// 否则显示“登录失败”
						else
						{
							JOptionPane.showMessageDialog(picframe, "登录失败");
						}
					}else {
						System.out.println(IDField.getText() +"\t"+str+"\t"+validateSeller(IDField.getText(),str));
						if (validateSeller(IDField.getText(),str))
						{
							//String Sellername=IDField.getText();
							
							new SellerFrm().setVisible(true);
							JOptionPane.showMessageDialog(picframe, "登录成功");
						}
						// 否则显示“登录失败”
						else
						{
							JOptionPane.showMessageDialog(picframe, "登录失败");
						}
					}
					
				});
				regButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						picframe.dispose();
						try {
							new RegFrame().Init();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				});
				checkBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED){//被选中
						passField.setEchoChar((char)0);
					}else{
						passField.setEchoChar('*');
					}
					}
					});
				ImageIcon icon=new ImageIcon("house4.png");
				JLabel piclabel=new JLabel(icon);
				piclabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
				
			
				picframe.getLayeredPane().add(piclabel, new Integer(Integer.MIN_VALUE));
				
				JPanel jp=(JPanel)picframe.getContentPane();
				jp.setOpaque(false);
				picframe.getContentPane().add(contentPane);
				picframe.setSize(icon.getIconWidth(),icon.getIconHeight());
				contentPane.setOpaque(false);
				picframe.setVisible(true);
				picframe.setLocationRelativeTo(null);
	}

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
	private boolean validateSeller(String no,String  password)
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
}


