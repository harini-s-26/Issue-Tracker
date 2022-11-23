package Issue_Tracker;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

//import health.doctor;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//import javax.swing.JComboBox;
//import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.DropMode;
import java.sql.*;


public class sql_datatable_guest {
	private static JTextField desc;
	private static JTextField asgn;
	private static JTextField seve;
	private static JTextField prio;
	private static JTextField id;
	private JScrollPane scrollPane;
	private JFrame frame;
	     
	public sql_datatable_guest() {
		initialize();
	}
	private void initialize() {
		JFrame frmWindow = new JFrame("WINDOW");
		frmWindow.getContentPane().setBackground(new Color(0,0,0)); 
		frmWindow.getContentPane().setForeground(Color.WHITE); 
		frmWindow.setBounds(100,100,988,692); 
		frmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWindow.getContentPane().setLayout(null);
		frmWindow.setLocationRelativeTo(null);
		
		desc = new JTextField();
		desc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		desc.setToolTipText("");
		desc.setBounds(330, 153, 551, 43);
		frmWindow.getContentPane().add(desc);
		desc.setColumns(10);
		
		asgn = new JTextField();
		asgn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		asgn.setBounds(330, 340, 551, 43);
		frmWindow.getContentPane().add(asgn);
		asgn.setColumns(10);
		
		seve = new JTextField();
		seve.setName("");
		seve.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seve.setBounds(332, 432, 549, 46);
		frmWindow.getContentPane().add(seve);
		seve.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(91, 166, 140, 36);
		frmWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Severity");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(102, 431, 165, 36);
		frmWindow.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Assigned To");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(102, 340, 149, 43);
		frmWindow.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Priority");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(77, 253, 128, 36);
		frmWindow.getContentPane().add(lblNewLabel_3);
		
		prio = new JTextField();
		prio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prio.setBounds(330, 255, 551, 43);
		frmWindow.getContentPane().add(prio);
		prio.setColumns(10);
		
		id = new JTextField();
		id.setBounds(330, 60, 551, 43);
		frmWindow.getContentPane().add(id);
		id.setColumns(10);
		
		Object[] columns = {"ID","Description", "Assignedto", "Priority","Severity"}; 
		Object[] row = new Object[5];
		DefaultTableModel model;
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		JButton addButtton = new JButton("ADD");
		addButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] =  id.getText(); 
				row[1] =  desc.getText();
				row[2] =  prio.getText();
				row[3] =  asgn.getText();
				row[4] =  seve.getText();
				model.addRow(row);
				
				try {
	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/issue","root","root123");

	                String query = "INSERT INTO issueadd values('" + row[0] + "','" + row[1] + "','" + row[2] + "','" +
	                		row[3] + "','" + row[4] + "')";
	                Statement sta = con.createStatement();
	                sta.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Issue Added....");

					}catch(Exception xx) {
						System.out.println(xx);
					}
			
			}
		});
		
		addButtton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		addButtton.setBounds(128, 551, 201, 46);
		frmWindow.getContentPane().add(addButtton);
		
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		deleteButton.setBounds(406, 551, 199, 46);
		frmWindow.getContentPane().add(deleteButton);
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                try {
	   
	                	row[0] =  id.getText(); 
	    				row[1] =  desc.getText();
	    				row[2] =  prio.getText();
	    				row[3] =  asgn.getText();
	    				row[4] =  seve.getText();
	                	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/issue","root","root123");
	                    String query ="update issueadd set ID='" + id.getText() + 
	                    		"',ID='" + id.getText()  + 
	                    		"',Descri='" + desc.getText() + 
	                    		"',Prio='" + prio.getText() + 
	                    		"',Asgn='" + asgn.getText() + 
	                    		"',Severity='" + seve.getText() + 
	                    		"' where ID = '" + id.getText() + "'";
	                    PreparedStatement pst = con.prepareStatement(query);
	                    pst.execute();
	                    JOptionPane.showMessageDialog(null,"Data updated!!!");
	                    pst.close();
	                }
	                catch(Exception ex)
	                {
	                	 JOptionPane.showMessageDialog(null,ex);
	                }
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		updateButton.setBounds(680, 551, 201, 46);
		frmWindow.getContentPane().add(updateButton);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_4.setBounds(77, 60, 70, 45);
		frmWindow.getContentPane().add(lblNewLabel_4);
		
	
	
		// DELETE BUTTON
		deleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
			Connection connection;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/issue","root","root123");
				String query = "delete from issueadd where id ='" + id.getText() + "'";
	            Statement sta = connection.createStatement();
	            PreparedStatement pst = connection.prepareStatement(query);
	            pst.execute();
				JOptionPane.showMessageDialog(frmWindow, "Issue Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
            
		
		}
		}
		);
	

		frmWindow.revalidate(); 
		frmWindow.setVisible(true);



	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sql_datatable_guest window = new sql_datatable_guest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void newScreen() {
		// TODO Auto-generated method stub
		
	}
}


	