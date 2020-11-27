package com.hoang.ryan.choombah_bot;

public class Floor {
	private String resident;
	private int floorNumber;
	
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
}
