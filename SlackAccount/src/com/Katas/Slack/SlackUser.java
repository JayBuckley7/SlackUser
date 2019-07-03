package com.Katas.Slack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class SlackUser extends AIOUser {

	private String Token;
	private String ID;

	public SlackUser(String Token, String UserID) {
		super("", "", "");

		this.Token = Token;
		this.ID = UserID;
	}

	public String Do() {
		String qry = "https://slack.com/api/users.info?token=" + this.Token + "&user=" + this.ID + "&pretty=1";
		URL obj;
		try {
			obj = new URL(qry);
			HttpURLConnection con;
			try {
				con = (HttpURLConnection) obj.openConnection();
				// optional default is GET
				con.setRequestMethod("GET");
				// add request header
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				int responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + qry);
				System.out.println("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print in String
				System.out.println(response.toString());
				// Read JSON response and print
				try {
					Gson gson=new Gson();
					JSONObject myResponse = new JSONObject(response.toString());
					InfoResponce userIdentifier = gson.fromJson(myResponse.toString(), InfoResponce.class);
					String pause = "";
					return response.toString();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("result after Reading JSON Response");
				// System.out.println("statusCode- "+myResponse.getString("statusCode"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "FAILED!";
		
	}
}
