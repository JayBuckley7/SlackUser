package com.Katas.Slack;

import java.util.Scanner;

public class Main {
	/****
	 * Written just as a way to test it from the snapshot
	 * Austensibly the point of this jar would actually be so the it could be refrenced as an api extension \
	 * I don't beleive this was part of the kata
	 * 
	 * @author TheJ
	 */
	
	//
	//http://aeirola.github.io/slack-irc-client/
	//by clicking generate token and selecting a workspace you are logged into
	
	//ID can be obtained by clicking on a member n the workspace and selecting MemberID
	
	public static void main(String[] args) {
		String Token = "xoxp-";
		String ID = "";
		Scanner in = new Scanner(System.in);
		System.out.println("you can get a token for your workspace here");
		System.out.println("http://aeirola.github.io/slack-irc-client/");
		System.out.print("Please enter in a Slack Token for your workspace: ");
		Token = in.nextLine();
		System.out.println("\nID can be obtained by clicking on a member n the workspace and selecting MemberID");
		System.out.print("Please enter in a Slack Member ID in this workspace: ");
		ID = in.nextLine();
		SlackUser su = new SlackUser(Token,ID);
		System.out.println("\nSlack user info--------------");
		System.out.println("Profile name: "+ su.getProfileName());
		System.out.println("Real name: "+ su.getRealNamePretty());
		System.out.println("Team ID: "+ su.getTeamID());
		System.out.println("Time Zone: "+su.getTimeZonePretty());
		System.out.println("Email: "+su.getEmail());
		System.out.println("Is_Admin?: "+su.getIsAdmin());
		System.out.println("Is_Owner?: "+su.getIsOwner());
		System.out.println("Is_Primary_Owner?: "+su.getIsPrimaryOwner());
		System.out.println("Is_Bot?: "+su.getIsBot());
		
		
		
		
		
		

	}

}
