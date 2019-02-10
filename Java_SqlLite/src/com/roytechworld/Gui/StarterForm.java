package com.roytechworld.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.roytechworld.test.SingeltonSqlLiteConnector;

import net.proteanit.sql.DbUtils;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class StarterForm extends JFrame {

	private JPanel contentPane;
	
	    Connection conn = null;
	    
	    PreparedStatement prSt = null;
		ResultSet rs = null;
		String query = "select * from studentmaster";
		private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterForm frame = new StarterForm();
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
	public StarterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel maincontainerpanel = new JPanel();
		contentPane.add(maincontainerpanel, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Load Data from Sql Lite DB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				conn=SingeltonSqlLiteConnector.GetInstance().getConnection();
	            prSt = conn.prepareStatement(query);
	            rs = prSt.executeQuery();
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	            
	            while(rs.next())
	            {
	            
	            System.out.println(rs.getString("name"));
	           
	            }
	            
				}
				catch(Exception f)
				{
					System.out.println("exceptin occor"+f);
				}
				
				
				
				
				
			}
		});
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(67);
		GroupLayout gl_maincontainerpanel = new GroupLayout(maincontainerpanel);
		gl_maincontainerpanel.setHorizontalGroup(
			gl_maincontainerpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_maincontainerpanel.createSequentialGroup()
					.addGroup(gl_maincontainerpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_maincontainerpanel.createSequentialGroup()
							.addGap(96)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_maincontainerpanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_maincontainerpanel.setVerticalGroup(
			gl_maincontainerpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_maincontainerpanel.createSequentialGroup()
					.addGap(28)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setBackground(Color.ORANGE);
		panel.add(table);
		maincontainerpanel.setLayout(gl_maincontainerpanel);
	}
}
