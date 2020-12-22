package com.hoang.ryan.choombah_bot.components;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class Network {
	private String difficultyRating;
	private int totalFloors;
	private int totalBranches;
	
	private Floor network;
	
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
		int floors=0;
		for (int roll = 0; roll < 3 ; roll++) {
			floors += 1+d6.nextInt(6);
		}
		setTotalFloors(floors);
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
	
	public Floor getLobbyFloor() {
		return network;
	}

	private void setNetwork(Floor network) {
		this.network = network;
	}

	
	//Separates the total floors into branches indicated by totalBranches then fills each branch with a random amount of floors such that the it adds up to total floors
	private Floor[] generateBranches() {
		Floor [] branches = new Floor [getTotalBranches()+1];
		int remainingFloors = getTotalFloors();
		
		Random rand = new Random();
		for (int branch = 0; branch <= this.totalBranches; branch++) {
			if( branch == this.totalBranches) {
				branches[branch] = fillBranch(remainingFloors); 
				break;
			}
			
			else if (branch == 0) {
				int floorsUsed = 3+rand.nextInt(remainingFloors-(totalBranches+3));
				remainingFloors-=floorsUsed;
				branches[branch] = fillBranch(floorsUsed);
			}
			else {
				int floorsUsed = 1+rand.nextInt(remainingFloors-(this.totalBranches-branch));
				remainingFloors-=floorsUsed;
				branches[branch] = fillBranch(floorsUsed);
			}
		}
		
		
		//Tester to iterate over the branches
		/*for(Floor floor: branches) {
			while(floor!=null) {
				System.out.println("Current Floor Number: " + floor.getFloorNumber());
				floor = floor.next();
			}
			System.out.println("Next Branch");
		}*/
			
		return branches;
	}
	
	//Fills each branch with floors such that the total floor count is used
	private Floor fillBranch(int floors) {
		Floor currentFloor = new Floor();
		currentFloor.setFloorNumber(1);
		
		Floor startingFloor = currentFloor;
		
		for (int floorNumber = 2; floorNumber <= floors; floorNumber++) {
			Floor nextFloor = new Floor();
			nextFloor.setFloorNumber(floorNumber);		
			currentFloor.setNextFloor(nextFloor);
			currentFloor = nextFloor;
		}
		
		return startingFloor;
	}
	
	//retrieves the number of floors each branch has as an array where the index matches the index of the branch
	private int[] getFloorCounts(Floor[] branches) {
		int floorCounts[] = new int [branches.length];
		
		Floor[] traverser = branches.clone();
		
		for(int traverserIndex = 0; traverserIndex < traverser.length; traverserIndex++) {
			int branchLength = 0;
			while(traverser[traverserIndex]!=null) {
				branchLength++;
				traverser[traverserIndex] = traverser[traverserIndex].next();
			}
			floorCounts[traverserIndex] = branchLength;
		}
		
		return floorCounts;
	}
	
	//Locates the virus branch by obtain the index with largest integer
	private int locateVirusBranch(int[] branches) {
		int mainBranchCount=0;
		int index =0;
		
		for(int branch = 0 ; branch <branches.length; branch++) {
			if (branches[branch] > mainBranchCount){
				index = branch;
				mainBranchCount = branches[branch];
			}
 		}
		
		return index;
	}

	//connects the individual branches to form the network
	private Floor connectBranches(Floor[] branches, int[] branchesFloorCount) {
		Floor network = branches[0];
		
		for(int branchPtr = 1; branchPtr<branches.length;branchPtr++) {
			Random rand = new Random();
			
			int branchOffPoint = 3+rand.nextInt(branchesFloorCount[0]-3);
			
			System.out.println("Add the branch at floor: " + branchOffPoint);
			toMainBranch(branches[0],branchOffPoint, branches[branchPtr]);
		}
		
		return network;
	}
	
	//add the branch on the branchOffPoint's floor to the main branch
	private void toMainBranch(Floor mainBranch, int branchOffPoint, Floor branch) {
		Floor startingFloor = mainBranch;
		
		for (int floor = 1; floor <branchOffPoint; floor++) {
			mainBranch = mainBranch.next();
		}
		
		mainBranch.addBranch(branch);
		
		mainBranch = startingFloor;
	}

	private void traverseNetwork() {
		Floor currentFloor = getLobbyFloor();
		
		System.out.println("Beginning network traversal");
		
		while(currentFloor!=null) {
			System.out.println("Current Floor" + currentFloor.getFloorNumber());
			
			if(currentFloor.getBranches()!= null) {
				traverseBranches(currentFloor.getBranches());
			}
			
			currentFloor=currentFloor.next();
		}
		
	}
	
	private void traverseBranches(Floor[] branches) {
		
		for (Floor branch : branches) {
			System.out.println("New Branch");
			while(branch!=null) {
				System.out.println("Branch Floor Number: " + branch.getFloorNumber());
				branch = branch.next();
			}
			System.out.println("End of Branch");
		}
		
	}

	public void generateNetwork() {
		Floor [] branches = generateBranches();
		int branchesFloorCount[] = getFloorCounts(branches);
		int virusBranch = locateVirusBranch(branchesFloorCount);
		//System.out.println("Main Branch is located at: " + mainBranch);
		
		for(Floor floor: branches) {
			while(floor!=null) {
				System.out.println("Current Floor Number: " + floor.getFloorNumber());
				floor = floor.next();
			}
			System.out.println("Next Branch");
		}
	
		Floor network = connectBranches(branches, branchesFloorCount);
	
		setNetwork(network);
		
		traverseNetwork();
	}
}
