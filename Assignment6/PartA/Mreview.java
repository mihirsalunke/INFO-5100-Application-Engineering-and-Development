package PartA;

import java.util.ArrayList;

public class Mreview implements Comparable<Mreview> {

	private String title;
	private ArrayList<Integer> ratings;

	public Mreview() {
		this("");
	}

	public Mreview(String ttl) {
		this.title = ttl;
		ratings = new ArrayList<Integer>();
	}

	public Mreview(String ttl, int firstRating) {
		this.title = ttl;
		ratings = new ArrayList<Integer>();
		ratings.add(firstRating);
	}

	public void addRating(int r) {
		ratings.add(r);
	}

	public double avgRating() {
		double total=0;
		for(int i=0; i<ratings.size(); i++) {
			total += ratings.get(i);
		}
		return Math.round((total / ratings.size()) * 100) / 100d;
	}

	@Override
	public int compareTo(Mreview obj) {
		Mreview movie = (Mreview) obj;
		int comparison = this.title.compareTo(movie.title);
		if(comparison != 0)
		{
			return comparison;
		}
		return comparison;
	}

	@Override
	public boolean equals(Object obj) {
		Mreview movie = (Mreview) obj;
		if(movie.title == this.title) {
			return true;
		}
		return false;
	}

	public String getTitle() {
		return title;
	}

	public int numRatings() {
		return ratings.size();
	}

	@Override
	public String toString() {
		return getTitle() +", average " +avgRating() +" out of " +numRatings() +" ratings.";
	}
}
