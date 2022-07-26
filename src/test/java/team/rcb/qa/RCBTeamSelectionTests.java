package team.rcb.qa;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import team.rcb.qa.base.RCBTeamSelectionBase;


public class RCBTeamSelectionTests {
	SoftAssertions softAssertions;
	RCBTeamSelectionBase rcbTeamBase;

	RCBTeamSelectionTests() {
		rcbTeamBase = new RCBTeamSelectionBase();
	}

	/**
	 * Method to Initialize Browser and Login to Application
	 */
	@BeforeClass(alwaysRun = true)
	@Parameters({ "runParallel" })
	public void setUp(String runParallel) throws Exception, IOException {

	}

	/**
	 * Method to test no of foreign players are not more than 4 members in a given
	 * team Group - Smoke Test TestName - Verify Foreign Player Count-1.1
	 */
	@Test(description = "Verify Number of Foreign Player are not more than 4", groups = {
			"Smoke_Test" }, testName = "Select Team-1.1")
	public void verifyNumberofForeignPlayer() throws Exception {
		try {
			int foreignPlayersCount = rcbTeamBase.getForeignPlayersCount();

			if (foreignPlayersCount <= 4) {
				System.out.println("Hurray!! Ee Sala Cup Namde ");
				Assert.assertTrue(true, "No of foreign players " + foreignPlayersCount);
			} else {
				Assert.assertTrue(false, "No of foreign players " + foreignPlayersCount);
			}
		} catch (Exception e) {

		}
	}

	@Test(description = "Verify Number of Foreign Player are not more than 4", groups = {
			"Smoke_Test" }, testName = "Select Team-1.2")
	public void verifyNumberofKeepingPlayer() throws Exception {
		try {
			int wicketKeeperCount = rcbTeamBase.getWicketKeeperCount();

			if (wicketKeeperCount >= 1) {
				System.out.println("Hurray!! Ee Sala Cup Namde ");
				Assert.assertTrue(true, "No of foreign players " + wicketKeeperCount);
			} else {
				Assert.assertTrue(false, "No of foreign players " + wicketKeeperCount);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Method to Quit OR any closing actions
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {

	}
}
