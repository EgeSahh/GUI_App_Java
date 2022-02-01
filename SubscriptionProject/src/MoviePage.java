import javax.swing.*; // Buttons, text fields, ...
import java.awt.*; // Container, Color, 
import java.awt.event.*;//ActionListener
import java.util.ArrayList;
public class MoviePage extends JFrame {

	private JButton changeSub, back;
	private JLabel FilmListesi;
	//Person peo;
	private ArrayList<JButton> movieButtons;
	SubscriptionAccount per;
	private final int control = 150720;
	
	public MoviePage(SubscriptionAccount person, int count) {
		
		per = person;
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		c.setBackground(new Color(255,255,204));
		GridBagConstraints cont = new GridBagConstraints();
		
		FilmListesi = new JLabel("Film Listesi");
		cont.gridx = 0;
		cont.gridy = 0;
		cont.insets = new Insets(15,5,5,10);
		cont.gridwidth = 2;
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(FilmListesi,cont);
		
		int x = 0;
		int y = 1;
		
		movieButtons = new ArrayList<JButton>(Person.movies.size());
		MovieListener listenerObject = new MovieListener();
		
		for(int i = 0; i<Person.movies.size(); i++)
		{
			movieButtons.add( new JButton(Person.movies.get(i).getName()));
			movieButtons.get(i).addActionListener(listenerObject);
			cont.gridx = x;
			cont.gridy = y;
			cont.gridwidth = 1;
			cont.fill = GridBagConstraints.HORIZONTAL;
			c.add(movieButtons.get(i),cont);
			x++;

			if(x%2 == 1)
			{
				cont.gridx = x;
				cont.gridy = y;
				cont.gridwidth = 1;
				cont.fill = GridBagConstraints.HORIZONTAL;
				movieButtons.add( new JButton(Person.movies.get(++i).getName()));
				movieButtons.get(i).addActionListener(listenerObject);
				c.add(movieButtons.get(i),cont);
				
				y++;
				x=0;
			}
		}
		
		changeSub = new JButton("Change Account");
		
		cont.gridx = 0;
		cont.gridy ++;
		cont.gridwidth = 2;
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(changeSub,cont);
		
		back = new JButton("Back");
		
		cont.gridx = 0;
		cont.gridy ++;
		cont.gridwidth = 2;
		cont.fill = GridBagConstraints.HORIZONTAL;
		c.add(back,cont);
		
		
		changeSub.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ChangeSub change = new ChangeSub(per, count);
						change.setVisible(true);
						dispose();
					}
				}		
		);
		
		back.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						Login back = new Login();
						back.setVisible(true);
						dispose();
					}
				}		
		);
		
		setTitle("Movie List");
		setSize(600, 600);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public class MovieListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(per.getSub().equals("High")) 
			{
				JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 1080p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");
			}
			else if(per.getSub().equals("Medium")) {
				if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("Seven")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 720p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
			    }
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("City Of God")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 720p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("Inception")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 720p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("The Leon")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 720p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("Matrix")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 720p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("The Green Mile")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 720p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else {
				String str = JOptionPane.showInputDialog(null, Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " açýlamaz. Ebeveyn kontrolüne ihtiyaç duyulmaktadýr. \n Bu nedenle lütfen þifre giriniz.");
				   try {
				     int n = Integer.parseInt(str); 
				     if(n == control) {
				    	 JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " artýk açýlabilir.");	
				     }
				     else if(n != control) {
				    	 JOptionPane.showMessageDialog(null, "Ebeveyn kontrolü için girilen þifre yanlýþtýr. Lütfen tekrar deneyiniz.");
				     }
				   }
				   catch(NumberFormatException e) {
					 JOptionPane.showMessageDialog(null, "Ebeveyn kontrolü için girilen þifre yanlýþtýr. Lütfen tekrar deneyiniz.");
				   }
				}
			}
			else if(per.getSub().equals("Low")) {
				if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("Inception")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 480p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("The Leon")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 480p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else if(Person.movies.get(movieButtons.indexOf(ae.getSource())).getName().equals("Matrix")) {
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " 480p kalitede açýlýyor. Ebeveyn kontrolüne ihtiyaç duyulmuyor.");	
				}
				else {
				   String str = JOptionPane.showInputDialog(null, Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " açýlamaz. Ebeveyn kontrolüne ihtiyaç duyulmaktadýr. \n Bu nedenle lütfen þifre giriniz.");
				   try {
				     int n = Integer.parseInt(str); 
				     if(n == control) {
				    	 JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " artýk açýlabilir.");	
				     }
				     else if(n != control) {
				    	 JOptionPane.showMessageDialog(null, "Ebeveyn kontrolü için girilen þifre yanlýþtýr. Lütfen tekrar deneyiniz.");
				     }
				   }
				   catch(NumberFormatException e) {
					 JOptionPane.showMessageDialog(null, "Ebeveyn kontrolü için girilen þifre yanlýþtýr. Lütfen tekrar deneyiniz.");
				   }
				}
				   	
			}
			else if(per.getSub().equals("Free")) {
				
				   JOptionPane.showMessageDialog(null,Person.movies.get(movieButtons.indexOf(ae.getSource())).getName() + " açýlamaz. Bir abonelik modeli satýn almak zorundasýnýz.");	
			}
		}
	}
	
}
