package Admininfa;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import AdminDao.HouseDao;
import AdminDao.OrderDao;
import AdminsqlMod.SQLHouse;
import AdminsqlMod.SQLNotice;
import AdminsqlMod.SQLSeller;
import JDBC.StringUtil;
import JDBC.jdbc;
import view.contract;

import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class ADindex extends JFrame {
	/**
	 * 用于创建界面
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panel_left,panel_right;
	JPanel jp_r1,jp_r2,jp_r3,jp_r4,jp_r5;
	CardLayout c1=new CardLayout();
	private JButton button_look;
	private JButton button_issu;
	private JButton btnNewButton;
	private  String user;
	private String userAd="01";
	private JTextField Housetext;
	private JLabel lblNewLabel;
	private JButton Housecheck;
	private JLabel lblNewLabel_1;
	private JTable tableHouse;
	jdbc jdbcBean=new jdbc();
	HouseDao houseDao =new HouseDao();
	OrderDao orderDao=new OrderDao();
	private JButton deleHbutton;
	private JLabel label_2;
	private JTextField Hnotext;
	private JTable tableOrder;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADindex frame = new ADindex(null);
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
	public ADindex(String userAd) {
		this.user=userAd;
		setTitle("\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//将整个panel分为两个界面
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 877, 453);
		contentPane.add(splitPane);
		//左边的panel为122像素
		splitPane.setDividerLocation(130);
		splitPane.setDividerSize(2);
		panel_left = new JPanel();
		splitPane.setLeftComponent(panel_left);
		panel_left.setLayout(null);
		
		
		JButton button_1 = new JButton("\u7BA1\u7406\u5458\u4FE1\u606F");
		button_1.setIcon(new ImageIcon("userName.png"));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(panel_right, "1");
			}
		});
		button_1.setBounds(0, 0, 129, 61);
		panel_left.add(button_1);
		
		JButton button_2 = new JButton("\u516C\u544A\u7BA1\u7406");
		button_2.setIcon(new ImageIcon("edit.png"));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(panel_right,"2");
			}
		});
		//左边的列表设置
		button_2.setBounds(0, 61, 129, 61);
		panel_left.add(button_2);
		
		JButton button_3 = new JButton("\u7528\u6237\u7BA1\u7406");
		button_3.setIcon(new ImageIcon("me.png"));
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(panel_right, "3");
			}
		});
		button_3.setBounds(0, 116, 129, 61);
		panel_left.add(button_3);
		
		JButton button_4 = new JButton("\u4E8C\u624B\u623F\u7BA1\u7406");
		button_4.setIcon(new ImageIcon("bookManager.png"));
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(panel_right, "4");
			}
		});
		button_4.setBounds(0, 176, 129, 61);
		panel_left.add(button_4);
		
		JButton button_5 = new JButton("\u4EA4\u6613\u7BA1\u7406");
		button_5.setIcon(new ImageIcon("login.png"));
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(panel_right,"5");
			}
		});
	
		button_5.setBounds(0, 235, 129, 61);
		panel_left.add(button_5);
		//退出系统
		JButton btnNewButton_4 = new JButton(" \u9000\u51FA");
		btnNewButton_4.setIcon(new ImageIcon("exit.png"));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "确定退出系统？");
		   		if (result==JOptionPane.YES_OPTION) {
		   			System.exit(0);}
			}
		});
		btnNewButton_4.setBounds(0, 294, 129, 51);
		panel_left.add(btnNewButton_4);
		
		//右边的panel；
		panel_right = new JPanel(c1);
		splitPane.setRightComponent(panel_right);
		
		jp_r1=new JPanel();//用于设置默认图片
		jp_r1.setBackground(Color.WHITE);
	
		
		jp_r2=new JPanel();
		jp_r2.setBackground(Color.WHITE);
		jp_r3=new JPanel();
		jp_r3.setBackground(Color.WHITE);
		
		
		
		jp_r4=new JPanel();
		jp_r4.setBackground(Color.WHITE);
		jp_r5=new JPanel();
		jp_r5.setBackground(Color.WHITE);
		
		panel_right.add("1",jp_r1);
		jp_r1.setLayout(null);
		
		btnNewButton = new JButton("\u67E5\u770B\u4FE1\u606F");
		btnNewButton.setBounds(637, 10, 93, 34);
		jp_r1.add(btnNewButton);
		
		JDesktopPane Admiandesk = new JDesktopPane();
		Admiandesk.setBounds(0, 61, 744, 390);
		jp_r1.add(Admiandesk);
		
		lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u6B22\u8FCE\u4F60\uFF01");
		lblNewLabel.setIcon(new ImageIcon("userName.png"));
		lblNewLabel.setBounds(496, 13, 136, 29);
		jp_r1.add(lblNewLabel);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Adminlook admianlook=new Adminlook(user);
			System.out.println(user);//用于预显示
			admianlook.setVisible(true);
			Admiandesk.add(admianlook);
			}
		});	
		
		panel_right.add("2",jp_r2);
		jp_r2.setLayout(null);		
		button_look = new JButton("\u67E5\u770B\u516C\u544A");	
		button_look.setIcon(new ImageIcon("bookTypeManager.png"));
		button_look.setBounds(0, 0, 399, 71);
		jp_r2.add(button_look);	
		button_issu = new JButton("\u53D1\u5E03\u516C\u544A");		
		button_issu.setIcon(new ImageIcon("modify.png"));
		button_issu.setBounds(398, 0, 346, 71);
		jp_r2.add(button_issu);
		
		JDesktopPane AnnoDesk = new JDesktopPane();
		AnnoDesk.setBounds(0, 69, 744, 369);
		jp_r2.add(AnnoDesk);
		
		JLabel label_1 = new JLabel("\u53D1\u5E03\u65F6\u95F4");
		label_1.setBounds(280, 27, 72, 18);
		button_issu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntFrame_issu intFrame=new IntFrame_issu();
				intFrame.setVisible(true);
				AnnoDesk.add(intFrame);
			}
		});
		button_look.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IntFrame_look intFrame_look=new IntFrame_look();
				intFrame_look.setVisible(true);
				AnnoDesk.add(intFrame_look);
			}
		});

		panel_right.add("3",jp_r3);
		jp_r3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u4E70\u5BB6\u4FE1\u606F");	
		btnNewButton_1.setBounds(0, -2, 361, 64);
		jp_r3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5356\u5BB6\u4FE1\u606F");
		
		btnNewButton_2.setBounds(358, 0, 386, 60);
		jp_r3.add(btnNewButton_2);
		
		JDesktopPane userdesk = new JDesktopPane();
		userdesk.setBounds(0, 60, 744, 391);
		jp_r3.add(userdesk);
		//实现Buyer和Seller的内置页面
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyerInfo buyerInfo=new BuyerInfo();
				buyerInfo.setVisible(true);
				userdesk.add(buyerInfo);
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sellerinfo sellerinfo=new Sellerinfo();
				sellerinfo.setVisible(true);
				userdesk.add(sellerinfo);
			}
		});
		
		
		panel_right.add("4",jp_r4);
		jp_r4.setLayout(null);
		
		Housetext = new JTextField();
		Housetext.setBounds(124, 14, 154, 24);
		jp_r4.add(Housetext);
		Housetext.setColumns(10);
		//条件查询
		Housecheck = new JButton("\u67E5\u8BE2");
		Housecheck.setIcon(new ImageIcon("search.png"));
		Housecheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String h_no=Housetext.getText();
				SQLHouse sqlHouse=new SQLHouse();
				sqlHouse.setH_no(h_no);
				filltableHouse(sqlHouse);
			}	
		});
		Housecheck.setBounds(294, 13, 84, 27);
		jp_r4.add(Housecheck);
		
		lblNewLabel_1 = new JLabel("\u623F\u6E90\u7F16\u53F7");
		lblNewLabel_1.setBounds(48, 17, 72, 18);
		jp_r4.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 48, 744, 350);
		jp_r4.add(scrollPane);
		
		tableHouse = new JTable();
		//获取删除房源的点击事件
		tableHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=tableHouse.getSelectedRow();
				Hnotext.setText((String)tableHouse.getValueAt(row,0));
			}
		});
		tableHouse.setRowSelectionAllowed(false);
		tableHouse.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u6E90\u7F16\u53F7", "\u623F\u6E90\u540D\u79F0", "\u6240\u5C5E\u5730\u5740", "\u5EFA\u7B51\u5355\u4F4D", "\u671D\u5411", "\u6237\u578B", "\u9762\u79EF", "\u697C\u5C42", "\u5355\u5143\u53F7", "\u8F66\u5E93\u9762\u79EF", "\u88C5\u4FEE\u72B6\u51B5", "\u7269\u4E1A\u7BA1\u7406\u8D39", "\u623F\u6E90\u72B6\u6001", "\u4EF7\u683C"
			}
		));
		tableHouse.getColumnModel().getColumn(0).setPreferredWidth(107);
		tableHouse.getColumnModel().getColumn(1).setPreferredWidth(95);
		tableHouse.getColumnModel().getColumn(2).setPreferredWidth(198);
		tableHouse.getColumnModel().getColumn(3).setPreferredWidth(109);
		tableHouse.getColumnModel().getColumn(11).setPreferredWidth(101);
		tableHouse.getColumnModel().getColumn(12).setPreferredWidth(77);
		scrollPane.setViewportView(tableHouse);
		
		deleHbutton = new JButton("\u5220\u9664\u623F\u6E90");
		deleHbutton.setIcon(new ImageIcon("delete.png"));
		deleHbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no=Hnotext.getText();
				if(StringUtil.isEmpty(no)) {
					JOptionPane.showMessageDialog(null,"请选择要删除的行");
					return;
				}
				Connection con=null;
				try {
					con=jdbcBean.getConnection();
					int num=houseDao.HouseDelete(con,no);
					if(num==1) {
						JOptionPane.showMessageDialog(null,"删除成功");
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						jdbcBean.Closect(con);
					}catch(Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		deleHbutton.setBounds(617, 411, 113, 27);
		jp_r4.add(deleHbutton);
		
		label_2 = new JLabel("\u623F\u6E90\u7F16\u53F7");
		label_2.setBounds(403, 415, 72, 18);
		jp_r4.add(label_2);
		
		Hnotext = new JTextField();
		Hnotext.setBounds(477, 414, 127, 24);
		jp_r4.add(Hnotext);
		Hnotext.setColumns(10);
		panel_right.add("5",jp_r5);
		jp_r5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 75, 639, 181);
		jp_r5.add(scrollPane_1);
		
		tableOrder = new JTable();
		tableOrder.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u4E70\u5BB6\u7F16\u53F7", "\u5356\u5BB6\u7F16\u53F7", "\u623F\u6E90\u7F16\u53F7", "\u8BA2\u5355\u72B6\u6001"
			}
		));
		scrollPane_1.setViewportView(tableOrder);
		
		JButton buttoncheck = new JButton("\u8BA2\u5355\u67E5\u8BE2");
		buttoncheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filltableorder();
			}
		});
		buttoncheck.setIcon(new ImageIcon("search.png"));
		/*buttoncheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filltableorder();
			}
		});*/
		buttoncheck.setBounds(43, 23, 120, 39);
		jp_r5.add(buttoncheck);
		
		btnNewButton_3 = new JButton("\u4EA4\u6613\u8DDF\u8FDB");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new contract().setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\\u6570\u636E\u5E93\u8BFE\u7A0B\u8BBE\u8BA1\\\u7B2C\u4E94\u8BB2\\images\\base.png"));
		btnNewButton_3.setBounds(54, 306, 120, 39);
		jp_r5.add(btnNewButton_3);
		filltableHouse(new SQLHouse());
		
		
	}
	private void filltableHouse(SQLHouse sqlHouse) {
		DefaultTableModel dtm4=(DefaultTableModel) tableHouse.getModel();
		dtm4.setRowCount(0);
		Connection conn=null;
		try {
			conn=jdbcBean.getConnection();
			ResultSet rs=houseDao.HouseCheck(conn,sqlHouse);
			while(rs.next()) {
				Vector<Object> vt=new Vector<Object>();
				vt.add(rs.getObject("H_no"));
				vt.add(rs.getObject("H_name"));
				vt.add(rs.getObject("reg_ad"));
				vt.add(rs.getObject("Item_cop"));
				vt.add(rs.getObject("dir"));
				vt.add(rs.getObject("Stru_na"));
				vt.add(rs.getObject("area"));
				vt.add(rs.getObject("floor"));
				vt.add(rs.getObject("unit_no"));
				vt.add(rs.getObject("cararea"));
				vt.add(rs.getObject("fitment"));
				vt.add(rs.getObject("serverfee"));
				vt.add(rs.getObject("status"));
				vt.add(rs.getObject("money"));
				//vt.add(rs.getObject("接受订单"));
				dtm4.addRow(vt);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally{
			try {
				jdbcBean.Closect(conn);
			}catch(Exception e5) {
				e5.printStackTrace();
			}
		}
		
	}
	private void filltableorder() {
		DefaultTableModel dtm5=(DefaultTableModel) tableOrder.getModel();
		dtm5.setRowCount(0);
		Connection con=null;
		try {
			con=jdbcBean.getConnection();
			ResultSet rst=orderDao.OrderList(con);
			while(rst.next()) {
				Vector<Object> vto=new Vector<Object>();
				vto.add(rst.getObject("order_no"));
				vto.add(rst.getObject("B_no"));
				vto.add(rst.getObject("S_no"));
				vto.add(rst.getObject("H_no"));
				vto.add(rst.getObject("order_stu"));
				dtm5.addRow(vto);
			}
		}catch(Exception e3) {
			e3.printStackTrace();
		}finally{
			try {
				jdbcBean.Closect(con);
			}catch(Exception e4) {
				e4.printStackTrace();
			}
		}
		
	}
}
