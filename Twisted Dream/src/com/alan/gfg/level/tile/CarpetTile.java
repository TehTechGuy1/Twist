package com.alan.gfg.level.tile;

import com.alan.gfg.graphics.Screen;
import com.alan.gfg.graphics.Sprite;

public class CarpetTile extends Tile{
	
	public CarpetTile(Sprite sprite){
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
