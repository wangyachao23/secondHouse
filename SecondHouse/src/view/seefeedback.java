package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.HouseInfo;
import util.getinfo;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class seefeedback extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String usename;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	Connection con= houseInfo.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seefeedback frame = new seefeedback(null);
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
	public seefeedback(String usename) {
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
				"\u53CD\u9988"
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
		ResultSet rs=getinfo.seefankui(con,usename);
		while(rs.next()) {
			Vector<Object> v=new Vector<Object>();
			v.add(rs.getString("buyerfk"));
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
	}}
}
