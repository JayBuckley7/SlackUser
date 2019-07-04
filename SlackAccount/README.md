# [SlackUserInfoPuller]

**Authors:** Jacob Buckley 
<pre>
While there is a Main.class that can pull a tiny bit of info from a cli given token and member ID
The Idea is to use the compiled Jar as an extendable object for the Slack user.info API
https://api.slack.com/methods/users.info
</pre>

## Instruction and Use the main
<pre>
git clone https://github.com/JayBuckley7/SlackUser
cd SlackUser/ 
mvn clean install 
java -cp ./target/SlackAccount-0.0.1-SNAPSHOT.jar com.codingdojo.pokerhandskata.Main
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
