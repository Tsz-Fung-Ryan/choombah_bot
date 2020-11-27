package com.hoang.ryan.choombah_bot;
import java.util.Random;


public class Network {
	private String difficultyRating;
	private int totalFloors;
	private int totalBranches;
	
	private Floor [][] floors; //probably change this to a tree
	
	public Network(String difficultyRating) {
		setDifficultyRating(difficultyRating);
		generateNetwork();
	}
	
	public Network(String difficultyRating ,int floorCount, int branchCount) {
		setDifficultyRating(difficultyRating);
		setTotalFloors(floorCount);
		setTotalBranches(branchCount);
		
		generateNetwork();
	}

	public String getDifficultyRating() {
		return difficultyRating;
	}

	public void setDifficultyRating(String difficultyRating) {
		this.difficultyRating = difficultyRating;
	}

	public int getTotalFloors() {
		return totalFloors;
	}

	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}

	public int getTotalBranches() {
		return totalBranches;
	}

	public void setTotalBranches(int totalBranches) {
		this.totalBranches = totalBranches;
	}
	
	public void generateNetwork() {
		System.out.println(getTotalFloors());
	}
}
