package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.User;
import org.eclipse.ui.internal.dnd.TestDropLocation;

import model.Buyer;
import model.select;
import util.HouseInfo;
import util.dao;
import util.getinfo;
import util.modrfy_buyerinfo;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.JLayeredPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
public class BuyerMain extends JFrame{
	public static Object string;
	public static Object string1;
	JLabel jb0,jb1,jb2,jb3;
	HouseInfo houseInfo=new HouseInfo();
	getinfo getinfo=new getinfo();
	dao dao=new dao();
	private String usename;
	Connection con= houseInfo.getConnection();
	BuyerOwnInfo buyerOwnInfo=new BuyerOwnInfo(usename);

	//private Image image;
	public BuyerMain(String usename) {
		this.usename=usename;
		/*int weight=738;
		int height=523;*/
		//加载图片
		/*ImageIcon icon=new ImageIcon("C:\\\\Users\\\\Administrator\\\\Pictures\\\\beijing.JPG");
		//Image im=new Image(icon);
		//将图片放入label中
		JLabel la=new JLabel(icon);
		
		//设置label的大小
		la.setBounds(100,100,icon.getIconWidth(),icon.getIconHeight());
		
		//JFrame frame1=new JFrame();
		//goumai1 frame = new goumai1();
		//frame1.setVisible(true);
		//frame1.setTitle("\u8D2D\u623F\u8005\u4E3B\u754C\u9762");
		
		//获取窗口的第二层，将label放入
		getLayeredPane().add(la,new Integer(Integer.MIN_VALUE));
			
		//获取frame的顶层容器,并设置为透明
		JPanel j=(JPanel)this.getContentPane();
		j.setOpaque(false);*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 523);
		this.setLocationRelativeTo(null);
		   JTabbedPane  jp=new JTabbedPane(JTabbedPane.LEFT) ; 
		   //jp.setOpaque(false);
		   jp.setPreferredSize(new Dimension(200,400));
    	this.setVisible(true);
//设置选项卡在坐标 
		    JPanel p2=new JPanel() ;
		    p2.setOpaque(false);
		    p2 .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    p2.addAncestorListener(new AncestorListener() {
		    	public void ancestorAdded(AncestorEvent event) {
		    		new BuyerOwnInfo(usename).setVisible(true); 		
		    	}
		    	public void ancestorMoved(AncestorEvent event) {
		    	}
		    	public void ancestorRemoved(AncestorEvent event) {
		    	}
		    });
		 
		    ;
		    JPanel p3=new JPanel() ;
		    p3.setOpaque(false);
		    p3.addAncestorListener(new AncestorListener() {
		    	public void ancestorAdded(AncestorEvent event) {
		    		new modrfy_buyerinfo(usename).setVisible(true);
		    	}
		    	public void ancestorMoved(AncestorEvent event) {
		    	}
		    	public void ancestorRemoved(AncestorEvent event) {
		    	}
		    });

		    JPanel p4=new JPanel() ;      //创建多个容器
		    p4.addAncestorListener(new AncestorListener() {
		    	public void ancestorAdded(AncestorEvent event) {
		    		new seecontract(usename).setVisible(true);
		    	}
		    	public void ancestorMoved(AncestorEvent event) {
		    	}
		    	public void ancestorRemoved(AncestorEvent event) {
		    	}
		    });
		    p4.setOpaque(false);

		    JPanel p5=new JPanel() ; 
		    p5.setOpaque(false);
		    p5.addAncestorListener(new AncestorListener() {
		    	public void ancestorAdded(AncestorEvent event) {
		    		new feedback(usename).setVisible(true);
		    	}
		    	public void ancestorMoved(AncestorEvent event) {
		    	}
		    	public void ancestorRemoved(AncestorEvent event) {
		    	}
		    });
		    /**
		     * 对查询房源页面操作
		     */
		    final String def[] =
		        { "50-150平", "150-200平", "200平以上"};  
		        final String def1[] =
			        { "朝阳", "朝阴"}; 
		        final String def2[] =
			        { "一室", "两室", "三室","四室","五室"};
		        final String def3[] =
			        { "1-3层", "3-7层", "7层以上"};
		        final String def4[] =
			        { "100万以下", "100万-200万", "200万以上"};
		        final String def5[] =
			        { "中", "良", "优"};
					    JPanel p6 = new JPanel();
					    p6.addAncestorListener(new AncestorListener() {
					    	public void ancestorAdded(AncestorEvent event) {
					    		int result=JOptionPane.showConfirmDialog(null, "确定退出系统？");
						   		if (result==JOptionPane.YES_OPTION) {
						   			System.exit(0);}
					    	}
					    	public void ancestorMoved(AncestorEvent event) {
					    	}
					    	public void ancestorRemoved(AncestorEvent event) {
					    	}
					    });
			
					   JPanel p1=new JPanel() ;
					   jp.addTab("  \u67E5\u8BE2\u623F\u6E90\u4FE1\u606F", new ImageIcon("C:\\Users\\Administrator\\Pictures\\chaxunfangzi.png"), p1, null);
					   p1.setBackground(SystemColor.controlHighlight);
					   p1.setForeground(Color.WHITE);
					   p1.addMouseListener(new MouseAdapter() {
					   	@Override
					   	public void mouseClicked(MouseEvent e) {
					   		
					   	}
					   });
					   //  goumai1 table = new goumai1();
					    JButton button_1 = new JButton("");
					    button_1.setOpaque(false);
					    button_1.setIcon(new ImageIcon("sousuo.png"));
					    button_1.addActionListener(new ActionListener() {
					    	public void actionPerformed(ActionEvent e) {
					    	new select(usename).setVisible(true);
					    	}
					    });
					    
					    JLabel label = new JLabel("面积");
					    label.setOpaque(false);
					    button_1.setBackground(Color.WHITE);
					    JComboBox comboBox = new JComboBox(def);
					    comboBox.setOpaque(false);
					    comboBox.addItemListener(new ItemListener() {
					    	public void itemStateChanged(ItemEvent e) {
					    	}
					    });
					    
					    JLabel label_1 = new JLabel("朝向");
					    label_1.setOpaque(false);
					    JComboBox comboBox_1 = new JComboBox(def1);
					    comboBox_1.setOpaque(false);
					    comboBox_1.addItemListener(new ItemListener() {
					    	public void itemStateChanged(ItemEvent e) {
					    	}
					    });
					    
					    JLabel label_2 = new JLabel("户型");
					    label_2.setOpaque(false);
					    JComboBox comboBox_2 = new JComboBox(def2);
					    comboBox_2.setOpaque(false);
					    comboBox_2.addItemListener(new ItemListener() {
					    	public void itemStateChanged(ItemEvent e) {
					    	}
					    });
					    
					    JLabel label_3 = new JLabel("楼层");
					    label_3.setOpaque(false);
					    JComboBox comboBox_3 = new JComboBox(def3);
					    comboBox_3.setOpaque(false);
					    comboBox_3.addItemListener(new ItemListener() {
					    	public void itemStateChanged(ItemEvent e) {
					    	}			    	
					    });
					    JLayeredPane layeredPane = new JLayeredPane();
					    
					    JLabel label_4 = new JLabel("价格");
					    label_4.setOpaque(false);;					    
					    JComboBox comboBox_4 = new JComboBox(def4);
					    comboBox_4.setOpaque(false);
					    JLabel label_5 = new JLabel("装修");
					    label_5.setOpaque(false);
					    JComboBox comboBox_5 = new JComboBox(def5);
					    comboBox_5.setOpaque(false);
					    JButton button = new JButton("筛选查询");
					    button.setOpaque(false);
					    button.addActionListener(new ActionListener() {
					    	public void actionPerformed(ActionEvent e) {
					    		Object string=comboBox.getSelectedItem();
					    		Object string1=comboBox_1.getSelectedItem();
					    		Object string2=comboBox_2.getSelectedItem();
					    		Object string3=comboBox_3.getSelectedItem();
					    		Object string4=comboBox_4.getSelectedItem();
					    		Object string5=comboBox_5.getSelectedItem();
					    		//System.out.println(string+""+string1+""+string2+""+string3+""+string4+""+string5);
					    		new con_query(string,string1,string2,string3,string4,string5).setVisible(true);
					    	}
					    });
					    
					    GroupLayout gl_p1 = new GroupLayout(p1);
					    gl_p1.setHorizontalGroup(
					    	gl_p1.createParallelGroup(Alignment.LEADING)
					    		.addGroup(gl_p1.createSequentialGroup()
					    			.addContainerGap(88, Short.MAX_VALUE)
					    			.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
					    				.addComponent(label_1)
					    				.addComponent(label)
					    				.addComponent(label_4))
					    			.addPreferredGap(ComponentPlacement.UNRELATED)
					    			.addGroup(gl_p1.createParallelGroup(Alignment.LEADING, false)
					    				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					    				.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    				.addComponent(comboBox_4, 0, 0, Short.MAX_VALUE))
					    			.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					    			.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
					    				.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					    				.addGroup(gl_p1.createSequentialGroup()
					    					.addGap(10)
					    					.addGroup(gl_p1.createParallelGroup(Alignment.LEADING, false)
					    						.addGroup(gl_p1.createSequentialGroup()
					    							.addComponent(label_5)
					    							.addPreferredGap(ComponentPlacement.RELATED)
					    							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					    						.addGroup(gl_p1.createSequentialGroup()
					    							.addComponent(label_2)
					    							.addPreferredGap(ComponentPlacement.RELATED)
					    							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					    						.addGroup(gl_p1.createSequentialGroup()
					    							.addComponent(label_3)
					    							.addPreferredGap(ComponentPlacement.RELATED)
					    							.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					    			.addContainerGap(102, Short.MAX_VALUE))
					    		.addGroup(gl_p1.createSequentialGroup()
					    			.addGap(209)
					    			.addComponent(button, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					    			.addContainerGap(222, Short.MAX_VALUE))
					    		.addGroup(gl_p1.createSequentialGroup()
					    			.addGap(37)
					    			.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					    			.addContainerGap(295, Short.MAX_VALUE))
					    );
					    gl_p1.setVerticalGroup(
					    	gl_p1.createParallelGroup(Alignment.LEADING)
					    		.addGroup(gl_p1.createSequentialGroup()
					    			.addContainerGap()
					    			.addComponent(button_1)
					    			.addGap(69)
					    			.addGroup(gl_p1.createParallelGroup(Alignment.BASELINE)
					    				.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					    				.addComponent(label_2)
					    				.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					    			.addGap(27)
					    			.addGroup(gl_p1.createParallelGroup(Alignment.BASELINE)
					    				.addComponent(label_1)
					    				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					    				.addComponent(label_3)
					    				.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					    			.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
					    				.addGroup(gl_p1.createSequentialGroup()
					    					.addGap(18)
					    					.addGroup(gl_p1.createParallelGroup(Alignment.BASELINE)
					    						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					    						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					    						.addComponent(label_5)
					    						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					    				.addGroup(gl_p1.createSequentialGroup()
					    					.addPreferredGap(ComponentPlacement.RELATED)
					    					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					    			.addGap(52)
					    			.addComponent(button, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					    			.addContainerGap(126, Short.MAX_VALUE))
					    );
					    p1.setLayout(gl_p1);
			jp.add("查看个人信息", p2)  ;
				buyerOwnInfo.fillTable();
			jp.setIconAt(1, new ImageIcon("chaxun.png"));
		    jp.add("修改个人信息", p3)  ;
		    jp.setIconAt(2, new ImageIcon("20190113235608.png"));
		    JPanel p7=new JPanel() ; 
		    p7.addAncestorListener(new AncestorListener() {
		    	public void ancestorAdded(AncestorEvent event) {
		    		new seeorder(usename).setVisible(true);
		    	}
		    	public void ancestorMoved(AncestorEvent event) {
		    	}
		    	public void ancestorRemoved(AncestorEvent event) {
		    	}
		    });
		    jp.add("查看订单信息", p7);
		    jp.setIconAt(3, new ImageIcon("chaxundingdan.png"));
		    jp.add("查看交易进度", p4)  ;
		    jp.setIconAt(4, new ImageIcon("chaxunjindu.png"));
		    jp.add("反馈信息", p5);
		    jp.setIconAt(5, new ImageIcon("fankui.png"));
		    jp.add("退出系统", p6);
		    jp.setIconAt(6, new ImageIcon("tuichu.png"));
		    GroupLayout groupLayout = new GroupLayout(getContentPane());
		    groupLayout.setHorizontalGroup(
		    	groupLayout.createParallelGroup(Alignment.LEADING)
		    		.addComponent(jp, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
		    );
		    groupLayout.setVerticalGroup(
		    	groupLayout.createParallelGroup(Alignment.LEADING)
		    		.addComponent(jp, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
		    );
		  // frame.getContentPane().add(jp);
		   //this .add(p1);
			//f.add(p1);
			/*frame.setSize(icon.getIconWidth(),icon.getIconHeight());
			frame.setVisible(true);*/
		    jp.setOpaque(false);
		    getContentPane().add(jp);
}
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					BuyerMain frame = new BuyerMain(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}