package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.HouseInfo;
import util.dao;
import util.getinfo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class contract extends JFrame {

	private JPanel contentPane;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	Connection con=houseInfo.getConnection();
	dao dao=new dao();
	private String usename;
	public String s1,s2,s3;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contract frame = new contract();
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
	public contract() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_5 = new JLabel("\u5408\u540C\u7C7B\u578B");
		label_5.setBounds(90, 137, 54, 15);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(154, 134, 78, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("\u7B7E\u8BA2\u65F6\u95F4");
		label_6.setBounds(90, 170, 54, 15);
		contentPane.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(154, 167, 78, 21);
		contentPane.add(textField_6);
		
		JLabel label_7 = new JLabel("\u4EA4\u6613\u8FDB\u5EA6");
		label_7.setBounds(261, 97, 54, 15);
		contentPane.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(342, 94, 78, 21);
		contentPane.add(textField_7);
		
		JLabel label_8 = new JLabel("\u4E2D\u4ECB\u59D3\u540D");
		label_8.setBounds(261, 137, 54, 15);
		contentPane.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(342, 134, 78, 21);
		contentPane.add(textField_8);
		
		JLabel label_9 = new JLabel("\u4E2D\u4ECB\u7535\u8BDD");
		label_9.setBounds(261, 170, 54, 15);
		contentPane.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(342, 167, 78, 21);
		contentPane.add(textField_9);
		JLabel label = new JLabel("\u8BA2\u5355\u53F7");
		label.setBounds(90, 94, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(154, 94, 78, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1=textField.getText();//订单号
				String str2=textField_7.getText();//交易进度
				String str3=textField_5.getText();//合同类型
				String str4=textField_8.getText();//中介姓名
				String str5=textField_6.getText();//签订时间
				String str6=textField_9.getText();//中介电话
				try {
					getinfo.contract(con, str1, str2, str3, str4, str5, str6);
					getinfo.changehouseinfo(con,str1 );//改变房源中的房源状态
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			}
			
		});
		button.setBounds(186, 269, 107, 32);
		contentPane.add(button);
		

	}
}
