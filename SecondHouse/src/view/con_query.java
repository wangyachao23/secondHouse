package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.jws.Oneway;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import util.HouseInfo;
import util.getinfo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class con_query extends JFrame {

	private JPanel contentPane;
	private JTable table;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	private Object s,s1,s2,s3,s4,s5;
	private int num;
	Connection con= houseInfo.getConnection();
	private String usename;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con_query frame = new con_query(null,null,null,null,null,null);
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
	public con_query(Object s,Object s1,Object s2,Object s3,Object s4,Object s5) {
		this.s=s;this.s1=s1;this.s2=s2;this.s3=s3;
		this.s4=s4;this.s5=s5;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(410, 155, 605, 490);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);

		 table = new JTable();
		 table.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		Point point=e.getPoint();
				int row=table.rowAtPoint(point);
				int column=table.columnAtPoint(point);
				if(column==15)
				{
					//int result=JOptionPane.showConfirmDialog(null, "确定提交订单？");
					try {
						/*int valuex=JOptionPane.showConfirmDialog(select.this,
								"你确认要提交吗？", "请确认",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);*/
						int result=JOptionPane.showConfirmDialog(null, "确定提交租房订单？");
					if (result==JOptionPane.YES_OPTION) {
						int  s=(int)table.getValueAt(row, 13);
						String str=(String)table.getValueAt(row, 0);
						String str1=(String)table.getValueAt(row, 1);
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
				
			
		 	if(column==16)
			{
				//int result=JOptionPane.showConfirmDialog(null, "确定提交订单？");
				try {
					/*int valuex=JOptionPane.showConfirmDialog(select.this,
							"你确认要提交吗？", "请确认",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);*/
					int result=JOptionPane.showConfirmDialog(null, "确定提交买房订单？");
				if (result==JOptionPane.YES_OPTION) {
					int  s=(int)table.getValueAt(row, 13);
					String str=(String)table.getValueAt(row, 0);
					String str1=(String)table.getValueAt(row, 1);
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u6E90\u7F16\u53F7","卖家号", "\u623F\u6E90\u540D\u79F0", "\u6240\u5C5E\u5730\u5740", "\u5EFA\u7B51\u5355\u4F4D", "\u671D\u5411", "\u6237\u578B", "\u9762\u79EF", "\u697C\u5C42", "\u5355\u5143\u53F7", "\u8F66\u5E93\u9762\u79EF", "\u88C5\u4FEE\u72B6\u51B5", "\u7269\u4E1A\u7BA1\u7406\u8D39", "\u623F\u6E90\u72B6\u6001", "\u4EF7\u683C", "提交租房订单","提交买房订单"
			}
		));
		javax.swing.table.TableColumn tablecolumn3 = table.getColumn("提交租房订单");  
        DefaultTableCellRenderer backGroundColor3 = new DefaultTableCellRenderer();
        backGroundColor3.setForeground(Color.BLUE);   
        tablecolumn3.setCellRenderer(backGroundColor3);
		javax.swing.table.TableColumn tablecolumn31 = table.getColumn("提交买房订单");  
        DefaultTableCellRenderer backGroundColor31 = new DefaultTableCellRenderer();
        backGroundColor3.setForeground(Color.BLUE);   
        tablecolumn31.setCellRenderer(backGroundColor3);
		scrollPane.setViewportView(table);
		this.fillTable();
	}
	public  void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		Connection con=null;
		try {
		con= houseInfo.getConnection();
		ResultSet rs=getinfo.HouseList1(con,s,s1,s2,s3,s4,s5);
		while(rs.next()) {
			Vector v=new Vector();
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
