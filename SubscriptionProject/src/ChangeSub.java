import javax.swing.*; // Buttons, text fields, ...
import java.awt.*; // Container, Color, 
import java.awt.event.*;//ActionListener

public class ChangeSub extends JFrame {
	
	private JComboBox sub, month;
	private JButton create, info, close ;
	private JTextField creditCardTf;
	private JLabel creditCard;
	
	SubscriptionAccount per;
	int i;
	
	public ChangeSub(SubscriptionAccount person, int count) {
		
		per = person;
	    i = count;
	    
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		c.setBackground(new Color(229,204,255));
		GridBagConstraints cont = new GridBagConstraints();
		
		String subs[] = {"High", "Medium", "Low"};
		String months[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		
		sub = new JComboBox(subs);
		month = new JComboBox(months);

		create = new JButton("Create New Account");
		info = new JButton("Account Information");
		close = new JButton("Close");
		creditCard = new JLabel("Credit Card");
		creditCardTf = new JTextField(16);
		
		cont.gridx = 0;
		cont.gridy = 0;
		cont.insets = new Insets(15,5,5,10);
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(creditCard, cont);
		
		cont.gridx = 1;
		cont.gridy = 0;
		cont.insets = new Insets(15,5,5,10);
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(creditCardTf, cont);
		
		cont.gridx = 0;
		cont.gridy = 1;
		cont.insets = new Insets(15,5,5,10);
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(sub,cont);
		
		cont.gridx = 1;
		cont.gridy = 1;
		cont.insets = new Insets(15,5,5,10);
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(month,cont);
		
		cont.gridx = 0;
		cont.gridy = 2;
		cont.insets = new Insets(15,5,5,10);
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(info,cont);
		
		cont.gridx = 1;
		cont.gridy = 2;
		cont.insets = new Insets(15,5,5,10);
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(create,cont);
		
		cont.gridx = 0;
		cont.gridy = 3;
		cont.insets = new Insets(15,5,5,10);
		cont.gridwidth = 2;
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(close,cont);
		
		
		close.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						MoviePage mp = new MoviePage(per, i);
						mp.setVisible(true);
						dispose();
					}
				}		
		);
		
		create.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if(sub.getSelectedItem().equals("High")) {
							if( creditCardTf.getText().isEmpty() ) {
								JOptionPane.showMessageDialog(null, "Kredi kartý bilgisi boþ býrakýlamaz !");
							}
							else {
							   int m = Integer.parseInt(month.getSelectedItem().toString());
							   High nperson = new High(per.getUsername(), per.getName(), per.getSurname(), per.getEmail(), per.getPassword(), creditCardTf.getText().toString(), m);
							   Person.people.add(nperson);
							   Person.people.remove(i);
							   i = Person.people.size()-1;
							  
							   JOptionPane.showMessageDialog(null, per.getUsername() + " kullanýcýsý paket deðiþtirerek " + sub.getSelectedItem().toString() + " paketine geçiþ yapmýþtýr. Abonelik boyunca ödenmesi gereken tutar " + m * High.cost + "TL'dir. ");
							
							   dispose();
							   Login login = new Login();
							   login.setVisible(true);
							
							}
						}
						
						else if(sub.getSelectedItem().equals("Medium")) {
							if( creditCardTf.getText().isEmpty() ) {
								JOptionPane.showMessageDialog(null, "Kredi kartý bilgisi boþ býrakýlamaz !");
							}
							else {
							   int m = Integer.parseInt(month.getSelectedItem().toString());
							   Medium nperson = new Medium(per.getUsername(), per.getName(), per.getSurname(), per.getEmail(), per.getPassword(), creditCardTf.getText(), m);
							   Person.people.add(nperson);
							   Person.people.remove(i);
							   i = Person.people.size()-1;
							
							   JOptionPane.showMessageDialog(null, per.getUsername() + " kullanýcýsý paket deðiþtirerek " + sub.getSelectedItem().toString() + " paketine geçiþ yapmýþtýr. Abonelik boyunca ödenmesi gereken tutar " + m * Medium.cost + "TL'dir.");
							
							   dispose();
							   Login login = new Login();
							   login.setVisible(true);
							}
						}
						
						else if(sub.getSelectedItem().equals("Low")) {
							if( creditCardTf.getText().isEmpty() ) {
								JOptionPane.showMessageDialog(null, "Kredi kartý bilgisi boþ býrakýlamaz !");
							}
							else{
								int m = Integer.parseInt(month.getSelectedItem().toString());
							    Low nperson = new Low(per.getUsername(), per.getName(), per.getSurname(), per.getEmail(), per.getPassword(), creditCardTf.getText(), m);
							    Person.people.add(nperson);
							    Person.people.remove(i);
							    i = Person.people.size()-1;
							
							   JOptionPane.showMessageDialog(null, per.getUsername() + " kullanýcýsý paket deðiþtirerek " + sub.getSelectedItem().toString() + " paketine geçiþ yapmýþtýr. Abonelik boyunca ödenmesi gereken tutar " + m * Low.cost + "TL'dir.");
							
								dispose();
								Login login = new Login();
								login.setVisible(true);
							}
						}
						

					}
				}		
		);
		
		info.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						JOptionPane.showMessageDialog(null, "Username: " + per.getUsername() + "\n" + "Name: " + per.getName() + "\n" + "Surname: " + per.getSurname() + "\n" + "Email: " + per.getEmail() + "\n" + "Credit Card: " + per.getCreditCard() + "\n" + "Tutar: " + per.getCost() * per.getMonth() + "TL" );
					}
				}		
		);
		
		setTitle("Change Subscription Form");
		setSize(600, 400);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
}

    


