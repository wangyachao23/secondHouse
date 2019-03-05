package com.system.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.system.dao.SellerDao;
import com.system.model.Houseinfo;
import com.system.model.Seller;
import com.system.util.DbUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchSellerInterFrm extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	SellerDao sellerDao=new SellerDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchSellerInterFrm frame = new SearchSellerInterFrm();
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
	public SearchSellerInterFrm() {
		setTitle("\u67E5\u8BE2\u5356\u5BB6\u4FE1\u606F");
		setClosable(true);
		setBounds(100, 100, 542, 401);
		getContentPane().setLayout(null);
//		重写一个点进去查询所有的函数
		
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u53F7\uFF1A");
		lblNewLabel.setBounds(51, 34, 54, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 31, 117, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");//"查询"按钮的action
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s_no=textField.getText();
				Seller seller=new Seller();
				seller.setS_no(s_no);
				fillTable(seller);  //空查询所有，否则查询指定卖家注册号的信息
			}
		});
		button.setBounds(319, 30, 93, 23);
		getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 96, 439, 217);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6CE8\u518C\u53F7", "ID", "\u59D3\u540D", "\u5BC6\u7801", "Email", "\u5730\u5740", "\u7535\u8BDD"
			}
		));
		scrollPane.setViewportView(table);

	}
	public void fillTable(Seller seller) {
	DefaultTableModel dtm=(DefaultTableModel) table.getModel();
	dtm.setRowCount(0);
	Connection con=null;
	try {
		con=dbUtil.getCon();
		ResultSet rs=sellerDao.sellerList(con,seller);
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("S_no"));
			v.add(rs.getString("S_id"));
			v.add(rs.getString("S_name"));
			v.add(rs.getString("S_password"));
			v.add(rs.getString("S_email"));
			v.add(rs.getString("S_add"));
			v.add(rs.getString("S_tel"));
			dtm.addRow(v);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}
}
