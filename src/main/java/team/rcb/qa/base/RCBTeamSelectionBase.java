package team.rcb.qa.base;

import java.io.FileNotFoundException;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import team.rcb.qa.utils.ReadJsonData;

public class RCBTeamSelectionBase {

	public int getForeignPlayersCount() {

		int count = 0;
		try {
			JsonObject teamRCBData = new ReadJsonData().readJsonElementInOrder("rcbTeamData.json");

			JsonArray playersDetails = teamRCBData.getAsJsonArray("player");
			for (int i = 0; i < playersDetails.size(); i++) {

				JsonObject obj = playersDetails.get(i).getAsJsonObject();

				if (!(obj.get("country").getAsString().trim().equalsIgnoreCase("India"))) {
					count++;
				}

			}

		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int getWicketKeeperCount() {

		int count = 0;
		try {
			JsonObject teamRCBData = new ReadJsonData().readJsonElementInOrder("rcbTeamData.json");

			JsonArray playersDetails = teamRCBData.getAsJsonArray("player");
			for (int i = 0; i < playersDetails.size(); i++) {

				JsonObject obj = playersDetails.get(i).getAsJsonObject();

				if (!(obj.get("role").getAsString().trim().equalsIgnoreCase("Wicket-keeper"))) {
					count++;
				}

			}

		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public double getTotalPriceforForeignPlayers() {
		
		double amount=0;
		
		try {
			JsonObject teamRCBData = new ReadJsonData().readJsonElementInOrder("rcbTeamData.json");

			JsonArray playersDetails = teamRCBData.getAsJsonArray("player");
			for (int i = 0; i < playersDetails.size(); i++) {

				JsonObject obj = playersDetails.get(i).getAsJsonObject();
				

				if (!(obj.get("country").getAsString().trim().equalsIgnoreCase("India"))) {
					amount += obj.get("price-in-crores").getAsDouble();
				}

			}

		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total Price for Foreign Players: "+ amount);
		return amount;
	}
	
	
	
//	public WebElement identifyElement(String id) {
//		
//		try {
//			
//		WebDriverWait wait = new WebDriverWait(time.UNIT.inSECONDS, 30);
//		wait.until(ExpectedConditions(isDisplayed(),driver.findElementById(id)))
//		
//		}
//	}
}
