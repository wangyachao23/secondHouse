package Admininfa;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import AdminDao.SellerDao;
import AdminsqlMod.SQLBuyer;
import AdminsqlMod.SQLSeller;
import JDBC.jdbc;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Sellerinfo extends JInternalFrame {
	private JTable tableSeller;
	private JTextField Snotext;	
	
	jdbc jdbcBean=new jdbc();
	SellerDao sellerDao=new SellerDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sellerinfo frame = new Sellerinfo();
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
	public Sellerinfo() {
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,744,319);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 45, 700, 225);
		getContentPane().add(scrollPane);
		
		tableSeller = new JTable();
		tableSeller.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5356\u5BB6\u7F16\u53F7", "\u7528\u6237ID", "\u59D3\u540D", "\u5BC6\u7801", "\u90AE\u7BB1", "\u5730\u5740", "\u7535\u8BDD", "\u8BA2\u5355"
			}
		));
		tableSeller.getColumnModel().getColumn(0).setPreferredWidth(71);
		tableSeller.getColumnModel().getColumn(1).setPreferredWidth(62);
		tableSeller.getColumnModel().getColumn(3).setPreferredWidth(83);
		tableSeller.getColumnModel().getColumn(4).setPreferredWidth(97);
		tableSeller.getColumnModel().getColumn(5).setPreferredWidth(156);
		tableSeller.getColumnModel().getColumn(6).setPreferredWidth(88);
		scrollPane.setViewportView(tableSeller);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5356\u5BB6\u7F16\u53F7");
		lblNewLabel.setBounds(155, 14, 99, 18);
		getContentPane().add(lblNewLabel);
		
		Snotext = new JTextField();
		Snotext.setBounds(268, 11, 151, 24);
		getContentPane().add(Snotext);
		Snotext.setColumns(10);
		
		JButton Snobutton = new JButton("\u67E5\u8BE2");
		Snobutton.setIcon(new ImageIcon("search.png"));
		Snobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s_no=Snotext.getText();
				SQLSeller sqlSeller =new SQLSeller();
				sqlSeller.setS_no(s_no);
				fillSeller(sqlSeller);
			}
		});
		Snobutton.setBounds(433, 10, 83, 27);
		getContentPane().add(Snobutton);
		fillSeller(new SQLSeller());
	}
	public void fillSeller(SQLSeller sqlSeller ) {
		DefaultTableModel dtm4=(DefaultTableModel) tableSeller.getModel();
		dtm4.setRowCount(0);
		Connection con=null;
		try {
		con=jdbcBean.getConnection();
		ResultSet rs2=sellerDao.SellerList(con, sqlSeller);
		while(rs2.next()) {
			Vector<Object> v=new Vector<Object>();
			v.add(rs2.getObject("S_no"));
			v.add(rs2.getObject("S_id"));
			v.add(rs2.getObject("S_name"));
			v.add(rs2.getObject("S_password"));
			v.add(rs2.getObject("S_email"));
			v.add(rs2.getObject("S_add"));
			v.add(rs2.getObject("S_tel"));
			//v.add(rs2.getObject("order"));
			dtm4.addRow(v);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			jdbcBean.Closect(con);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
}
