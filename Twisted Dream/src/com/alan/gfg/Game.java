package com.alan.gfg;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.alan.gfg.entity.mob.Player;
import com.alan.gfg.graphics.Screen;
import com.alan.gfg.input.Keyboard;
import com.alan.gfg.input.Mouse;
import com.alan.gfg.level.Level;
import com.alan.gfg.level.TileCoord;
import com.alan.gfg.qui.Launcher;
import com.alan.gfg.qui.Options;

//This game is made for Gaisca, an Irish version of the president's award, follow the progress of this app @ theonewhodoesstuff.blogger.com
//I hope to have a new version out every week but that doesn't mean visible stuff, mainly background work.

public class Game extends Canvas implements Runnable{
	//Game res = 16:9
	private static final long serialVersionUID = 1L;
	public static int width = 1024;
	public static int height = 576;
	public static int scale = 3;
	public static String title = "Twisted Dream";
	
	public static int w = 1024;
	public static int h = 576;
	
	private Thread thread;
	
	private boolean running = false;
	
	private JFrame frame;
	
	private Screen screen;
	private Keyboard key;
	private Level level;
	private Player player;
	
	static Launcher launcher;
	
	public static int selection = 0;
	
	private static BufferedImage image = new BufferedImage(1024, 576, BufferedImage.TYPE_INT_RGB);
    public static int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size = new Dimension(1024 / 3 * scale, 576 / 3 * scale);
		setPreferredSize(size);
		
		screen = new Screen(1024, 576);
		key = new Keyboard();
		level = Level.spawn;
		TileCoord playerSpawn = new TileCoord(139, 71);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		player.init(level);
		frame = new JFrame();
		Mouse mouse = new Mouse();
		
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static Launcher getInstance(){
		if(launcher == null){
			launcher = new Launcher(0);
		}
		return launcher;
	}
	
	public static int getGameWidth(){
	//	w = Options.w;
		width = w / 3;
		return width;
	}
	
	public static int getGameHeight(){
		//h = Options.h;
		height = h / 3;
		return height;
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try {
			//join = stop
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick(){
		key.update();
		player.update();
	}
	
	
	
	public void render(){
		System.out.println("X: " + player.x + " Y: " + player.y);
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
	//	screen.renderSheet(40, 40, SpriteSheet.player_down, false);
		
		for(int i = 0;i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getGameWidth() * scale, getGameHeight() * scale, null);
		g.dispose();
		
		screen.clear();
	
		bs.show();
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		//while(running) = while(running = true)
		requestFocus();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			//launcher.updateFrame();
			while(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(ticks + " TPS, " + frames + " FPS");
				frame.setTitle(title + ", " + ticks + " TPS, " + frames + " FPS");
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	public static void main(String[] args){
		Game game = new Game();
		getInstance();
	}

}
