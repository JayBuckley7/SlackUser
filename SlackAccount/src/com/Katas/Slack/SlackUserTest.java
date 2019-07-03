package com.Katas.Slack;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlackUserTest {

public String Token = "xoxp-686366759254-684233443141-686367346326-481c0719f775b2353e102fad842dab44";
public String ID = "UL46VD145";
	@Test
	public void ConstructorTest() {
		SlackUser su = new SlackUser(Token,ID);
		String reply = su.Do();		
		assertEquals(!reply.equalsIgnoreCase("failed!") , true);	
	}
}
