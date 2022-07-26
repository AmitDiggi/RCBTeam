package team.rcb.qa.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJsonData {


    public JsonObject readJsonElementInOrder(String fileName) throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		String filePath = null;
		
		filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + fileName;
		
		JsonElement root = (new JsonParser()).parse(new FileReader(filePath));
		JsonObject jsonObject = root.getAsJsonObject();
		
		return jsonObject;
	}	
}
