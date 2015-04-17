package com.alan.gfg.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	protected SpriteSheet sheet;
	int width, height;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.enviro);
	public static Sprite carpet = new Sprite(16, 1, 0, SpriteSheet.enviro);
	public static Sprite wall1 = new Sprite(16, 2, 0, SpriteSheet.enviro);
	public static Sprite wall2 = new Sprite(16, 3, 0, SpriteSheet.enviro);
	public static Sprite wall3 = new Sprite(16, 4, 0, SpriteSheet.enviro);
	public static Sprite wall4 = new Sprite(16, 5, 0, SpriteSheet.enviro);
	public static Sprite cwall1 = new Sprite(16, 6, 0, SpriteSheet.enviro);
	public static Sprite cwall2 = new Sprite(16, 7, 0, SpriteSheet.enviro);
	public static Sprite cwall3 = new Sprite(16, 8, 0, SpriteSheet.enviro);
	public static Sprite cwall4 = new Sprite(16, 9, 0, SpriteSheet.enviro);
	public static Sprite Void = new Sprite(16, 0xff000000);
	//hall spritesheet
	public static Sprite hwall1 = new Sprite(16, 0, 1, SpriteSheet.hall);
	public static Sprite hwall2 = new Sprite(16, 1, 0, SpriteSheet.hall);
	public static Sprite hwall3 = new Sprite(16, 1, 2, SpriteSheet.hall);
	public static Sprite hwall4 = new Sprite(16, 5, 3, SpriteSheet.hall);
	public static Sprite hcwall1 = new Sprite(16, 0, 0, SpriteSheet.hall);
	public static Sprite hcwall2 = new Sprite(16, 0, 2, SpriteSheet.hall);
	public static Sprite hcwall3 = new Sprite(16, 0, 3, SpriteSheet.hall);
	public static Sprite hcwall4 = new Sprite(16, 5, 2, SpriteSheet.hall);
	public static Sprite floor = new Sprite(16, 2, 0, SpriteSheet.hall);
	public static Sprite floorv = new Sprite(16, 2, 1, SpriteSheet.hall);
	public static Sprite floorh = new Sprite(16, 2, 2, SpriteSheet.hall);
	public static Sprite con11 = new Sprite(16, 1, 3, SpriteSheet.hall);
	public static Sprite con12 = new Sprite(16, 2, 3, SpriteSheet.hall);
	public static Sprite con21 = new Sprite(16, 3, 3, SpriteSheet.hall);
	public static Sprite con22 = new Sprite(16, 4, 3, SpriteSheet.hall);
	public static Sprite mid1 = new Sprite(16, 3, 0, SpriteSheet.hall);
	public static Sprite mid2 = new Sprite(16, 4, 0, SpriteSheet.hall);
	public static Sprite leftcon = new Sprite(16, 3, 1, SpriteSheet.hall);
	public static Sprite rightcon = new Sprite(16, 3, 2, SpriteSheet.hall);
	public static Sprite botright = new Sprite(16, 4, 2, SpriteSheet.hall);
	public static Sprite topleft = new Sprite(16, 4, 1, SpriteSheet.hall);
	public static Sprite botleft = new Sprite(16, 5, 0, SpriteSheet.hall);
	public static Sprite topright = new Sprite(16, 5, 1, SpriteSheet.hall);
	public static Sprite treshhold = new Sprite(16, 0, 4, SpriteSheet.hall);
	//homeec spritesheet
	public static Sprite vfloor = new Sprite(16, 0, 0, SpriteSheet.homeec);
	public static Sprite table1 = new Sprite(16, 1, 0, SpriteSheet.homeec);
	public static Sprite table2 = new Sprite(16, 2, 0, SpriteSheet.homeec);
	public static Sprite sink1 = new Sprite(16, 3, 0, SpriteSheet.homeec);
	public static Sprite sink2 = new Sprite(16, 0, 1, SpriteSheet.homeec);
	public static Sprite sink3 = new Sprite(16, 1, 1, SpriteSheet.homeec);
	public static Sprite cooker1 = new Sprite(16, 2, 1, SpriteSheet.homeec);
	public static Sprite cooker2 = new Sprite(16, 3, 1, SpriteSheet.homeec);
	public static Sprite counter = new Sprite(16, 0, 2, SpriteSheet.homeec);
	public static Sprite cooker3 = new Sprite(16, 1, 2, SpriteSheet.homeec);
	public static Sprite ttable = new Sprite(16, 2, 2, SpriteSheet.homeec);
	
	public static Sprite player0 = new Sprite(16, 0, 10, SpriteSheet.enviro);
	public static Sprite player1 = new Sprite(16, 1, 10, SpriteSheet.enviro);
	public static Sprite player2 = new Sprite(16, 0, 11, SpriteSheet.enviro);
	public static Sprite player3 = new Sprite(16, 1, 11, SpriteSheet.enviro);
	protected Sprite(SpriteSheet sheet, int width, int height){
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		this.SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	private void setColour(int colour){
		for(int i = 0; i < SIZE*SIZE; i++){
			pixels[i] = colour;
		}
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
