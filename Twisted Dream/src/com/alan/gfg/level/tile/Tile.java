package com.alan.gfg.level.tile;

import com.alan.gfg.graphics.Screen;
import com.alan.gfg.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile carpet = new CarpetTile(Sprite.carpet);
	public static Tile wall1 = new WallTile(Sprite.wall1);
	public static Tile wall2 = new WallTile(Sprite.wall2);
	public static Tile wall3 = new WallTile(Sprite.wall3);
	public static Tile wall4 = new WallTile(Sprite.wall4);
	public static Tile cwall1 = new WallTile(Sprite.cwall1);
	public static Tile cwall2 = new WallTile(Sprite.cwall2);
	public static Tile cwall3 = new WallTile(Sprite.cwall3);
	public static Tile cwall4 = new WallTile(Sprite.cwall4);
	public static Tile hfloor = new HallTile(Sprite.floor);
	public static Tile tramv = new HallTile(Sprite.floorv);
	public static Tile tramh = new HallTile(Sprite.floorh);
	public static Tile tramm1 = new HallTile(Sprite.mid1);
	public static Tile tramm2 = new HallTile(Sprite.mid2);
	public static Tile hwall1 = new WallTile(Sprite.hwall1);
	public static Tile hwall2 = new WallTile(Sprite.hwall2);
	public static Tile hwall3 = new WallTile(Sprite.hwall3);
	public static Tile hwall4 = new WallTile(Sprite.hwall4);
	public static Tile hcwall1 = new WallTile(Sprite.hcwall1);
	public static Tile hcwall2 = new WallTile(Sprite.hcwall2);
	public static Tile hcwall3 = new WallTile(Sprite.hcwall3);
	public static Tile hcwall4 = new WallTile(Sprite.hcwall4);
	public static Tile treshhold = new CarpetTile(Sprite.treshhold);
	public static Tile topright = new HallTile(Sprite.topright);
	public static Tile topleft = new HallTile(Sprite.topleft);
	public static Tile botright = new HallTile(Sprite.botright);
	public static Tile botleft = new HallTile(Sprite.botleft);
	public static Tile con11 = new HallTile(Sprite.con11);
	public static Tile con12 = new HallTile(Sprite.con12);
	public static Tile con21 = new HallTile(Sprite.con21);
	public static Tile con22 = new HallTile(Sprite.con22);
	public static Tile leftcon = new HallTile(Sprite.leftcon);
	public static Tile rightcon = new HallTile(Sprite.rightcon);
	public static Tile vfloor = new CarpetTile(Sprite.vfloor);
	public static Tile table1 = new WallTile(Sprite.table1);
	public static Tile table2 = new WallTile(Sprite.table2);
	public static Tile sink1 = new WallTile(Sprite.sink1);
	public static Tile sink2 = new WallTile(Sprite.sink2);
	public static Tile sink3 = new WallTile(Sprite.sink3);
	public static Tile cooker1 = new WallTile(Sprite.cooker1);
	public static Tile cooker2 = new WallTile(Sprite.cooker2);
	public static Tile counter = new WallTile(Sprite.counter);
	public static Tile cooker3 = new WallTile(Sprite.cooker3);
	public static Tile ttable = new WallTile(Sprite.ttable);
	
	public final static int col_grass = 0xff00ff00;
	public final static int col_carpet = 0xff0000ff;
	public final static int col_wall1 = 0xffb8b0c2;
	public final static int col_wall2 = 0xff9991a2;
	public final static int col_wall3 = 0xff706b76;
	public final static int col_wall4 = 0xff2a292c;
	public final static int col_cwall1 = 0xff212121;
	public final static int col_cwall2 = 0xff333333;
	public final static int col_cwall3 = 0xff3c3c3c;
	public final static int col_cwall4 = 0xff131313;
	public final static int col_hfloor = 0xffffff00;
	public final static int col_tramv = 0xff006900;
	public final static int col_tramh = 0xff00b878;
	public final static int col_tramm1 = 0xff005278;
	public final static int col_tramm2 = 0xffff5278;
	public final static int col_hwall3 = 0xff9a00bf;
	public final static int col_hcwall4 = 0xffa0df00;
	public final static int col_hwall1 = 0xff009f95;
	public final static int col_hcwall1 = 0xff7f4600;
	public final static int col_hwall2 = 0xff3e0060;
	public final static int col_hcwall2 = 0xffffc97f;
	public final static int col_hwall4 = 0xff603200;
	public final static int col_hcwall3 = 0xff20dcff;
	public final static int col_treshhold = 0xffb8b000;
	public final static int col_topright = 0xffffb878;
	public final static int col_topleft = 0xff00bf63;
	public final static int col_botright = 0xff9360ff;
	public final static int col_botleft =  0xff00639f;
	public final static int col_con11 = 0xffff40ab;
	public final static int col_con12 = 0xffdf9e00;
	public final static int col_con21 = 0xffdf0054;
	public final static int col_con22 = 0xff99df00;
	public final static int col_leftcon = 0xffc760ff;
	public final static int col_rightcon = 0xffc7ffff;
	public final static int col_counter = 0xff002600;
	public final static int col_sink3 = 0xff20001b;
	public final static int col_table1 = 0xff0018bf;
	public final static int col_cooker1 = 0xff008700;
	public final static int col_table2 = 0xff0069bf;
	public final static int col_cooker2 = 0xff008761;
	public final static int col_sink1 = 0xff00875e;
	public final static int col_sink2 = 0xff0087ff;
	public final static int col_vfloor = 0xffff793c;
	public final static int col_ttable = 0xffff29;
	public final static int col_cooker3 = 0xffff5229;

	public static Tile Void = new VoidTile(Sprite.Void);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
	}
	
	public boolean solid(){
		return false;
	}

}
