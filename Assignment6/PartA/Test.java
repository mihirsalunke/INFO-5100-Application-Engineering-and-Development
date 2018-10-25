package PartA;

public class Test {

	public static void main(String[] args) {
		Mreview movie1 = new Mreview("Interstellar");
		movie1.addRating(2);
		movie1.addRating(3);
		movie1.addRating(5);
		System.out.println(movie1);

		Mreview movie2 = new Mreview("Gravity", 5);
		movie2.addRating(4);
		movie2.addRating(2);
		movie2.addRating(3);
		System.out.println(movie2);

		System.out.println("\n");
		System.out.println("The movie list contains two movies 'Interstellar' and 'Gravity'");
		System.out.println("\nTesting compareTo method");
		System.out.println("When 'Interstellar' is compared to 'Gravity': " + movie1.compareTo(movie2));
		System.out.println("When 'Gravity' is compared to 'Interstellar': " + movie2.compareTo(movie1));
		System.out.println("When 'Interstellar' is compared to 'Interstellar': " + movie1.compareTo(movie1));
		System.out.println("When 'Gravity' is compared to 'Gravity': " + movie2.compareTo(movie2));
		System.out.println("\nTesting equals method");
		System.out.println("'Interstellar' = 'Gravity': " + movie1.equals(movie2));
		System.out.println("'Gravity' = 'Interstellar': " + movie2.equals(movie1));
		System.out.println("'Interstellar' = 'Interstellar': " + movie1.equals(movie1));
		System.out.println("'Gravity' = 'Gravity': " + movie2.equals(movie2));
	}
}
