package util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.graphics.Font;

import view.feedback;

import java.awt.Canvas;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class modrfy_buyerinfo extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	HouseInfo houseInfo=new HouseInfo();
	static String sql;
	Connection con= houseInfo.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modrfy_buyerinfo frame = new modrfy_buyerinfo(null);
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
	public modrfy_buyerinfo(String usename) {
		setTitle("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new java.awt.Font("楷体", 1, 20));
		passwordField = new JPasswordField();
		 
		
		JLabel label_2 = new JLabel("昵称");
		label_2.setFont(new java.awt.Font("楷体", 1, 20));
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 20));
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("地址");
		label_3.setFont(new java.awt.Font("楷体", 1, 20));
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		

		
		JLabel label_4 = new JLabel("电话");
		label_4.setFont(new java.awt.Font("楷体", 1, 20));
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		//Connection con=null;
		getinfo getinfo=new getinfo();
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int valuex=JOptionPane.showConfirmDialog(modrfy_buyerinfo.this,
							"你确认要修改吗？", "请确认",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);	
				if (valuex==JOptionPane.YES_OPTION) {
					String str=new String(passwordField.getPassword());
					if(!str.equals(null)&&!str.equals(""))
					{
						String sql="update Buyer set B_password=? where B_no=?";
						PreparedStatement pstmt=con.prepareStatement(sql);
						pstmt.setObject(1, str);
						pstmt.setObject(2, usename);
						pstmt.execute();
					}
					String str1=textField_1.getText();
					if(!str1.equals(null)&&!str1.equals(""))
					{
						String sql1="update Buyer set B_id=? where B_no=?";
						PreparedStatement pstmt1=con.prepareStatement(sql1);
						pstmt1.setObject(1, str1);
						pstmt1.setObject(2, usename);
						pstmt1.execute();
					}
					String str2=textField_2.getText();
					if(!str2.equals(null)&&!str2.equals(""))
					{	
						System.out.println(str2);
						String sql2="update Buyer set B_email=? where B_no=?";
						PreparedStatement pstmt2=con.prepareStatement(sql2);
						pstmt2.setObject(1, str2);
						pstmt2.setObject(2, usename);
						pstmt2.execute();
					}
					String str3=textField_3.getText();
					if(!str3.equals(null)&&!str3.equals(""))
					{
						String sql3="update Buyer set B_add=? where B_no=?";
						PreparedStatement pstmt3=con.prepareStatement(sql3);
						pstmt3.setObject(1, str3);
						pstmt3.setObject(2, usename);
						pstmt3.execute();
					}
					String str4=textField_4.getText();
					if(!str4.equals(null)&&!str4.equals(""))
					{
						String sql4="update Buyer set B_tel=? where B_no=?";
						PreparedStatement pstmt4=con.prepareStatement(sql4);
						pstmt4.setObject(1, str4);
						pstmt4.setObject(2, usename);
						pstmt4.execute();
					}
					}		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(154)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
										.addGap(18))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_1)
										.addGap(24))))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addGap(193))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(269, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(228))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(122)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addGap(6)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
