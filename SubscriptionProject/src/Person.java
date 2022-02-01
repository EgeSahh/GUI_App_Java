import java.util.*;

public class Person {
	
	public static ArrayList<SubscriptionAccount> people = new ArrayList<>();
	public static ArrayList<Movie> movies = new ArrayList<>();
	
	static      //Bu static bloðu ile Person sýnýfýnýn constructorý çalýþmadan yani Person sýnýfýna ait bir nesne yaratýlmadan öncesinde movies ArrayList'ine Movie Inner classýna ait film nesnelerimi eklemiþ oluyorum.
	{
		movies.add(new Movie("Pulp Fiction"));
		movies.add(new Movie("Seven"));
		movies.add(new Movie("Fight Club"));
		movies.add(new Movie("The God Father"));
		movies.add(new Movie("Schindler's List"));
		movies.add(new Movie("Inception"));
		movies.add(new Movie("Forrest Gump"));
		movies.add(new Movie("Matrix"));
		movies.add(new Movie("City Of God"));
		movies.add(new Movie("The Green Mile"));
		movies.add(new Movie("The Pianist"));
		movies.add(new Movie("The Leon"));
		
	}
	
	public ArrayList<SubscriptionAccount> getPeople() {
		return people;
	}
	
	public void setPeople(ArrayList<SubscriptionAccount> people) {
		this.people = people;
	}
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	public static class Movie
	{
		private String name;
		
		Movie(String name)
		{
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	

}
