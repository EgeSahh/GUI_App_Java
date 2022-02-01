import javax.swing.JOptionPane;

public class High extends SubscriptionAccount{
	
	public static final double cost = 30.50;
	
	public High(String username,String name, String surname, String email, String password, String creditCard,int month){
		super(username, name, surname, email, password, creditCard, month);

	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCreditCard() {
		return creditCard;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getSub() {
		return "High";
	}
	
	public void getInfo() {
		JOptionPane high = new JOptionPane();
		high.showMessageDialog(null, "High kalitede hesap oluþturulmuþtur.");
		JOptionPane info = new JOptionPane();
		info.showMessageDialog(null, name + " "+ surname + " High üyeliðe sahip olan olup ödemesi gereken " + month + " aylýk tutar " + cost * getMonth() + " TL'dir.");
		
	}
	
	
}
