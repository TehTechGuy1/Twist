package com.alan.gfg.level;

import com.alan.gfg.graphics.Screen;
import com.alan.gfg.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel("/textures/levels/test.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		genranlev();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void genranlev() {

	}

	protected void loadLevel(String path) {

	}
	
	protected void generateLevel(){
		
	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
				
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.Void;
			if(tiles[x + y * width] == Tile.col_grass) return Tile.grass;
			if(tiles[x + y * width] == Tile.col_carpet) return Tile.carpet;
			if(tiles[x + y * width] == Tile.col_wall1) return Tile.wall1;
			if(tiles[x + y * width] == Tile.col_wall2) return Tile.wall2;
			if(tiles[x + y * width] == Tile.col_wall3) return Tile.wall3;
			if(tiles[x + y * width] == Tile.col_wall4) return Tile.wall4;
			if(tiles[x + y * width] == Tile.col_cwall1) return Tile.cwall1;
			if(tiles[x + y * width] == Tile.col_cwall2) return Tile.cwall2;
			if(tiles[x + y * width] == Tile.col_cwall3) return Tile.cwall3;;
			if(tiles[x + y * width] == Tile.col_cwall4) return Tile.cwall4;
			if(tiles[x + y * width] == Tile.col_hfloor) return Tile.hfloor;
			if(tiles[x + y * width] == Tile.col_tramv) return Tile.tramv;
			if(tiles[x + y * width] == Tile.col_tramh) return Tile.tramh;
			if(tiles[x + y * width] == Tile.col_tramm1) return Tile.tramm1;
			if(tiles[x + y * width] == Tile.col_tramm2) return Tile.tramm2;
			if(tiles[x + y * width] == Tile.col_hwall1) return Tile.hwall1;
			if(tiles[x + y * width] == Tile.col_hwall2) return Tile.hwall2; 
			if(tiles[x + y * width] == Tile.col_hwall3) return Tile.hwall3; 
			if(tiles[x + y * width] == Tile.col_hwall4) return Tile.hwall4; 
			if(tiles[x + y * width] == Tile.col_hcwall1) return Tile.hcwall1; 
			if(tiles[x + y * width] == Tile.col_hcwall2) return Tile.hcwall2; 
			if(tiles[x + y * width] == Tile.col_hcwall3) return Tile.hcwall3; 
			if(tiles[x + y * width] == Tile.col_hcwall4) return Tile.hcwall4;
			if(tiles[x + y * width] == Tile.col_treshhold) return Tile.treshhold;
			if(tiles[x + y * width] == Tile.col_con11) return Tile.con11;
			if(tiles[x + y * width] == Tile.col_con12) return Tile.con12;
			if(tiles[x + y * width] == Tile.col_con21) return Tile.con21;
			if(tiles[x + y * width] == Tile.col_con22) return Tile.con22;
			if(tiles[x + y * width] == Tile.col_topleft) return Tile.topleft;
			if(tiles[x + y * width] == Tile.col_topright) return Tile.topright;
			if(tiles[x + y * width] == Tile.col_botleft) return Tile.botleft;
			if(tiles[x + y * width] == Tile.col_botright) return Tile.botright;
			if(tiles[x + y * width] == Tile.col_leftcon) return Tile.leftcon;
			if(tiles[x + y * width] == Tile.col_rightcon) return Tile.rightcon;
			if(tiles[x + y * width] == Tile.col_vfloor) return Tile.vfloor;
			if(tiles[x + y * width] == Tile.col_counter) return Tile.counter;
			if(tiles[x + y * width] == Tile.col_table1) return Tile.table1;
			if(tiles[x + y * width] == Tile.col_table2) return Tile.table2;
			if(tiles[x + y * width] == Tile.col_cooker1) return Tile.cooker1;
			if(tiles[x + y * width] == Tile.col_cooker2) return Tile.cooker2;
			if(tiles[x + y * width] == Tile.col_cooker3) return Tile.cooker3;
			if(tiles[x + y * width] == Tile.col_sink1) return Tile.sink2;
			if(tiles[x + y * width] == Tile.col_sink2) return Tile.sink3;
			if(tiles[x + y * width] == Tile.col_sink3) return Tile.sink1;
			if(tiles[x + y * width] == Tile.col_ttable) return Tile.ttable;
			 
			if(tiles[x + y * width] == 0) return Tile.Void;
			return Tile.Void;
		
	}

}
