package PartC;

public class Pet {

	private String name, ownerName, color, sex;
	protected int sexId;
	public static final int MALE = 1, FEMALE = 2, SPAYED = 3, NEUTERED = 4;

	public Pet(String name, String ownerName, String color) {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}

	public String getPetName() {
		return name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getColor() {
		return color;
	}

	public void setSex(int sexId) {
		switch(sexId) {
		case 1:
			sex = "male";
			break;
		case 2:
			sex = "female";
			break;
		case 3:
			sex = "spayed";
			break;
		case 4:
			sex = "neutered";
			break;
		}
	}

	public String getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return this.name + " owned by " + this.ownerName + "\nColor: " +this.color + "\nSex: " + getSex();
	}
}
