package com.alan.gfg.utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

import com.alan.gfg.utils.files.TextFile;

public class Updater {
	private static String currentVersion, newVersion;
	public static int update = 0;
	
	public static void checkForUpdate(boolean isAuto){
		currentVersion = TextFile.readFile("./version.txt");
	
		try{
			URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/version.txt");
			ReadableByteChannel rbc = Channels.newChannel(site.openStream());
			FileOutputStream fos = new FileOutputStream("./version.txt");
			fos.getChannel().transferFrom(rbc, 0, 1 << 24);
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		newVersion = TextFile.readFile("./version.txt");
		
		if(currentVersion.equals(newVersion)){
			if(!isAuto){
				doNotUpdate();
				return;
			}else{
				Object[] options = 
					{
							"Update",
							"Do Not Update"
					};
				
				int temp = JOptionPane.showOptionDialog(null, "An update was found for Twisted Dream (Current version: " + currentVersion + " new version: " + newVersion + "Update might take some time\nA window will pop up when it is complete", "Updater", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(temp == 1){
					return;
				} else{
					TextFile.writeFile("./version.txt", newVersion);
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/textures/Player/player.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/textures/Player/player.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/textures/Tiles/hall.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/textures/Tiles/hall.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/textures/Tiles/homeec.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/textures/Tiles/homeec.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/textures/levels/test.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/textures/levels/test.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/settings/config.xml");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/textures/settings/config.xml");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu/options_b.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu/options_b.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu/options_b1.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu/options_b1.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu/play_b.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu/play_b.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}

					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu/play_b1.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu/play_b1.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}

					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu/exit_b.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu/exit_b.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}

					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu/exit_b1.png");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu/exit_b1.png");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}

					try{
						URL site = new URL("https://raw.githubusercontent.com/TehTechGuy1/Twist/master/Twisted%20Dream/res/menu_image.jpg");
						ReadableByteChannel rbc = Channels.newChannel(site.openStream());
						FileOutputStream fos = new FileOutputStream("/menu_image.jpg");
						fos.getChannel().transferFrom(rbc, 0, 1 << 24);
						fos.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					
					finishUpdate();
					return;
				}
			}
			
			
		}
	}
	
	private static void finishUpdate(){
		JOptionPane.showMessageDialog(null, "Game has been updated to" + newVersion + "\nGame will now close", "Update Complete", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	private static void doNotUpdate(){
		JOptionPane.showMessageDialog(null, "No update found :(", "Updater", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
}
