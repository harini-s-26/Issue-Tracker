package Issue_Tracker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class LoginFrame extends JFrame implements ActionListener {
 
    Container container=getContentPane();
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel choiceLabel=new JLabel("USERTYPE");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    String[] optionsToChoose = {"Admin", "Guest"};
    JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);

   // JButton jButton = new JButton("Done");
    
    JButton loginButton=new JButton("LOGIN");
    JButton cancelButton=new JButton("REGISTER");
    
    //JCheckBox showPassword=new JCheckBox("Show Password");
 
    LoginFrame()
    {
       //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }
    
   
    
    
   public void setLayoutManager()
   {
       container.setLayout(null);
  
   }
   public void setLocationAndSize()
   {
       //Setting location and Size of each components using setBounds() method.
       userLabel.setBounds(50,150,100,30);
       passwordLabel.setBounds(50,200,100,30);
       choiceLabel.setBounds(50,250,100,30);
       userTextField.setBounds(150,150,150,30);
       passwordField.setBounds(150,200,150,30);
      // showPassword.setBounds(150,250,150,30);
       loginButton.setBounds(50,450,100,30);
       cancelButton.setBounds(200,450,100,30);
       jComboBox.setBounds(150,250,150,30);
      // jButton.setBounds(200,350,100,30);
       
 
   }
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
       container.add(userLabel);
       container.add(passwordLabel);
       container.add(choiceLabel);
       container.add(userTextField);
       container.add(passwordField);
       //container.add(showPassword);
       container.add(loginButton);
       container.add(cancelButton);
       container.add(jComboBox);
       //container.add(jButton);
       loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {     
	           String data = jComboBox.getItemAt(jComboBox.getSelectedIndex());

	           if(data == "Admin") 
	           {
	        	   new DataTable_admin();
	        	  // System.out.println("oo");
	        }
	        }
	     }); 
       
       loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {     
	           String data = jComboBox.getItemAt(jComboBox.getSelectedIndex());

	           if(data == "Guest") 
	           {
	        	   new RegistrationForm();
	        }
	        }
	     }); 
       cancelButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {     
		          
	        	   new RegistrationForm();
	        }
	        });
   }
 

}
 


public class loginpg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
        LoginFrame frame=new LoginFrame();
        frame.getContentPane().setBackground(Color.cyan);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
	}

}
