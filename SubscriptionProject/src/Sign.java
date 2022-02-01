import javax.swing.*; // Buttons, text fields, ...
import java.awt.*; // Container, Color, 
import java.awt.event.*;//ActionListener
import java.io.*;

public class Sign extends JFrame {
    
	private JComboBox sub, month;
	private JButton back,close, pay ;
	private JLabel userName, name, surname, password, email, creditCard;
	private JTextField userNameTf, nameTf, surnameTf, passwordTf, emailTf, creditCardTf;

	public Sign() {
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(9,3,20,20));
		c.setBackground(new Color(255,204,204));
		
		String subs[] = {"High", "Medium", "Low", "Free"};
		String months[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		sub = new JComboBox(subs);
		month = new JComboBox(months);
		
		userName = new JLabel("Username");
		name = new JLabel("Name");
		surname = new JLabel("Surname");
		password = new JLabel("Password");
		email = new JLabel("E-mail");
		creditCard = new JLabel("Credit Card");
		
		userNameTf = new JTextField(15);
		nameTf = new JTextField(15);
		surnameTf = new JTextField(15);
		passwordTf = new JTextField(15);
		emailTf = new JTextField(15);
		creditCardTf = new JTextField(16);
		
		back = new JButton("Back");
		close = new JButton("Close");
		pay = new JButton("Pay and Create Account");
		
		EventHandler eh = new EventHandler();
		pay.addActionListener(eh);
		
		
		c.add(userName);
		c.add(userNameTf);
		c.add(name);
		c.add(nameTf);
		c.add(surname);
		c.add(surnameTf);
		c.add(password);
		c.add(passwordTf);
		c.add(email);
		c.add(emailTf);
		c.add(creditCard);
		c.add(creditCardTf);
		c.add(sub);
		c.add(month);
		c.add(pay);
		c.add(back);
		c.add(close);
		
		back.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						dispose();
						Login login = new Login();
						login.setVisible(true);
					}
				}		
			);
		
		close.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						dispose();
					}
				}		
		);
		
		
		setTitle("Register Form");
		setSize(600, 400);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	
	public class EventHandler extends Person implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == pay) {
				
				if(sub.getSelectedItem().toString().equals("High")) {
					if(userNameTf.getText().isEmpty() || passwordTf.getText().isEmpty() || nameTf.getText().isEmpty() || surnameTf.getText().isEmpty() || emailTf.getText().isEmpty() || creditCardTf.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Ýlgili kýsýmlar boþ býrakýlamaz !");
					}
					else {
					   int m = Integer.parseInt(month.getSelectedItem().toString()); 
					   High high = new High(userNameTf.getText(),nameTf.getText(), surnameTf.getText(), emailTf.getText(), passwordTf.getText(), creditCardTf.getText(), m);
					   high.getInfo();
					   Person.people.add(high);
					      
					}
				}
				
				if(sub.getSelectedItem().toString().equals("Medium")) {
					if(userNameTf.getText().isEmpty() || passwordTf.getText().isEmpty() || nameTf.getText().isEmpty() || surnameTf.getText().isEmpty() || emailTf.getText().isEmpty() || creditCardTf.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Ýlgili kýsýmlar boþ býrakýlamaz !");
					}
					else {
					   int m = Integer.parseInt(month.getSelectedItem().toString()); 
					   Medium medium = new Medium(userNameTf.getText(),nameTf.getText(), surnameTf.getText(), emailTf.getText(), passwordTf.getText(), creditCardTf.getText(), m);
				       medium.getInfo();
					   Person.people.add(medium);
					}
				}
				
				if(sub.getSelectedItem().toString().equals("Low")) {
					if(userNameTf.getText().isEmpty() || passwordTf.getText().isEmpty() || nameTf.getText().isEmpty() || surnameTf.getText().isEmpty() || emailTf.getText().isEmpty() || creditCardTf.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Ýlgili kýsýmlar boþ býrakýlamaz !");
					}
					else{
						int m = Integer.parseInt(month.getSelectedItem().toString()); 
					    Low low = new Low(userNameTf.getText(),nameTf.getText(), surnameTf.getText(), emailTf.getText(), passwordTf.getText(), creditCardTf.getText(), m);
				        low.getInfo();
					    Person.people.add(low);
					}
				}
				if(sub.getSelectedItem().toString().equals("Free")) {
					if(userNameTf.getText().isEmpty() || passwordTf.getText().isEmpty() || nameTf.getText().isEmpty() || surnameTf.getText().isEmpty() || emailTf.getText().isEmpty() || creditCardTf.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Ýlgili kýsýmlar boþ býrakýlamaz !");
					}
					else {
					   int m = Integer.parseInt(month.getSelectedItem().toString()); 
					   Demo free = new Demo(userNameTf.getText(),nameTf.getText(), surnameTf.getText(), emailTf.getText(), passwordTf.getText(), creditCardTf.getText(), m);
				       free.getInfo();
					   Person.people.add(free);
					}
				}
			}
			
		}
		
	}
}
	
	




	