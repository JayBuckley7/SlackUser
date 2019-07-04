package com.Katas.Slack;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlackUserTest {
//you can get a token for your workspace here
//http://aeirola.github.io/slack-irc-client/
//by clicking generate token and selecting a workspace you are logged into
public String Token = "xoxp- ";
//ID can be obtained by clicking on a member n the workspace and selecting MemberID
public String ID = "UL46VD145";
	@Test
	public void ConstructorTest() {
		SlackUser su = new SlackUser(Token,ID);
		String reply = su.getResponce();		
		
		assertEquals(!reply.equalsIgnoreCase("failed!") , true);	
	}
	@Test
	public void ConstructorTestTokenInvalid() {
		SlackUser su = new SlackUser("aaa",ID);				
		assertEquals(su.getError() , "invalid_auth");		
	}
	@Test
	public void MemberIDTestInvalid() {
		SlackUser su = new SlackUser(Token,"aaa");	
		
		assertEquals(su.getError() , "user_not_found");	
		//assertFalse(b);
	}
	
	@Test
	public void getIDTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getID() , ID);	
	}
	
///*****
	//THE REST OF THESE TEST.... will kinda only work if you happen to be me...
	// If I had someones working project I could potentially use a "known good" version
	// To check against my dev version but that's kinda against the point
	
	//alerternativley I could make it so you could save the xml from the raw user.info xml if you 
	// pulled it from the site...
///*****
	
	@Test
	public void getTeamIDTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getTeamID() , "TL6ASNB7G");	
	}
	
	@Test
	public void getNameTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getProfileName() , "buckley_jay");	
	}
	
	@Test
	public void getDeletedTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.isDeleted() , false);	
	}
	
	@Test
	public void getColorTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getColor() , "9f69e7");	
	}
	
	@Test
	public void getRealNameTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getRealName() , "Jay");	
	}
	@Test
	public void getRealNamePrettyTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getRealNamePretty() , "Jay");	
	}
	@Test
	public void getTimeZoneTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getTimeZone() , "America/New_York");	
	}
	@Test
	public void getTimeZoneLabelTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getTimeZonePretty() , "Eastern Daylight Time");	
	}
	@Test
	public void getTimeZoneOffsetTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getTimeZoneDiff() , -14400);	
	}
	@Test
	public void getTitleTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getTitle() , "");	
	}
	@Test
	public void getPhoneTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getPhoneNumber() , "");	
	}
	@Test
	public void getSkypeTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getSkype() , "");	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void getFieldsTest() {
		SlackUser su = new SlackUser(Token,ID);	
		String[] fields = new String[0];
		assertEquals(su.getFields() , fields);	
	}

	@Test
	public void getStatusTest() {
		SlackUser su = new SlackUser(Token,ID);			
		assertEquals(su.getStatusText() , "");	
	}

	
	
}
