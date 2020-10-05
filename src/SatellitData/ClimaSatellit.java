package SatellitData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ClimaSatellit {
     
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType()
		);
		return map;
	}
	
	public static void main(String[] args) {
		String API_KEY = "b10a74f0720e974fc75a3e2bd810094e";
		String LOCATION = "Raleigh,NC";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units-imperial";
	}
	
	 
 
}
