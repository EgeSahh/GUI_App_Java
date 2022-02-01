
public abstract class SubscriptionAccount {

	protected String username ;
	protected String name ;
	protected String surname ;
	protected String email ;
	protected String password ;
	protected String creditCard ;
	protected int month ;
	
	public SubscriptionAccount(String username, String name, String surname, String email, String password, String creditCard, int month) {
		this.month = month;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.creditCard = creditCard;
	}
	
	public abstract String getUsername();
	public abstract void setUsername(String username);

	public abstract String getCreditCard();
	public abstract void setCreditCard(String creditCard);

	public abstract int getMonth();
	public abstract void setMonth(int month);

	public abstract void setName(String name);
	public abstract String getName();
	
	public abstract void setSurname(String surname);
	public abstract String getSurname();
	
	public abstract void setEmail(String email);
	public abstract String getEmail();

	public abstract String getPassword();
	public abstract void setPassword(String password);
	
	public abstract String getSub();
	
	public abstract void getInfo();

	
	public abstract double getCost();
	
}
	


