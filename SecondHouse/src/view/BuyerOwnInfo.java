package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.User;

import util.HouseInfo;
import util.dao;
import util.getinfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerOwnInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	dao dao=new dao();
	private String usename;
	//BuyerOwnInfo BuyerOwnInfo=new BuyerOwnInfo(null);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerOwnInfo frame = new BuyerOwnInfo(null);
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

	public BuyerOwnInfo(String usename) {
	this.usename=usename;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton button = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		menuBar.add(button);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u6CE8\u518C\u53F7", "\u8D2D\u623F\u8005ID", "\u59D3\u540D", "\u5BC6\u7801", "Email", "\u5730\u5740", "\u7535\u8BDD"
				}
			));
			scrollPane.setViewportView(table);
			this.fillTable();
	}
			public void fillTable() {
				/**
				 * 调用PreparedStatement用来调用connection.preparedstatemrnt(sql)
				 * 进行数据库对sql 的预编译处理
				 */
				DefaultTableModel dtm=(DefaultTableModel) table.getModel();
				Connection con=null;
				try {
					con= houseInfo.getConnection();
					String sql ="select * from Buyer where B_no=?";
					PreparedStatement pstmt=con.prepareStatement(sql);
					pstmt.setObject(1,usename);		
					//ResultSet 是数据库结果集的数据表，executeQuery()方法将数据库响应的查询结果存放在ResultSet
					ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					Vector v=new Vector();
					v.add(rs.getString("B_no"));
					v.add(rs.getObject("B_id"));
					v.add(rs.getObject("B_name"));
					v.add(rs.getObject("B_password"));
					v.add(rs.getObject("B_email"));
					v.add(rs.getObject("B_add"));
					v.add(rs.getObject("B_tel"));
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


