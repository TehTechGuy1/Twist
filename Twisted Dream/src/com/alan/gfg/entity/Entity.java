package com.alan.gfg.entity;

import java.util.Random;

import com.alan.gfg.graphics.Screen;
import com.alan.gfg.level.Level;

public class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected  final Random ran = new Random();
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}

}
