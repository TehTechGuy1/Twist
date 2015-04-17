package com.alan.gfg.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alan.gfg.level.tile.Tile;

public class SpawnLevel extends Level{

	public SpawnLevel(String path){
		super(path);
	}
	
	protected void loadLevel(String path){
		try{
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		}catch(IOException e){
			System.out.println("You fucking suck!");
			e.printStackTrace();
		}
	}
	
	//wall1 = b8b0c2
	//wall2 = 9991a2
	//wall3 = 706b76
	//wall4 = 2a292c
	//carpet = 0000ff
	//grass = 00ff00
	protected void generateLevel(){
	
	}
}
