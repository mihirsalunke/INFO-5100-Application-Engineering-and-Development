package PartC;

import java.util.Calendar;
import java.util.Date;

public class Cat extends Pet implements Boardable {

	private String hairLength;
	private Date boardingStartDate, boardingEndDate, boarding;

	public Cat(String name, String ownerName, String color, String hairLength) {
		super(name, ownerName, color);
		this.hairLength = hairLength;
	}

	public String getHairLength() {
		return hairLength;
	}

	@Override
	public String toString() {
		return "CAT: " +"\n" + super.toString() + "\nHair: " + this.hairLength + "\n";
	}

	@Override
	public void setBoardStart(int month, int day, int year)  {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		boardingStartDate = cal.getTime();
	}

	@Override
	public void setBoardEnd(int month, int day, int year)  {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		boardingEndDate = cal.getTime();	
	}

	@Override
	public boolean boarding(int month, int day, int year)  {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		boarding = cal.getTime();

		if((boarding.compareTo(boardingStartDate) > 0) && (boarding.compareTo(boardingEndDate) < 0) || (boarding.compareTo(boardingStartDate) == 0) || (boarding.compareTo(boardingEndDate) == 0))
		{
			return true;
		}
		return false;
	}
}
