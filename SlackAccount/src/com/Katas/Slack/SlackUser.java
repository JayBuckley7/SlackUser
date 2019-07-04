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
	private InfoResponce getResponce;
	private user user;
	private profile profile;

	public SlackUser(String Token, String UserID) {
		super("", "", ""); //could pass in email and stuff in here if we wanted to overide it's old info

		this.Token = Token;
		this.ID = UserID;
		getUserFromResponce(getResponce());
	}
  /***
   * Gets the JSON responce as string into a variable
   * @return
   */
	public String getResponce() {
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
				//System.out.println("\nSending 'GET' request to URL : " + qry);
				//System.out.println("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print in String
				//System.out.println(response.toString());
				return response.toString();
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
	/***
	 * populates the user object based on the Json it's handed
	 * If responce fails a property called error will fill with the error message. 
	 * @param reply 
	 * Valid JsonString reply (get it from getResponce())
	 */
	public void getUserFromResponce(String reply) {
		Gson gson=new Gson();
		JSONObject myResponse;
		try {
			myResponse = new JSONObject(reply);
			this.getResponce = gson.fromJson(myResponse.toString(), InfoResponce.class);
			
			if(this.getResponce.error == null) {			
				this.user = getResponce.user;				
				this.profile = user.profile;					
			}else {
				String str = getResponce.error; 
				//for what I'm doing the switch isnt needed
				//but i could potentially handle them differently if I wanted to
		        switch(str) 
		        { 
		            case "not_authed": 
		                throw new Exception(str);
		            case "invalid_auth": 
		                throw new Exception(str);
		            case "user_not_found": 
		                throw new Exception(str);
		            case "user_not_visible": 
		            	throw new Exception(str);
		            case "account_inactive": 
		            	throw new Exception(str); 
		            case "token_revoked": 
		            	throw new Exception(str);
		            case "no_permission": 
		            	throw new Exception(str);
		            case "org_login_required": 
		            	throw new Exception(str);
		            case "ekm_access_denied": 
		            	throw new Exception(str);
		            case "request_timeout": 
		            	throw new Exception(str); 
		            case "fatal_error": 
		            	throw new Exception(str);		           
		            default: 
		            	throw new Exception("no_match");
		        } 
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception E) {
			//System.out.println(E.getMessage());
		}
		
	}
	
	/**
	 * @return Error message from responce 
	 */
	public String getError() {	
		String val = "SUCCSESS";
		if(this.getResponce.error != null) {
			val = getResponce.error;
		}
		return val;
	}
	
	/**
	 * @return users Slack ID
	 */
	public String getID() {	
		return user.id;
	}
	
	/**
	 * @return the name they use on slack
	 */
	public String getProfileName() {
		return user.name;
	}
	/**
	 * @return the team ID
	 */
	public String getTeamID() {
		return user.team_id;
	}
	
	/**
	 * @return if the user is deleted
	 */
	public boolean isDeleted() {
		return user.deleted;
	}
	/**
	 * @return the the users color
	 */
	public String getColor() {
		return user.color;
	}
	/**
	 * @return users real slack name
	 */
	public String getRealName() {
		return user.real_name;
	}
	
	/**
	 * @return users Time Zone
	 */
	public String getTimeZone() {
		return user.tz;
	}
	/**
	 * @return the users timeZone Stamp
	 */
	public String getTimeZonePretty() {
		return user.tz_label;
	}
	/**
	 * @return the offset for users Time Zone
	 */
	public int getTimeZoneDiff() {
		return Integer.parseInt(user.tz_offset);
	}
	
	/**
	 * @return the users Title or blank string if not available.
	 */
	public String getTitle() {
		return profile.title;
	}
	
	/**
	 * @return the users phone number if available or a blank string if not
	 */
	public String getPhoneNumber() {
		return profile.phone;
	}
	
	/**
	 * @return the skype ID if available or a blank string if not
	 */
	public String getSkype() {
		return profile.skype;
	}
	
	/**
	 * @return the users real name normalized if available or a blank string if not
	 */
	public String getRealNamePretty() {
		return profile.real_name_normalized;
	}
	
	/**
	 * @return the users display name if available or a blank string if not
	 */
	public String getDisplayName() {
		return profile.display_name;
	}
	
	/**
	 * @return the users display name Formatted if available or a blank string if not
	 */
	public String getDisplayNamePretty() {
		return profile.display_name_normalized;
	}
	/**
	 * @return the users Fields if available or a blank string if not
	 */
	public String[] getFields() {
		return profile.fields;
	}
	
	/**
	 * @return the status if available or a blank string if not
	 */
	public String getStatusText() {
		return profile.status_text;
	}
	
	/**
	 * @return the status Emoji Unicode if available or a blank string if not
	 */
	public String getStatusEmojiUnicode() {
		return profile.status_emoji;
	}
	
	/**
	 * @return the hash of the users avatar if available or a blank string if not
	 */
	public String getAvatarHash() {
		return profile.avatar_hash;
	}
	/**
	 * @return the users email if available or a blank string if not
	 */
	public String getEmail() {
		return profile.email;
	}
	
	/**
	 * @return the url of the users original image if available or a blank string if not
	 */
	public String getOriginalImageURL() {
		return profile.image_original;
	}
	/**
	 * @return the url of the users image_24 if available or a blank string if not
	 */
	public String getImage24() {
		return profile.image_24;
	}
	/**
	 * @return the url of the users image_32 if available or a blank string if not
	 */
	public String getImage32() {
		return profile.image_32;
	}
	/**
	 * @return the url of the users image_48 if available or a blank string if not
	 */
	public String getImage48() {
		return profile.image_48;
	}
	/**
	 * @return the url of the users image_72 if available or a blank string if not
	 */
	public String getImage72() {
		return profile.image_72;
	}
	/**
	 * @return the url of the users image_192 if available or a blank string if not
	 */
	public String getImage192() {
		return profile.image_192;
	}
	/**
	 * @return the url of the users image_512 if available or a blank string if not
	 */
	public String getImage512() {
		return profile.image_512;
	}

	/**
	 * @return true if the user is an admin and false otherwise.
	 */
	public Boolean getIsAdmin() {
		return user.is_admin;
	}
	/**
	 * @return true if the user is an Owner and false otherwise.
	 */
	public Boolean getIsOwner() {
		return user.is_owner;
	}
	/**
	 * @return true if the user is an Prime owner and false otherwise.
	 */
	public Boolean getIsPrimaryOwner() {
		return user.is_primary_owner;
	}
	/**
	 * @return true if the user has restriction and false otherwise.
	 */
	public Boolean getIsRestricted() {
		return user.is_restricted;
	}
	/**
	 * @return true if the user is "ultra restricted" and false otherwise.
	 */
	public Boolean getIsUltraRestricted() {
		return user.is_ultra_restrictred;
	}
	/**
	 * @return true if user is a bot and false otherwise.
	 */
	public Boolean getIsBot() {
		return user.is_bot;
	}
	/**
	 * @return some int value maybe related to last update time.
	 */
	public int getUpdated() {
		return user.updated;
	}
	/**
	 * @return true if user has 2FA and false otherwise.
	 */
	public Boolean getHas2FA() {			
		return user.has_2fa;
	}




}
