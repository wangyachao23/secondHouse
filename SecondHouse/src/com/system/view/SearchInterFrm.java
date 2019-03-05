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

import com.system.dao.HouseinfoDao;
import com.system.model.Houseinfo;
import com.system.util.DbUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SearchInterFrm extends JInternalFrame {
	private JTextField Txt;
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	HouseinfoDao houseinfoDao=new HouseinfoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchInterFrm frame = new SearchInterFrm();
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
	public SearchInterFrm() {
		
		setTitle("\u67E5\u8BE2\u623F\u6E90\u4FE1\u606F");
		setClosable(true);
		setBounds(100, 100, 624, 449);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 78, 546, 318);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u6E90\u7F16\u53F7", "\u5356\u5BB6\u53F7", "\u623F\u6E90\u540D\u79F0", "\u6240\u5C5E\u5730\u5740", "\u5EFA\u7B51\u5355\u4F4D", "\u671D\u5411", "\u6237\u578B", "\u9762\u79EF", "\u697C\u5C42", "\u5355\u5143\u53F7", "\u8F66\u5E93\u9762\u79EF", "\u88C5\u4FEE\u72B6\u51B5", "\u7269\u4E1A\u8D39", "\u623F\u6E90\u72B6\u6001", "\u623F\u5C4B\u552E\u4EF7"
			}
		));
		scrollPane.setViewportView(table);
//		重写一个点进去查询所有的函数
	
		JLabel label = new JLabel("\u623F\u6E90\u7F16\u53F7\uFF1A");
		label.setBounds(33, 29, 83, 15);
		getContentPane().add(label);
		
		Txt = new JTextField();
		Txt.setBounds(126, 26, 111, 21);
		getContentPane().add(Txt);
		Txt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");//"查询"按钮的action
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String h_no=Txt.getText();
				Houseinfo houseinfo=new Houseinfo();
				houseinfo.setH_no(h_no);
				fillTable(houseinfo);  //空查询所有，否则查询指定房源编号的信息
			}
		});
		button.setBounds(297, 25, 93, 23);
		getContentPane().add(button);
		
		

	}
	
	/**
	 * @param houseinfo空查询所有，否则查询指定房源编号的信息
	 */
	public void fillTable(Houseinfo houseinfo) {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=houseinfoDao.houseinfoList(con,houseinfo);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("H_no"));
				v.add(rs.getString("S_no"));
				v.add(rs.getString("H_name"));
				v.add(rs.getString("reg_ad"));
				v.add(rs.getString("Item_cop"));
				v.add(rs.getString("dir"));
				v.add(rs.getString("Stru_na"));
				v.add(rs.getString("area"));
				v.add(rs.getString("floor"));
				v.add(rs.getString("unit_no"));
				v.add(rs.getString("cararea"));
				v.add(rs.getString("fitment"));
				v.add(rs.getString("serverfee"));
				v.add(rs.getString("status"));
				v.add(rs.getString("money"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
