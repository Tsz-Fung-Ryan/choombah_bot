package com.hoang.ryan.choombah_bot;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkTest {
	
	Network testNetwork;
	final String testDifficultyRating = "basic";
	final int testFloorCount = 18;
	final int testBranchCount = 3;

	//Test constructor with specifying difficulty rating
	@Test
	public void testNetworkString() {
		testNetwork = new Network (testDifficultyRating);
		assertEquals("Network is setup with indicated difficulty", testDifficultyRating, testNetwork.getDifficultyRating());
	}

	//Test constructor with specifying difficulty rating, specific floor count and specific branch count
	@Test
	public void testNetworkStringIntInt() {
		testNetwork = new Network(testDifficultyRating, testFloorCount, testBranchCount);
		
		assertEquals("Network should be setup with test difficulty", testDifficultyRating, testNetwork.getDifficultyRating());
		assertEquals("Network should be setup with test floor count", testFloorCount, testNetwork.getTotalFloors());
		assertEquals("Network should be setup with test branch count", testBranchCount, testNetwork.getTotalBranches());
	}

	//Test the difficulty rating getter to reflect what is indicated to test difficulty rating
	@Test
	public void testGetDifficultyRating() {
		testNetwork = new Network(testDifficultyRating);
		assertEquals("Getter should pull test difficulty", testDifficultyRating, testNetwork.getDifficultyRating());
	}
	
	//Test the difficulty rating setter before setting the difficulty rating and after the rating is set
	@Test
	public void testSetDifficultyRating() {
		testNetwork = new Network("");
		assertFalse(testDifficultyRating == testNetwork.getDifficultyRating());
		
		testNetwork.setDifficultyRating(testDifficultyRating);
		assertEquals("Network should have reflected the change in difficulty rating", testDifficultyRating, testNetwork.getDifficultyRating());
	}

	//tests floor count getter
	@Test
	public void testGetTotalFloors() {
		testNetwork = new Network(testDifficultyRating, testFloorCount, testBranchCount);
		
		assertEquals("Getter should return the amount indicated in testFloorCount", testFloorCount, testNetwork.getTotalFloors());
	}

	@Test
	public void testSetTotalFloors() {
		testNetwork = new Network("");
		assertFalse(testFloorCount == testNetwork.getTotalFloors());
		
		testNetwork.setTotalFloors(testFloorCount);
		assertEquals("Network should have reflected the change in floor count", testFloorCount, testNetwork.getTotalFloors());
	}

	@Test
	public void testGetTotalBranches() {
		testNetwork = new Network(testDifficultyRating, testFloorCount, testBranchCount);
		assertEquals("Getter should return the amount indicated in testBranchCount", testBranchCount, testNetwork.getTotalBranches());
	}

	@Test
	public void testSetTotalBranches() {
		testNetwork = new Network("");
		assertFalse(testBranchCount == testNetwork.getTotalBranches());
		
		testNetwork.setTotalBranches(testBranchCount);
		assertEquals("Network should reflect changes in floor count", testBranchCount, testNetwork.getTotalBranches());
	}

	@Test
	public void testGenerateNetwork() {
		fail("Not yet implemented");
	}

}