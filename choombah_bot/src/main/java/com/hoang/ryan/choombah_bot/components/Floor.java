package com.hoang.ryan.choombah_bot.components;

import org.springframework.stereotype.Component;

public class Floor {
	private String resident;
	private int floorNumber;
	private Floor nextFloor;
	private Floor[] branches;
	
	public Floor() {
		
	}
	
	public Floor(String resident, int floorNumber) {
		setResident(resident);
		setFloorNumber(floorNumber);
	}
	
	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Floor next() {
		return nextFloor;
	}

	public void setNextFloor(Floor nextFloor) {
		this.nextFloor = nextFloor;
	}

	public Floor[] getBranches() {
		return branches;
	}

	public void addBranch(Floor branch) {
		if(this.branches==null) {
			this.branches = new Floor[1];
			this.branches[0] = branch;
		}
		else {
			Floor[] branches = new Floor[getBranches().length+1];
			for (int ptr = 0; ptr > this.branches.length; ptr++) {
				branches[ptr] = this.branches[ptr];
			}
			
			branches[branches.length-1] = branch;
			this.branches = branches;
		}
	}
}
