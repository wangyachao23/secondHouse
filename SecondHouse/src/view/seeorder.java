package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.HouseInfo;
import util.dao;
import util.getinfo;

public class seeorder extends JFrame {

	private JPanel contentPane;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	dao dao=new dao();
	private String usename;
	private JScrollPane scrollPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seeorder frame = new seeorder(null);
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
	public seeorder(String usename) {
		this.usename=usename;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u4E70\u5BB6\u53F7", "\u5356\u5BB6\u53F7", "\u623F\u6E90\u7F16\u53F7", "\u8BA2\u5355\u72B6\u6001"
			}
		));
		scrollPane.setViewportView(table);
		this.fillTable();
	}
	public void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		Connection con=null;
		try {
			con= houseInfo.getConnection();
			String sql ="select * from B_order where B_no=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setObject(1,usename);					
			ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("order_no"));
			v.add(rs.getObject("B_no"));
			v.add(rs.getObject("S_no"));
			v.add(rs.getObject("H_no"));
			v.add(rs.getObject("order_stu"));
			/*v.add(rs.getObject("S_name"));
			v.add(rs.getObject("S_tel"));
			v.add(rs.getObject("B_name"));
			v.add(rs.getObject("B_tel"));*/
			dtm.addRow(v);
		}
		Vector v=new Vector();
		//添加空行，美化
		for(int i=0;i<30;i++) {
			dtm.addRow(v);
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//关闭数据库连接避免发生异常
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


}
