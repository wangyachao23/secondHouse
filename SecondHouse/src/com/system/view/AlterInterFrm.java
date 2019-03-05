package com.system.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.system.dao.SellerDao;
import com.system.model.Seller;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlterInterFrm extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	SellerDao sellerDao=new SellerDao();
	SellerDao sellerDaoo=new SellerDao();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterInterFrm frame = new AlterInterFrm();
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
	public AlterInterFrm() {
		setClosable(true);
		setTitle("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		setBounds(100, 100, 528, 544);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u53F7\uFF1A");
		lblNewLabel.setBounds(51, 34, 54, 15);
		getContentPane().add(lblNewLabel);
//		重写一个点进去查询所有的函数
		
		textField = new JTextField();
		textField.setBounds(146, 31, 117, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");//"查询"按钮的action
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s_no=textField.getText();
				Seller seller=new Seller();
				seller.setS_no(s_no);
				fillTable(seller);  //空查询所有，否则查询指定卖家注册号的信息
			}
		});
		button.setBounds(319, 30, 93, 23);
		getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 96, 439, 163);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//获取选中的行
				int row=table.getSelectedRow();
				textField_1.setText((String)table.getValueAt(row, 0));
				textField_3.setText((String)table.getValueAt(row, 1));
				textField_2.setText((String)table.getValueAt(row, 2));
				textField_4.setText((String)table.getValueAt(row, 3));
				textField_5.setText((String)table.getValueAt(row, 4));
				textField_6.setText((String)table.getValueAt(row, 5));
				textField_7.setText((String)table.getValueAt(row, 6));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6CE8\u518C\u53F7", "ID", "\u59D3\u540D", "\u5BC6\u7801", "Email", "\u5730\u5740", "\u7535\u8BDD"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4E2A\u4EBA\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(51, 284, 439, 205);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u6CE8\u518C\u53F7\uFF1A");
		lblNewLabel_1.setBounds(26, 32, 54, 15);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(90, 29, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(257, 32, 54, 15);
		panel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(321, 29, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblId = new JLabel("ID\uFF1A");
		lblId.setBounds(26, 63, 54, 15);
		panel.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 60, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(257, 63, 54, 15);
		panel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(321, 60, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email\uFF1A");
		lblEmail.setBounds(26, 93, 54, 15);
		panel.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setBounds(90, 91, 66, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5730\u5740\uFF1A");
		label_1.setBounds(26, 129, 54, 15);
		panel.add(label_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(90, 126, 66, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD\uFF1A");
		label_2.setBounds(26, 163, 54, 15);
		panel.add(label_2);
		
		textField_7 = new JTextField();
		textField_7.setBounds(90, 160, 66, 21);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton jb_motify = new JButton("\u4FEE\u6539");
		jb_motify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s_no=textField_1.getText();
				String s_id=textField_3.getText();
				String s_name=textField_2.getText();
				String s_password=textField_4.getText();
				String s_email=textField_5.getText();
				String s_add=textField_6.getText();
				String s_tel=textField_7.getText();
				
				if(StringUtil.isEmpty(s_no)) {
					JOptionPane.showMessageDialog(null, "请选择自己的记录！");
					return;
				}
				Seller seller=new Seller(s_no,s_id,s_name,s_password,s_email,s_add,s_tel);
					Connection con=null;
					try {
						con=dbUtil.getCon();
						int Num=sellerDaoo.sellerModify(con, seller);
						if(Num==1) {
							JOptionPane.showMessageDialog(null, "修改成功！");
							resetValue();
							//fillTable(new Seller());
						}else {
							JOptionPane.showMessageDialog(null, "修改失败！");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
				}
			
		});
		jb_motify.setBounds(294, 110, 93, 23);
		panel.add(jb_motify);
		
		JButton jb_delete = new JButton("\u5220\u9664");
		jb_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s_no=textField_1.getText();
				if(StringUtil.isEmpty(s_no)) {
					JOptionPane.showMessageDialog(null, "请选择自己的记录！");
					return;
				}
				int n=JOptionPane.showConfirmDialog(null, "确定要删除吗？");
				if(n==0) {
					Connection con=null;
					try {
						con=dbUtil.getCon();
						int deleteNum=sellerDao.sellerDelete(con, s_no);
						if(deleteNum==1) {
							JOptionPane.showMessageDialog(null, "删除成功！");
							resetValue();
							//fillTable(new Seller());
						}else {
							JOptionPane.showMessageDialog(null, "删除失败！");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}
			}
		});
		jb_delete.setBounds(294, 159, 93, 23);
		panel.add(jb_delete);

	}
	public void resetValue() {
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
	
	}
	public void fillTable(Seller seller) {
	DefaultTableModel dtm=(DefaultTableModel) table.getModel();
	dtm.setRowCount(0);
	Connection con=null;
	try {
		con=dbUtil.getCon();
		ResultSet rs=sellerDao.sellerList(con,seller);
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("S_no"));
			v.add(rs.getString("S_id"));
			v.add(rs.getString("S_name"));
			v.add(rs.getString("S_password"));
			v.add(rs.getString("S_email"));
			v.add(rs.getString("S_add"));
			v.add(rs.getString("S_tel"));
			dtm.addRow(v);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}finally {
		try {
			dbUtil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	}


