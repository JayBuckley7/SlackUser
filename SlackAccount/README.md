# [SlackUserInfoPuller]

**Authors:** Jacob Buckley 
<pre>
While there is a Main.class that can pull a tiny bit of info from a cli given token and member ID
The Idea is to use the compiled Jar as an extendable object for the Slack user.info API
https://api.slack.com/methods/users.info
</pre>

## Instruction to use the main
<pre>
git clone https://github.com/JayBuckley7/SlackUser
cd SlackUser/SlackAccount/
mvn clean install   
java -jar ./target/SlackAccount-0.0.1-SNAPSHOT.jar 
</pre>

## Instruction to use as extension
<pre>
    // create a new "slack user"
    //call supported methods to get info
    //supports every property listed in the https://api.slack.com/methods/users.info API doc    
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
</pre>

## Sample output
<pre>
you can get a token for your workspace here
http://aeirola.github.io/slack-irc-client/
Please enter in a Slack Token for your workspace: xoxp-*********-***********-***********-****************

ID can be obtained by clicking on a member n the workspace and selecting MemberID
Please enter in a Slack Member ID in this workspace: UL*******

Slack user info--------------
Profile name: buckley_jay
Real name: Jay
Team ID: TL6ASNB7G
Time Zone: Eastern Daylight Time
Email: buckley_Jay@yahoo.com
Is_Admin?: true
Is_Owner?: true
Is_Primary_Owner?: true
Is_Bot?: false
</pre>
