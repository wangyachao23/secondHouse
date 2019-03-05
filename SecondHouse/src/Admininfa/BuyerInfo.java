package Admininfa;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import AdminDao.BuyerDao;
import AdminsqlMod.SQLBuyer;
import JDBC.jdbc;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BuyerInfo extends JInternalFrame {
	private JTextField notext;
	private JTable tableBuyer;
	jdbc jdbcBean=new jdbc();
	BuyerDao buyerDao=new BuyerDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerInfo frame = new BuyerInfo();
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
	public BuyerInfo() {
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,744,319);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E70\u5BB6\u7F16\u53F7");
		lblNewLabel.setBounds(10, 12, 66, 18);
		getContentPane().add(lblNewLabel);
		
		notext = new JTextField();
		notext.setBounds(108, 9, 127, 24);
		getContentPane().add(notext);
		notext.setColumns(10);
		
		JScrollPane Buyerjsp = new JScrollPane();
		Buyerjsp.setBounds(0, 43, 728, 227);
		getContentPane().add(Buyerjsp);
		
		tableBuyer = new JTable();
		tableBuyer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "ID", "\u59D3\u540D", "\u5BC6\u7801", "\u90AE\u7BB1", "\u5730\u5740", "\u7535\u8BDD"
			}
		));
		tableBuyer.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableBuyer.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableBuyer.getColumnModel().getColumn(2).setPreferredWidth(62);
		tableBuyer.getColumnModel().getColumn(4).setPreferredWidth(99);
		tableBuyer.getColumnModel().getColumn(5).setPreferredWidth(150);
		tableBuyer.getColumnModel().getColumn(6).setPreferredWidth(86);
		Buyerjsp.setViewportView(tableBuyer);
	
		//条件查询事件
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setIcon(new ImageIcon("search.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b_no=notext.getText();
				SQLBuyer sqlBuyer=new SQLBuyer();
				sqlBuyer.setB_no(b_no);
				fillbuyer(sqlBuyer);
			}
		});
		btnNewButton.setBounds(249, 8, 83, 27);
		getContentPane().add(btnNewButton);
		fillbuyer(new SQLBuyer());
	}
	
	public void fillbuyer(SQLBuyer sqlBuyer) {
		DefaultTableModel dtm3=(DefaultTableModel) tableBuyer.getModel();
		dtm3.setRowCount(0);
		Connection con=null;
		try {
			con=jdbcBean.getConnection();
			ResultSet rSet=buyerDao.BuyerLookList(con,sqlBuyer);
			while(rSet.next()) {
				Vector<Object> vs=new Vector<Object>();
				vs.add(rSet.getObject("B_no"));
				vs.add(rSet.getObject("B_id"));
				vs.add(rSet.getObject("B_name"));
				vs.add(rSet.getObject("B_password"));
				vs.add(rSet.getObject("B_email"));
				vs.add(rSet.getObject("B_add"));
				vs.add(rSet.getObject("B_tel"));
				dtm3.addRow(vs);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {try 
		{
			jdbcBean.Closect(con);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
		
 }
}
