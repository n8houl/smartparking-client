import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class APIClient {
	public static Garage getAllSpots(String garage) throws IOException {
		URL url = new URL("http://localhost:3000/spots/" + garage.substring(0, 1).toUpperCase() + "" + garage.substring(1).toLowerCase());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		output = br.readLine();
		String[] objects = output.split("}");
		ArrayList<JSObject> objList = new ArrayList<JSObject>();
		for (String s : objects) {
			if (s.length() < 2)
				continue;
			objList.add(Parser.parse(s));
		}

		JSObject[] objs = objList.toArray(new JSObject[objList.size()]);

		conn.disconnect();
		
		return new Garage(objs, garage.substring(0, 1).toUpperCase() + "" + garage.substring(1).toLowerCase());
	}

	public static Spot getSpot(String garage, int id) throws IOException {
		URL url = new URL("http://localhost:3000/spots/" + garage.substring(0, 1).toUpperCase() + "" + garage.substring(1).toLowerCase() + "/" + String.format("%04d", id));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		output = br.readLine();
		String[] objects = output.split("}");
		ArrayList<JSObject> objList = new ArrayList<JSObject>();
		for (String s : objects) {
			if (s.length() < 2)
				continue;
			objList.add(Parser.parse(s));
		}

		conn.disconnect();
		
		return new Spot(objList.get(0));
	}
}
