package Issue_Tracker;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;
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
public class DataTable_admin{
private static JTextField desc;
	private static JTextField asgn;
	private static JTextField seve;
	private static JTextField prio;
	private static JTextField id;
	private JScrollPane scrollPane;
	private JFrame frame;
	private JTextField txtEnter;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField;
public DataTable_admin() {
		initialize();
	}
	private void initialize() {
		JTable table = new JTable(); 
		Object[] columns = {"ID","Description", "Assigned to", "Priority","Severeity"}; 
		DefaultTableModel model = new DefaultTableModel();
		JFrame frmWindow = new JFrame("WINDOW");
		frmWindow.getContentPane().setBackground(new Color(0,0,0)); 
		frmWindow.getContentPane().setForeground(Color.WHITE); 
		frmWindow.setBounds(100,100,988,692); 
		frmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWindow.getContentPane().setLayout(null);
		frmWindow.setLocationRelativeTo(null);
		model.setColumnIdentifiers(columns);
	
		 table.setModel(model);
		table.setBackground(Color.white);
		table. setForeground(Color.black); 
		table.setSelectionBackground(Color.red); 
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.white); 
		table. setFont(new Font("Tahoma", Font.PLAIN, 27));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		JScrollPane pane = new JScrollPane(table);
		pane.setFont(new Font("Tahoma", Font.BOLD, 20));
		pane. setForeground(Color.RED);
		pane.setBackground(Color.WHITE); 
		pane.setBounds(10,10,954,342); 
		frmWindow.getContentPane().add(pane);
		
		txtEnter = new JTextField();
		txtEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnter.setToolTipText("");
		txtEnter.setBounds(411, 383, 201, 43);
		frmWindow.getContentPane().add(txtEnter);
		txtEnter.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(275, 466, 201, 43);
		frmWindow.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setName("");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(724, 465, 199, 46);
		frmWindow.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(236, 383, 165, 43);
		frmWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Severity");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(537, 462, 165, 36);
		frmWindow.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Assigned To");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(91, 461, 149, 43);
		frmWindow.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Priority");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(606, 383, 133, 43);
		frmWindow.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(747, 383, 199, 43);
		frmWindow.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		Object[] row = new Object[5];
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(176, 551, 201, 46);
		frmWindow.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {


		@Override
		public void actionPerformed(ActionEvent arg0) {
			row[0] = textField.getText(); 
			row[1] = txtEnter.getText(); 
			row[2] =  textField_2.getText();
			row[3] = textField_1.getText();
			row[4] = textField_3.getText();
			model.addRow(row);
		}
		});

		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setBounds(432, 551, 199, 46);
		frmWindow.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE ISSUE");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_2.setBounds(686, 551, 176, 46);
		frmWindow.getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(77, 383, 149, 43);
		frmWindow.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_4.setBounds(10, 383, 45, 43);
		frmWindow.getContentPane().add(lblNewLabel_4);
	
		// DELETE BUTTON
		btnNewButton_1.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent arg0) {
		int i = table.getSelectedRow(); 
		if(i>=0) {
		model.removeRow(i); 
		} 
		else
		{
		JOptionPane.showMessageDialog(frmWindow, "Select a row to delete an issue");
		}
		}
		}
		);
		/*ListSelectionModel model1=table.getSelectionModel(); 
		model1.addListSelectionListener(new ListSelectionListener() {
			@Override 
			public void valueChanged(ListSelectionEvent  e) {
			if(! model1.isSelectionEmpty())
			//GET SELECTED ROW 
			{
					int selectedRow=model1.getMinSelectionIndex(); 
			//JOptionPane.showMessageDialog(null, "Selected Row ");
			}
		}
	});*/
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent arg0) {
			int i = table.getSelectedRow(); 
			if(i>=0) {
				JOptionPane.showMessageDialog(null, "Issue Closed");
			} 
			else
			{
			JOptionPane.showMessageDialog(frmWindow, "Select a row to close the resolved issue");
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
					DataTable_admin window = new DataTable_admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

