package com.alan.gfg.level.tile;

import com.alan.gfg.graphics.Screen;
import com.alan.gfg.graphics.Sprite;

public class HallTile extends Tile {

	public HallTile(Sprite sprite){
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
