package Admininfa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import AdminDao.AdmDao;
import AdminsqlMod.SQLAdmin;
import JDBC.StringUtil;
import JDBC.jdbc;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Adminlook extends JInternalFrame {
	private JTable tableAdmin;
	private JPanel conjpe;
	private  String a_id;
	jdbc jdbcBean=new jdbc();
	AdmDao admDao=new AdmDao();
	private JTextField idtext;
	private JTextField nametext;
	private JTextField teltext;
	private JTextField passwordtext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlook frame = new Adminlook(null);
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
	public Adminlook(String id) {
		setClosable(true);
		setIconifiable(true);
		//super();
		setBounds(0, 0, 740, 400);
		//setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		conjpe = new JPanel();
		conjpe.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(conjpe);
		conjpe.setLayout(null);
		
		JScrollPane Adminjsp = new JScrollPane();
		Adminjsp.setBounds(14, 45, 700, 136);
		conjpe.add(Adminjsp);
		tableAdmin = new JTable();
		//点击获取相应行的值
		tableAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=tableAdmin.getSelectedRow();
				idtext.setText((String)tableAdmin.getValueAt(row,0));
				nametext.setText((String)tableAdmin.getValueAt(row,1));
				teltext.setText((String)tableAdmin.getValueAt(row, 2));
				passwordtext.setText((String)tableAdmin.getValueAt(row,3));
			}
		});
		tableAdmin.setRowSelectionAllowed(false);
		tableAdmin.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "\u59D3\u540D", "\u7535\u8BDD", "\u5BC6\u7801"
			}
		));
		tableAdmin.getColumnModel().getColumn(1).setPreferredWidth(53);
		tableAdmin.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableAdmin.getColumnModel().getColumn(3).setPreferredWidth(73);
			Adminjsp.setViewportView(tableAdmin);
			
			JLabel lblNewLabel = new JLabel("\u6211\u7684\u4FE1\u606F");
			lblNewLabel.setBounds(14, 0, 142, 45);
			conjpe.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("\u6211\u7684id");
			btnNewButton.setBounds(55, 215, 86, 27);
			conjpe.add(btnNewButton);
			
			idtext = new JTextField();
			idtext.setEditable(false);
			idtext.setBounds(156, 216, 86, 24);
			conjpe.add(idtext);
			idtext.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("\u59D3\u540D");
			btnNewButton_1.setBounds(371, 215, 86, 27);
			conjpe.add(btnNewButton_1);
			
			nametext = new JTextField();
			nametext.setBounds(471, 216, 86, 24);
			conjpe.add(nametext);
			nametext.setColumns(10);
			
			JButton btnNewButton_2 = new JButton("\u7535\u8BDD");
			btnNewButton_2.setBounds(55, 272, 86, 27);
			conjpe.add(btnNewButton_2);
			
			teltext = new JTextField();
			teltext.setBounds(155, 273, 128, 24);
			conjpe.add(teltext);
			teltext.setColumns(10);
			
			passwordtext = new JTextField();
			passwordtext.setBounds(471, 273, 128, 24);
			conjpe.add(passwordtext);
			passwordtext.setColumns(10);
			
			JButton button = new JButton("\u5BC6\u7801");
			button.setBounds(371, 272, 86, 27);
			conjpe.add(button);
			
			JButton updatebutton = new JButton("\u4FEE\u6539");
			updatebutton.setIcon(new ImageIcon("edit.png"));
			updatebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id=idtext.getText();
					String name=nametext.getText();
					String telphone=teltext.getText();
					String password=passwordtext.getText();
					if(StringUtil.isEmpty(id)) {
						JOptionPane.showMessageDialog(null,"请选择你的记录");
						return;
					}
					SQLAdmin sqlAdmin=new SQLAdmin(id,name,telphone,password);
					Connection con=null;
					try {
						con=jdbcBean.getConnection();
						int Num=admDao.AdmUpdate(con, sqlAdmin);
						if(Num==1) {
							JOptionPane.showMessageDialog(null,"修改成功！");
							resetValue();
						}
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}finally {
						try {
							jdbcBean.Closect(con);
						}catch(Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			});
			updatebutton.setBounds(55, 324, 96, 27);
			conjpe.add(updatebutton);
			
			JButton button_1 = new JButton("\u53D6\u6D88");
			button_1.setIcon(new ImageIcon("reset.png"));
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					resetValue();
				}
			});
			button_1.setBounds(371, 324, 96, 27);
			conjpe.add(button_1);
			this.a_id =id;
			this.fillTableAdmain();
	}
	
	public void fillTableAdmain() {
		DefaultTableModel dtm2=(DefaultTableModel)tableAdmin.getModel();
		dtm2.setRowCount(0);
		Connection conn=null;
		try {
			conn=jdbcBean.getConnection();
			ResultSet rs=admDao.AdminList(conn,a_id);
			while(rs.next()) {
				Vector<Object> v=new Vector<Object>();
				v.add(rs.getObject("A_id"));//括号里的东西必须为数据库表格中所对应的属性
				v.add(rs.getObject("A_name"));
				v.add(rs.getObject("A_tel"));
				v.add(rs.getObject("A_password"));
				dtm2.addRow(v);//塞入每一行记录
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbcBean.Closect(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void resetValue() {
		idtext.setText("");
		nametext.setText("");
		teltext.setText("");
		passwordtext.setText("");
	}
}