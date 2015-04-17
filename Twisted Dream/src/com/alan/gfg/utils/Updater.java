package com.alan.gfg.utils;

import com.alan.gfg.utils.files.TextFile;

public class Updater {
	private static String currentVersion, newVersion;
	public static int update = 0;
	
	public static void checkForUpdate(boolean isAuto){
		currentVersion = TextFile.readFile("./version.txt");
	}
}
