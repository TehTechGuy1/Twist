package com.alan.gfg.graphics;

public class AnimatedSprite extends Sprite {
	
	private int frame = 0;
	private Sprite sprite;
	private int rate = 5;
	private int length = -1;
	private int time = 0;

	public AnimatedSprite(SpriteSheet sheet, int width, int height, int length){
		super(sheet, width, height);
		this.length = length;
		sprite = sheet.getSprite()[0];
		if(length > sheet.getSprite().length) System.err.println("Issues");
	}
	
	public void update(){
		time++;
		System.out.println(time % rate);
		if(time % rate == 2){
		if(frame >= length - 1) frame = 0;
		else frame++;
		sprite = sheet.getSprite()[frame];
		}
		System.out.println(sprite + ": , Frame: " + frame);
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public void setFrameRate(int frames){
		rate = frames;
	}
	
	public void setFrame(int index){
		if(index > sheet.getSprite().length - 1) return;
		sprite = sheet.getSprite()[index];
	}
}
