package com.hoang.ryan.choombah_bot.components;
import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;
import org.springframework.stereotype.Component;

@Component
public class Network {
	private String difficultyRating;
	private int totalFloors;
	private int totalBranches;
	
	private TreeMap<Integer, Floor> network= new TreeMap(); //probably change this to a tree
	
	public Network(String difficultyRating) {
		setDifficultyRating(difficultyRating);
		rollFloorCount();
		rollBranchCount();
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
	
	//rolls 3d6 to obtain the number of floors in the network
	private void rollFloorCount() {
		Random d6 = new Random();
		
		for (int roll = 0; roll < 3 ; roll++) {
			this.totalFloors += roll;
		}
		
	}
	
	//roll a d10 if you get a 7 or higher your network will have a branch repeat until you stop rolling a 7 or higher
	private void rollBranchCount() {
		Random d10 = new Random();
		
		while(1+d10.nextInt(10) >=7) {
			this.totalBranches++;
			
			//exit case as a network cannot have more branches then floors we will set the branches back to 0
			if(this.totalBranches>=this.totalFloors) {
				this.totalBranches = 0;
				return;
			}
		}
	}
	
	private Floor[] generateBranches() {
		Floor [] branches = new Floor [getTotalBranches()];
		int remainingFloors = getTotalFloors();
		
		for (int branch = 0; branch <= this.totalBranches; branch++) {
			if( branch == this.totalBranches) {
				branches[branch] = fillBranch(remainingFloors); 
				break;
			}
		}
		return branches;
	}
	
	private Floor fillBranch(int floors) {
		Floor currentFloor = new Floor();
		currentFloor.setFloorNumber(1);
		
		Floor startingFloor = currentFloor;
		
		for (int floorNumber = 2; floorNumber <= floors+1; floorNumber++) {
			Floor nextFloor = new Floor();
			nextFloor.setFloorNumber(floorNumber);		
			currentFloor.setNextFloor(nextFloor);
			currentFloor = nextFloor;
		}
		
		
		currentFloor = startingFloor;
		while(currentFloor.next() != null) {
			if(currentFloor.next()!= null) {
				System.out.println("Generated Floor: " + currentFloor.getFloorNumber());
				currentFloor = currentFloor.next();
			}
		}
		
		return startingFloor;
	}

	public void generateNetwork() {
		Floor [] branches = generateBranches();
	}
}
