package SatellitData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
		String LOCATION = "Sao paulo,BR";
		String urlString = "https://api.openweathermap.org/data/2.5/weather?q= "+LOCATION+"&appid="+API_KEY+"&lang=pt&units=metric";
	
	
	 try {
		 StringBuilder result = new StringBuilder();
		 URL url = new URL(urlString);
		 URLConnection conn = url.openConnection();
		 BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		 String line;
		 while((line = rd.readLine()) != null) {
			 result.append(line);
		 }
		 
		 rd.close();
		 System.out.println(result);
		 
		 
		 Map<String, Object> respMap = jsonToMap(result.toString());
		 Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
		 Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
		 
		 System.out.println("Atual Temperatura :"+ mainMap.get("temp"));
		 System.out.println("Atual Humidade :"+ mainMap.get("humidity"));
		 System.out.println("Velocidade dos ventos :"+ windMap.get("deg"));
		 
	 }catch (IOException e) {
		 System.out.println(e.getMessage());
  	}
	 
	}
 
}
