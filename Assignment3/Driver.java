package Assignment_3_part_2;

public class Driver {

	public static void main(String[] args) {
		Psychiatrist psychiatrist = new Psychiatrist();
		Moody sadPerson = new Sad();
		Moody happyPerson = new Happy();
		psychiatrist.examine(happyPerson);
		System.out.println(happyPerson.getMood());
		System.out.println(" ");
		happyPerson.expressFeelings();
		psychiatrist.observe(happyPerson);
		psychiatrist.examine(sadPerson);
		System.out.println(sadPerson.getMood());
		System.out.println(" ");
		sadPerson.expressFeelings();
		psychiatrist.observe(sadPerson);
	}

}

abstract class Moody{
	abstract String getMood();
	abstract void expressFeelings();
	public void queryMood() {

	}
}
class Happy extends Moody{

	String getMood() {
		return"I am feeling happy today!";
	}

	void expressFeelings() {
		System.out.println("hehehe...hahaha..HAHAHAHA!");
	}

	public String toString() {
		return"Subject laughs a lot";
	}
}

class Sad extends Moody{

	String getMood() {
		return"I am feeling sad today!";
	}

	void expressFeelings() {
		System.out.println("'wah' 'boo hoo' 'weep' 'sob'");
	}

	public String toString() {
		return"Subject cries a lot";
	}
}


class Psychiatrist{

	void examine(Moody person) {
		System.out.println("How are you feeling today?");
	}

	void observe(Moody person) {
		System.out.println("Observation: " +person.toString());
		System.out.println("");
	}
}