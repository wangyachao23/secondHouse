package model;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.User;

import model.*;
import util.HouseInfo;
import util.getinfo;
import view.BuyerMain;

import javax.swing.JMenuBar;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Buyer extends JFrame {

	private JPanel contentPane;
	private JTable info1;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buyer frame = new Buyer();
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
	public Buyer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton button = new JButton("全部购房者信息");
		menuBar.add(button);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);
		 info1 = new JTable();
		info1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6CE8\u518C\u53F7", "\u8D2D\u623F\u8005ID", "\u59D3\u540D", "\u5BC6\u7801", "Email", "\u5730\u5740", "\u7535\u8BDD"
			}
		));
		scrollPane.setViewportView(info1);
		this.fillTable();
	}
	public void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) info1.getModel();
		Connection con=null;
		try {
		con= houseInfo.getConnection();
		ResultSet rs=getinfo.BuyerList(con);
		while(rs.next()) {
			Vector<Object> v=new Vector<Object>();
			v.add(rs.getString("B_no"));
			v.add(rs.getObject("B_id"));
			v.add(rs.getObject("B_name"));
			v.add(rs.getObject("B_password"));
			v.add(rs.getObject("B_email"));
			v.add(rs.getObject("B_add"));
			v.add(rs.getObject("B_tel"));
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
}}
