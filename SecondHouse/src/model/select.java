package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import util.HouseInfo;
import util.getinfo;
import view.feedback;
import view.BuyerMain;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JToggleButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.sql.*;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;

import javax.swing.table.TableCellRenderer;

import org.eclipse.swt.widgets.TableColumn;
public class select extends JFrame {

	private JPanel contentPane;
	private JTable info;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	Connection con= houseInfo.getConnection();
	private JButton button;
	private String usename;
	
	/**
	 * Launch the application.
	 */
	//实例化另外一个窗口，以调用方法
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select frame = new select(null);
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
	public select(String usename) {
		this.usename=usename;
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Panel panel_3 = new Panel();
		menuBar.add(panel_3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		info = new JTable();
		info.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point point=e.getPoint();
				int row=info.rowAtPoint(point);
				int column=info.columnAtPoint(point);
				if(column==15)
				{
					//int result=JOptionPane.showConfirmDialog(null, "确定提交订单？");
					try {
						/*int valuex=JOptionPane.showConfirmDialog(select.this,
								"你确认要提交吗？", "请确认",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);*/
						int result=JOptionPane.showConfirmDialog(null, "确定提交租房订单？");
					if (result==JOptionPane.YES_OPTION) {
						int  s=(int)info.getValueAt(row, 13);
						String str=(String)info.getValueAt(row, 0);//房源变号
						String str1=(String)info.getValueAt(row, 1);//卖家注册号
					//	String v=getinfo.cantorder(con, s);
						if(s==2)
						{
							JOptionPane.showConfirmDialog(null, "房源已出租，无法提交");
						}
						else {
						getinfo.selBS(con, usename, str,str1);}
						//System.out.println(str);
						//getinfo.tijiao(con,usename,str,str1);
						}		
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(column==16)
				{
					//int result=JOptionPane.showConfirmDialog(null, "确定提交订单？");
					try {
						/*int valuex=JOptionPane.showConfirmDialog(select.this,
								"你确认要提交吗？", "请确认",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);*/
						int result=JOptionPane.showConfirmDialog(null, "确定提交买房订单？");
					if (result==JOptionPane.YES_OPTION) {
						int  s=(int)info.getValueAt(row, 13);
						String str=(String)info.getValueAt(row, 0);
						String str1=(String)info.getValueAt(row, 1);
						if(s==2)
						{
							JOptionPane.showConfirmDialog(null, "房源已出售，无法提交");
						}
						else {
						getinfo.selBS1(con, usename, str,str1);}
						//System.out.println(str);
						//getinfo.tijiao(con,usename,str,str1);
						}		
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		info.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u6E90\u7F16\u53F7", "\u5356\u5BB6\u53F7", "\u623F\u6E90\u540D\u79F0", "\u6240\u5C5E\u5730\u5740", "\u5EFA\u7B51\u5355\u4F4D", "\u671D\u5411", "\u6237\u578B", "\u9762\u79EF", "\u697C\u5C42", "\u5355\u5143\u53F7", "\u8F66\u5E93\u9762\u79EF", "\u88C5\u4FEE\u72B6\u51B5", "\u7269\u4E1A\u7BA1\u7406\u8D39", "\u623F\u6E90\u72B6\u6001", "\u4EF7\u683C", "\u63D0\u4EA4\u79DF\u623F\u8BA2\u5355", "\u63D0\u4EA4\u4E70\u623F\u8BA2\u5355"
			}
		));
		javax.swing.table.TableColumn tablecolumn3 = info.getColumn("提交租房订单");  
       /**
        * 改变最后提交订单两列为蓝色
        */
		DefaultTableCellRenderer backGroundColor3 = new DefaultTableCellRenderer();
        backGroundColor3.setForeground(Color.BLUE);   
        tablecolumn3.setCellRenderer(backGroundColor3);
		javax.swing.table.TableColumn tablecolumn31 = info.getColumn("提交买房订单");  
        DefaultTableCellRenderer backGroundColor31 = new DefaultTableCellRenderer();
        backGroundColor3.setForeground(Color.BLUE);   
        tablecolumn31.setCellRenderer(backGroundColor3);

		scrollPane.setViewportView(info);
		this.fillTable();
	}

	public  void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) info.getModel();
		Connection con=null;
		try {
		con= houseInfo.getConnection();
		ResultSet rs=getinfo.HouseList(con);
		while(rs.next()) {
			Vector<Object> v=new Vector<Object>();
			v.add(rs.getString("H_no"));
			v.add(rs.getString("S_no"));
			v.add(rs.getObject("H_name"));
			v.add(rs.getObject("reg_ad"));
			v.add(rs.getObject("Item_cop"));
			v.add(rs.getObject("dir"));
			v.add(rs.getObject("Stru_na"));
			v.add(rs.getObject("area"));
			v.add(rs.getObject("floor"));
			v.add(rs.getObject("unit_no"));
			v.add(rs.getObject("cararea"));
			v.add(rs.getObject("fitment"));
			v.add(rs.getObject("serverfee"));
			v.add(rs.getObject("status"));
			v.add(rs.getObject("money"));
			v.add("提交租房订单");
			v.add("提交买房订单");
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
