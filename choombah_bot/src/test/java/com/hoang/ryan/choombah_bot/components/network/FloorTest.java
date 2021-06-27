package com.hoang.ryan.choombah_bot.components.network;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoang.ryan.choombah_bot.components.network.Floor;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FloorTest {
	final String testResident = "imp";
	final int testFloorNumber = 25;
	
	@Mock
	private Floor testFloor;
	
	//Tests for blank constructor
	@Test
	public void testFloor() {
		testFloor = new Floor();
		
		assertEquals("Default floor number should be 0", 0, testFloor.getFloorNumber());
		assertEquals("Default resident should be null", null, testFloor.getResident());
	}
	
	//Test for constructor given resident and floor number
	@Test
	public void testFloorStringInt() {
		testFloor = new Floor(testResident, testFloorNumber);
		
		assertEquals("Resident should be an imp", testResident, testFloor.getResident());
		assertEquals("Floor number should be 25", testFloorNumber, testFloor.getFloorNumber());
	}

	//test the getter through the default floor constructor
	@Test
	public void testGetResident() {
		testFloor = new Floor();
		assertEquals("Default resident should be null", null, testFloor.getResident());
	}

	//tests setter after floor constructor is initially called and resident is changed
	@Test
	public void testSetResident() {
		testFloor = new Floor();
		assertEquals("Default resident should be null", null, testFloor.getResident());
		
		testFloor.setResident(testResident);
		assertEquals("Resident should be set to an imp after setter is called", testResident, testFloor.getResident());
	}

	//tests the getter through the default floor constructor
	@Test
	public void testGetFloorNumber() {
		testFloor = new Floor();
		assertEquals("Default floor number should be 0", 0, testFloor.getFloorNumber());
	}

	//tests setter after floor constructor is initially called and floor number is changed
	@Test
	public void testSetFloorNumber() {
		testFloor = new Floor();
		assertEquals("Default floor number should be 0", 0, testFloor.getFloorNumber());
		
		testFloor.setFloorNumber(testFloorNumber);
		assertEquals("Floor number should be 25", testFloorNumber, testFloor.getFloorNumber());
	}

}
