package com.system.view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.system.dao.HouseinfoDao;
import com.system.model.Houseinfo;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

public class HouseinfoInterFrm extends JInternalFrame {
	private JTextField H_noTxt;
	private JTextField H_nameTxt;
	private JTextField S_noTxt;
	private JTextField reg_adTxt;
	private JTextField Item_copTxt;
	private JTextField dirTxt;
	private JTextField Stru_naTxt;
	private JTextField areaTxt;
	private JTextField floorTxt;
	private JTextField unit_noTxt;
	private JTextField carareaTxt;
	private JTextField fitmentTxt;
	private JTextField serverfeeTxt;
	private JTextField statusTxt;
	private JTextField moneyTxt;
	DbUtil dbUtil=new DbUtil();
	HouseinfoDao houseinfoDao=new HouseinfoDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseinfoInterFrm frame = new HouseinfoInterFrm();
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
	public HouseinfoInterFrm() {
	setTitle("\u53D1\u5E03\u623F\u6E90\u4FE1\u606F");
		
		setNormalBounds(new Rectangle(0, 0, 80, 120));
		setClosable(true);
		setBounds(100, 100, 290, 438);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u623F\u6E90\u7F16\u53F7");
		lblNewLabel.setBounds(38, 10, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u6E90\u540D\u79F0");
		lblNewLabel_1.setBounds(38, 60, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u6240\u5C5E\u5730\u5740");
		label.setBounds(38, 85, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5EFA\u7B51\u5355\u4F4D");
		label_1.setBounds(38, 110, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u671D\u5411");
		label_2.setBounds(38, 135, 54, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u6237\u578B");
		label_3.setBounds(38, 158, 54, 15);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u9762\u79EF");
		label_4.setBounds(38, 183, 54, 15);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u697C\u5C42");
		label_5.setBounds(38, 208, 54, 15);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u5355\u5143\u53F7");
		label_6.setBounds(38, 233, 54, 15);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u8F66\u5E93\u9762\u79EF");
		label_7.setBounds(38, 258, 54, 15);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u88C5\u4FEE\u72B6\u51B5");
		label_8.setBounds(38, 283, 54, 15);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u7269\u4E1A\u7BA1\u7406\u8D39");
		label_9.setBounds(38, 312, 65, 15);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u623F\u6E90\u72B6\u6001");
		label_10.setBounds(38, 348, 54, 15);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\u623F\u5C4B\u552E\u4EF7");
		label_11.setBounds(38, 380, 54, 15);
		getContentPane().add(label_11);
		
		H_noTxt = new JTextField();
		H_noTxt.setBounds(130, 7, 66, 21);
		getContentPane().add(H_noTxt);
		H_noTxt.setColumns(10);
		
		
		S_noTxt = new JTextField();
		S_noTxt.setBounds(130, 32, 66, 21);
		getContentPane().add(S_noTxt);
		S_noTxt.setColumns(10);
		
		H_nameTxt = new JTextField();
		H_nameTxt.setBounds(130, 57, 66, 21);
		getContentPane().add(H_nameTxt);
		H_nameTxt.setColumns(10);
		
		reg_adTxt = new JTextField();
		reg_adTxt.setBounds(130, 82, 66, 21);
		getContentPane().add(reg_adTxt);
		reg_adTxt.setColumns(10);
		
		Item_copTxt = new JTextField();
		Item_copTxt.setBounds(130, 107, 66, 21);
		getContentPane().add(Item_copTxt);
		Item_copTxt.setColumns(10);
		
		dirTxt = new JTextField();
		dirTxt.setBounds(130, 132, 66, 21);
		getContentPane().add(dirTxt);
		dirTxt.setColumns(10);
		
		Stru_naTxt = new JTextField();
		Stru_naTxt.setBounds(130, 155, 66, 21);
		getContentPane().add(Stru_naTxt);
		Stru_naTxt.setColumns(10);
		
		areaTxt = new JTextField();
		areaTxt.setBounds(130, 180, 66, 21);
		getContentPane().add(areaTxt);
		areaTxt.setColumns(10);
		
		floorTxt = new JTextField();
		floorTxt.setBounds(130, 205, 66, 21);
		getContentPane().add(floorTxt);
		floorTxt.setColumns(10);
		
		unit_noTxt = new JTextField();
		unit_noTxt.setBounds(130, 230, 66, 21);
		getContentPane().add(unit_noTxt);
		unit_noTxt.setColumns(10);
		
		carareaTxt = new JTextField();
		carareaTxt.setBounds(130, 255, 66, 21);
		getContentPane().add(carareaTxt);
		carareaTxt.setColumns(10);
		
		fitmentTxt = new JTextField();
		fitmentTxt.setBounds(130, 280, 66, 21);
		getContentPane().add(fitmentTxt);
		fitmentTxt.setColumns(10);
		
		serverfeeTxt = new JTextField();
		serverfeeTxt.setBounds(130, 309, 66, 21);
		getContentPane().add(serverfeeTxt);
		serverfeeTxt.setColumns(10);
		
		statusTxt = new JTextField();
		statusTxt.setBounds(130, 345, 66, 21);
		getContentPane().add(statusTxt);
		statusTxt.setColumns(10);
		
		moneyTxt = new JTextField();
		moneyTxt.setBounds(130, 377, 66, 21);
		getContentPane().add(moneyTxt);
		moneyTxt.setColumns(10);
		
	
		
		JButton jb_Add = new JButton("\u53D1\u5E03");
		jb_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String H_no=H_noTxt.getText();
				String S_no=S_noTxt.getText();
				String H_name=H_nameTxt.getText();
				String reg_ad=reg_adTxt.getText();
				String Item_cop=Item_copTxt.getText();
				String dir=dirTxt.getText();
				String Stru_na=Stru_naTxt.getText();
				String area=areaTxt.getText();
				String floor=floorTxt.getText();
				String unit_no=unit_noTxt.getText();
				String cararea=carareaTxt.getText();
				String fitment=fitmentTxt.getText();
				String serverfee=serverfeeTxt.getText();
				String status=statusTxt.getText();
				String money=moneyTxt.getText();
				if(StringUtil.isEmpty(H_no)) {
					JOptionPane.showMessageDialog(null, "房源编号不能为空");
					return;
				}
				if(StringUtil.isEmpty(S_no)) {
					JOptionPane.showMessageDialog(null, "卖家注册号不能为空");
					return;
				}
				if(StringUtil.isEmpty(H_name)) {
					JOptionPane.showMessageDialog(null, "房源名称不能为空");
					return;
				}
				if(StringUtil.isEmpty(reg_ad)) {
					JOptionPane.showMessageDialog(null, "房源所属地址不能为空");
					return;
				}
				if(StringUtil.isEmpty(H_no)) {
					JOptionPane.showMessageDialog(null, "建筑单位不能为空");
					return;
				}
			
				if(StringUtil.isEmpty(status)) {
					JOptionPane.showMessageDialog(null, "房源状态不能为空");
					return;
				}
				if(StringUtil.isEmpty(H_name)) {
					JOptionPane.showMessageDialog(null, "房屋售价不能为空");
					return;
				}
				Houseinfo houseinfo=new Houseinfo(H_no,S_no, H_name, reg_ad,Item_cop, dir,Stru_na,area, floor,unit_no,cararea, fitment,serverfee, status,money); 
				
				try {
					int n=houseinfoDao.houseinfoAdd(dbUtil.getCon(), houseinfo);
					if(n==1) {
						JOptionPane.showMessageDialog(null, "房源添加成功");
						H_noTxt.setText("");
						S_noTxt.setText("");
						H_nameTxt.setText("");
						reg_adTxt.setText("");
						Item_copTxt.setText("");
						dirTxt.setText("");
						Stru_naTxt.setText("");
						areaTxt.setText("");
						floorTxt.setText("");
						unit_noTxt.setText("");
						carareaTxt.setText("");
						fitmentTxt.setText("");
						serverfeeTxt.setText("");
						statusTxt.setText("");
						moneyTxt.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "房源添加失败");
					}
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "房源添加失败");
					e1.printStackTrace();
				}
			}
		});
		jb_Add.setBounds(201, 106, 63, 23);
		getContentPane().add(jb_Add);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				H_noTxt.setText("");
				S_noTxt.setText("");
				H_nameTxt.setText("");
				reg_adTxt.setText("");
				Item_copTxt.setText("");
				dirTxt.setText("");
				Stru_naTxt.setText("");
				areaTxt.setText("");
				floorTxt.setText("");
				unit_noTxt.setText("");
				carareaTxt.setText("");
				fitmentTxt.setText("");
				serverfeeTxt.setText("");
				statusTxt.setText("");
				moneyTxt.setText("");
			
			}
		});
		btnNewButton.setBounds(201, 254, 63, 23);
		getContentPane().add(btnNewButton);
		
		JLabel label_12 = new JLabel("\u5356\u5BB6\u6CE8\u518C\u53F7");
		label_12.setBounds(38, 35, 78, 15);
		getContentPane().add(label_12);

	}

}
