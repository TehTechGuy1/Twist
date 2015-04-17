package com.alan.gfg.level;

import java.util.Random;

public class RandomLevel extends Level{
	
	private static final Random ran = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
		
	}
	
	protected void genranlev(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tilesInt[x + y * width] = ran.nextInt(6);
			}
		}
	}

}
