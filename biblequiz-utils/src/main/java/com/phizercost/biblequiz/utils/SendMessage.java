package com.phizercost.biblequiz.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendMessage {
	
	
	public void broadcast(String receiver, String message) throws Exception {
		
		message = URLEncoder.encode(message, "UTF-8");
		String url = "http://41.186.58.22:20503/cgi-bin/sendsms?username=lacazette&password=tolavologe2121&from=QUIZ&to="+receiver+"&text="+message+"&smsc=smsc1&mclass=0";

		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		//con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		/*System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);*/

		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println(response.toString());

	}

}
