package com.system.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Window.Type;
import javax.swing.border.EtchedBorder;

public class SellerFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerFrm frame = new SellerFrm();
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
	public SellerFrm() {
		setType(Type.POPUP);
		setTitle("\u5356\u623F\u8005\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u53D1\u5E03\u623F\u6E90\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HouseinfoInterFrm houseinfoInterFrm=new HouseinfoInterFrm();
				houseinfoInterFrm.setVisible(true);
				desktopPane.add(houseinfoInterFrm);
			}
		});
		button.setBounds(0, 0, 141, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u623F\u6E90\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchInterFrm searchInterFrm=new SearchInterFrm();
				searchInterFrm.setVisible(true);
				desktopPane.add(searchInterFrm);
			}
		});
		btnNewButton.setBounds(0, 23, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u5356\u5BB6\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchSellerInterFrm searchSellerInterFrm=new SearchSellerInterFrm();
				searchSellerInterFrm.setVisible(true);
				desktopPane.add(searchSellerInterFrm);
			}
		});
		button_1.setBounds(0, 47, 141, 23);
		contentPane.add(button_1);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u5356\u5BB6\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterInterFrm alterInterFrm=new AlterInterFrm();
				alterInterFrm.setVisible(true);
				desktopPane.add(alterInterFrm);
			}
		});
		btnNewButton_1.setBounds(0, 69, 141, 23);
		contentPane.add(btnNewButton_1);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(141, 0, 1500, 900);
		contentPane.add(desktopPane);
	}
}
