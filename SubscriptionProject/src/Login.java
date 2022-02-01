import javax.swing.*; // Buttons, text fields, ...
import java.awt.*; // Container, Color, 
import java.awt.event.*;//ActionListener
import java.util.ArrayList;

public class Login extends JFrame  {

	private JButton signButton,loginButton;
	private JLabel userName, password;
	private JTextField userNameTf, passwordTf;
	
	private boolean control = true;
	Person p;
	
	public Login() {
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,2,20,20));
		c.setBackground(new Color(204,255,229));
		
		userName = new JLabel("Username");
		password = new JLabel("Password");
		
		userNameTf = new JTextField(15);
		passwordTf = new JTextField(15);
		
		signButton = new JButton("Sign");
		loginButton = new JButton("Login");
		
		c.add(userName);
		c.add(userNameTf);
		c.add(password);
		c.add(passwordTf);
		c.add(signButton);
		c.add(loginButton);
		
		p = new Person();
		
		signButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						dispose();
						Sign sign = new Sign();
						sign.setVisible(true);
						
					}
				}		
			);
		
		 loginButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					
					int count = 0;
					
					if(userNameTf.getText().isEmpty() || passwordTf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Kullanýcý adý ve/veya password kýsýmlarý boþ býrakýlamaz !");
					}
					else {
						String username = userNameTf.getText();
						String passWord = passwordTf.getText();
						for(SubscriptionAccount person : p.getPeople()) {
							if(person.getUsername().equals(username) && person.getPassword().equals(passWord)) {
								control = false;
								MoviePage movie = new MoviePage(person,count);
								movie.setVisible(true);
								dispose();
							 }
							
						 }
						if(control) {
							JOptionPane.showMessageDialog(null, "Kullanýcý adý ve/veya password kýsýmlarý hatalýdýr. Lütfen tekrar giriniz.");
						
						}
					}
				}
			}		
		);
		
		setTitle("Movie Application");
		setSize(600, 400);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
