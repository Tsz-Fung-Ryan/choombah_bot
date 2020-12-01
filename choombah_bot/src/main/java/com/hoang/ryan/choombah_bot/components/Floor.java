package com.hoang.ryan.choombah_bot.components;

import org.springframework.stereotype.Component;

@Component
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

	public void setBranches(Floor[] branches) {
		this.branches = branches;
	}
}
