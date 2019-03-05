package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.HouseInfo;
import util.dao;
import util.getinfo;

public class seecontract extends JFrame {

	private JPanel contentPane;
	private JTable table;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	dao dao=new dao();
	private String usename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seecontract frame = new seecontract(null);
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
	public seecontract(String usename) {
		this.usename=usename;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u4EA4\u6613\u8FDB\u5EA6", "\u5408\u540C\u7C7B\u578B", "\u4E2D\u4ECB\u59D3\u540D", "\u7B7E\u8BA2\u65F6\u95F4", "\u4E2D\u4ECB\u7535\u8BDD"
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
			String sql ="select * from contract where order_no in (select order_no from B_order where B_no=? )";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setObject(1,usename);					
			ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("order_no"));
			v.add(rs.getObject("progress"));
			v.add(rs.getObject("con_style"));
			v.add(rs.getObject("A_name"));
			v.add(rs.getObject("con_time"));
			v.add(rs.getObject("A_tel"));
			dtm.addRow(v);
		}
		Vector v=new Vector();
		for(int i=0;i<30;i++) {
			dtm.addRow(v);
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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

}
