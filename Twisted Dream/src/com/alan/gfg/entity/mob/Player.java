package com.alan.gfg.entity.mob;

import com.alan.gfg.graphics.AnimatedSprite;
import com.alan.gfg.graphics.Screen;
import com.alan.gfg.graphics.Sprite;
import com.alan.gfg.graphics.SpriteSheet;
import com.alan.gfg.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	private boolean walku = false;
	private boolean walkd = false;
	private boolean walkr = false;
	private boolean walkl = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 2);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 2);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 2);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 2);
	
	private AnimatedSprite animSprite = down;
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		animSprite = down;
	}
	
	public Player(Keyboard input){
		this.input = input;
	}
	
	public void update(){
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		int xa = 0, ya = 0;
		if(anim < 7500) anim++;
		else anim = 0;
		if(input.up && !walkl && !walkr) {
			walku = true;
			ya--; 
			animSprite = up;
		}else if(input.down && !walkl && !walkr){
			walkd = true;
			ya++;
			animSprite = down;
		}
		else{
			walku = false;
			walkd = false;
		}
		if(input.left && !walku && !walkd){
			walkl = true;
			xa--;
			animSprite = left;
		}else if(input.right && !walku && !walkd){
			walkr = true;
			xa++;
			animSprite = right;
		}
		else{
			walkr = false;
			walkl = false;
		}
		if(xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		}else if(xa == 0 && ya == 0){
			walking = false;
		}
		else{
		walking = false;
		}
	}
	
	public void render(Screen screen){
		sprite = animSprite.getSprite();
		screen.renderPlayer(x - 16, y - 16, sprite);
	}
}
