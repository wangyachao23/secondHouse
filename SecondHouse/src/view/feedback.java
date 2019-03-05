package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

import util.HouseInfo;
import util.dao;
import util.getinfo;

import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JTable;

public class feedback extends JFrame {

	private static final String String = null;
	private JPanel contentPane;
	private String usename;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	dao dao=new dao();
	static ResultSet res;
	static PreparedStatement sql;
	Connection con= houseInfo.getConnection();
	public TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback frame = new feedback(null);
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
	public feedback(String usename) {
		this.usename=usename;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		TextArea textArea = new TextArea("点击输入文字...");
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1){
					textArea.setText("");}
			}
		});
		textArea.setBounds(0, 0, 440, 88);
		contentPane.add(textArea);
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  str=textArea.getText();
				try {
					int valuex=JOptionPane.showConfirmDialog(feedback.this,
							"你确认要提交吗？", "请确认",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);	
				if (valuex==JOptionPane.YES_OPTION) {
					getinfo.fankui(con,str,usename);
					textArea.setText("");
					}		
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(302, 205, 93, 23);
		contentPane.add(button);
		
		Button button_1 = new Button("查看我的反馈");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new seefeedback(usename).setVisible(true);
			}
});
		button_1.setBounds(144, 205, 76, 23);
		contentPane.add(button_1);
	}	
}
