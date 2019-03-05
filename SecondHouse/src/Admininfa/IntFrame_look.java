package Admininfa;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import AdminDao.NoticeDao;
import AdminsqlMod.SQLNotice;
import JDBC.StringUtil;
import JDBC.jdbc;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class IntFrame_look extends JInternalFrame {
	private JPanel contentPane;
	private JTable tableinfo;
	jdbc jabcUtil=new jdbc();
	NoticeDao noticeDao=new NoticeDao();
	private JTextField Noticetext;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public IntFrame_look() {
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0,744,369);
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		JButton button = new JButton("全部公告信息");
		menuBar.add(button);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 5, 718, 240);
		contentPane.add(scrollPane);
		tableinfo = new JTable();
		tableinfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int roe=tableinfo.getSelectedRow();
				Noticetext.setText((String)tableinfo.getValueAt(roe, 0));
			}
		});
		tableinfo.setRowSelectionAllowed(false);
		tableinfo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u4E3B\u9898", "\u65F6\u95F4", "\u516C\u544A\u5185\u5BB9", "\u603B\u6570", "\u623F\u6E90\u603B\u6570", "\u7BA1\u7406\u5458ID"
			}
		));
		tableinfo.getColumnModel().getColumn(0).setPreferredWidth(44);
		tableinfo.getColumnModel().getColumn(1).setPreferredWidth(65);
		tableinfo.getColumnModel().getColumn(2).setPreferredWidth(63);
		tableinfo.getColumnModel().getColumn(3).setPreferredWidth(105);
		tableinfo.getColumnModel().getColumn(4).setPreferredWidth(53);
		tableinfo.getColumnModel().getColumn(5).setPreferredWidth(70);
		tableinfo.getColumnModel().getColumn(6).setPreferredWidth(73);
		scrollPane.setViewportView(tableinfo);
		
		JLabel label = new JLabel("\u6240\u9009\u884C\u7F16\u53F7");
		label.setBounds(374, 258, 86, 18);
		contentPane.add(label);
		
		Noticetext = new JTextField();
		Noticetext.setBounds(460, 255, 86, 24);
		contentPane.add(Noticetext);
		Noticetext.setColumns(10);
		
		JButton deleAbutton = new JButton("\u5220\u9664\u516C\u544A");
		deleAbutton.setIcon(new ImageIcon("delete.png"));
		deleAbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no=Noticetext.getText();
				if(StringUtil.isEmpty(no)) {
					JOptionPane.showMessageDialog(null,"请选择要删除的行");
					return;
				}
				Connection con=null;
				try {
					con=jabcUtil.getConnection();
					int num=noticeDao.NoticeDelete(con,no);
					if(num==1) {
						JOptionPane.showMessageDialog(null,"删除成功");
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						jabcUtil.Closect(con);
					}catch(Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		deleAbutton.setBounds(581, 254, 113, 27);
		contentPane.add(deleAbutton);
		this.fillTable(new SQLNotice());
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFrame_look frame = new IntFrame_look();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void fillTable(SQLNotice sqlNotice) {
		DefaultTableModel dtm=(DefaultTableModel)tableinfo.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=jabcUtil.getConnection();
			ResultSet rs=noticeDao.NoticeList(con);
			while(rs.next()) {
				Vector<Object> v=new Vector<Object>();
				v.add(rs.getString("A_no"));
				v.add(rs.getObject("subject"));
				v.add(rs.getObject("time"));
				v.add(rs.getObject("content"));
				v.add(rs.getObject("A_sum"));
				v.add(rs.getObject("H_sum"));
				v.add(rs.getObject("A_id"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try {
			jabcUtil.Closect(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
