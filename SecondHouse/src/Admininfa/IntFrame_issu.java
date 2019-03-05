package Admininfa;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import AdminDao.NoticeDao;
import AdminsqlMod.SQLNotice;
import JDBC.StringUtil;
import JDBC.jdbc;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class IntFrame_issu extends JInternalFrame {
	private JTextField addAnnotreamtext;
	private JTextField Annotimetext;
	private JTextField Annoidtext;
	private JTextField Annonotext;

	
	jdbc jdbcutil=new jdbc();
	NoticeDao sqlAnnodao=new NoticeDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFrame_issu frame = new IntFrame_issu();
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
	public IntFrame_issu() {
		setIconifiable(true);//缩小按钮
		setClosable(true);//关闭按钮
		setTitle("Announcement");
		setBounds(0,0, 744, 369);
		getContentPane().setLayout(null);
		
		JLabel addAnnotream = new JLabel("\u516C\u544A\u4E3B\u9898");
		addAnnotream.setBounds(92, 26, 72, 18);
		getContentPane().add(addAnnotream);
		
		addAnnotreamtext = new JTextField();
		addAnnotreamtext.setBounds(161, 23, 102, 24);
		getContentPane().add(addAnnotreamtext);
		addAnnotreamtext.setColumns(10);
		
		JLabel Annotime = new JLabel("\u53D1\u5E03\u65F6\u95F4");
		Annotime.setBounds(333, 26, 72, 18);
		getContentPane().add(Annotime);
		
		Annotimetext = new JTextField();
		Annotimetext.setBounds(400, 23, 113, 24);
		getContentPane().add(Annotimetext);
		Annotimetext.setColumns(10);
		
		JLabel Annoid = new JLabel("\u7BA1\u7406\u5458ID");
		Annoid.setBounds(92, 69, 72, 18);
		getContentPane().add(Annoid);
		
		Annoidtext = new JTextField();
		Annoidtext.setBounds(161, 66, 102, 24);
		getContentPane().add(Annoidtext);
		Annoidtext.setColumns(10);
		
		JLabel Annono = new JLabel("\u516C\u544A\u7F16\u53F7");
		Annono.setBounds(330, 69, 86, 18);
		getContentPane().add(Annono);
		
		Annonotext = new JTextField();
		Annonotext.setBounds(400, 66, 113, 24);
		getContentPane().add(Annonotext);
		Annonotext.setColumns(10);
		
		JLabel Annocont = new JLabel("\u516C\u544A\u5185\u5BB9");
		Annocont.setBounds(92, 103, 72, 18);
		getContentPane().add(Annocont);
		
		JTextArea Annoconttext = new JTextArea();
		Annoconttext.setBounds(161, 117, 362, 136);
		getContentPane().add(Annoconttext);
		
		//发布公告
		JButton AnnoButton = new JButton("\u53D1\u5E03");		
		AnnoButton.setIcon(new ImageIcon("add.png"));
		AnnoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				//获取文本值传入数据库
				String N_no=Annonotext.getText();
				String subject=addAnnotreamtext.getText();
				String time=Annotimetext.getText();
				String A_id=Annoidtext.getText();			
				String content=Annoconttext.getText();
				if(StringUtil.isEmpty(A_id)) {
					JOptionPane.showMessageDialog(null,"管理员ID不能为空");
					return;
				}
				SQLNotice sqlNotice =new SQLNotice(N_no,subject,time,content,A_id); 
				Connection con=null;
				try {
					con=jdbcutil.getConnection();
				int addAnno=sqlAnnodao.Noticeadd(con, sqlNotice);
				if(addAnno==1) {
					JOptionPane.showMessageDialog(null,"公告发布成功");
				}else {
					JOptionPane.showMessageDialog(null,"公告发布失败");
				}
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					try {
						jdbcutil.Closect(con);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		AnnoButton.setBounds(171, 277, 113, 27);
		getContentPane().add(AnnoButton);
		
		//取消发布且置空
		JButton Annobuttonoff = new JButton("\u53D6\u6D88");
		Annobuttonoff.setIcon(new ImageIcon("reset.png"));
		Annobuttonoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAnnotreamtext.setText("");
				Annotimetext.setText("");
				Annoidtext.setText("");
				Annonotext.setText("");
				Annoconttext.setText("");
				
			}
		});
		Annobuttonoff.setBounds(410, 277, 113, 27);
		getContentPane().add(Annobuttonoff);
		
		
	}
}
