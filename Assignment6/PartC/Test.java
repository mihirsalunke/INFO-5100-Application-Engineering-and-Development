package PartC;

public class Test {

	public static void main(String[] args) {

		Pet cat = new Cat("Shadow", "Mihir", "black", "long");
		cat.setSex(1);
		System.out.println(cat);
		Pet dog = new Dog("Mistiq", "Kria", "white", "big");
		dog.setSex(2);
		System.out.println(dog);;
	}
}
