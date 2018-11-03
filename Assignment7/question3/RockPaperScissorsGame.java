package question3;

class Tool{
	private int strength;
	protected char type;

	Tool(){}
	Tool(int s){this.strength = s;}

	public void setStrength(int n){
		this.strength = n;
	}

	public int getStrength(){
		return strength;
	}    
}

class Scissors extends Tool{
	Scissors(){}
	Scissors(int s){
		super.setStrength(s);
		super.type = 's';
	}

	public boolean fight(Tool tool){
		double factor = 1.0;
		if(tool.getClass() == Paper.class) factor *= 2;
		if(tool.getClass() == Rock.class) factor /= 2;

		return factor * this.getStrength() > tool.getStrength();
	}
}

class Paper extends Tool{
	Paper(){}
	Paper(int s){
		super.setStrength(s);
		super.type = 'p';
	}

	public boolean fight(Tool tool){
		double factor = 1.0;
		if(tool.getClass() == Rock.class) factor *= 2;
		if(tool.getClass() == Scissors.class) factor /= 2;
		return factor * this.getStrength() > tool.getStrength();
	}
}

class Rock extends Tool{
	Rock(){}
	Rock(int n){
		super(n);
		super.type = 'r';
	}

	public boolean fight(Tool tool){
		double factor = 1.0;
		if(tool.getClass() == Scissors.class) factor *= 2;
		if(tool.getClass() == Paper.class) factor /= 2;

		return factor * this.getStrength() > tool.getStrength();
	}
}

public class RockPaperScissorsGame {
	public static void main(String[] args) {
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		System.out.println(s.fight(p) + " , " + p.fight(s));
		System.out.println(p.fight(r) + " , " + r.fight(p));
		System.out.println(r.fight(s) + " , " + s.fight(r));
	}
}