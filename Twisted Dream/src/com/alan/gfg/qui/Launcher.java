package com.alan.gfg.qui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.alan.gfg.Config;
import com.alan.gfg.Game;
import com.alan.gfg.RunGame;
import com.alan.gfg.graphics.Screen;
import com.alan.gfg.input.Mouse;
import com.alan.gfg.utils.Updater;

public class Launcher extends Canvas implements Runnable{
	
	protected JPanel window = new JPanel();
	private JButton play, quit, about, options;
	private Rectangle rplay, rquit, rabout, roptions;
	
	Config config = new Config();
	
	Thread thread;
	
	private int width = 800;
	private int height = 400;
	protected int button_width = 80;
	protected int button_height = 40;
	boolean running = false;
	public JFrame frame = new JFrame();
	Screen screen = new Screen(800, 400);

	public Launcher(int id){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace();
		}
		frame.setUndecorated(true);
		frame.setTitle("GFG Launcher");
		frame.setSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//getContentPane().add(window);
	//	frame.add(game);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		window.setLayout(null);
		
		if(id == 0){
		drawButtons();
		Updater.checkForUpdate(false);
	//	System.out.println("TEST");
		}
		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		startMenu();
		repaint();
	}
	
	public void updateFrame(){
		if(Mouse.dragged){
			Point p = frame.getLocation();
			frame.setLocation(p.x + Mouse.MouseDX - Mouse.MousePX, p.y + Mouse.MouseDY - Mouse.MousePY);
		}
	}
	
	public void startMenu(){
		running = true;
		thread = new Thread(this, "menu");
		thread.start();
	}
	
	public void stopMenu(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void drawButtons(){
		play = new JButton("Play");
		rplay = new Rectangle((width/2) - (button_width/2), 90, button_width, button_height);
		play.setBounds(rplay);
		window.add(play);
		
		about = new JButton("About");
		rabout = new Rectangle((width/2) - (button_width/2), 140, button_width, button_height);
		about.setBounds(rabout);
		window.add(about);
		
		options = new JButton("Options");
		roptions = new Rectangle((width/2) - (button_width/2), 190, button_width, button_height);
		options.setBounds(roptions);
		window.add(options);
		
		quit = new JButton("Quit");
		rquit = new Rectangle((width/2) - (button_width/2), 240, button_width, button_height);
		quit.setBounds(rquit);
		window.add(quit);
		
		play.addActionListener(new ActionListener(){ 
		@Override
		public void actionPerformed(ActionEvent arg0) {
			config.loadConfig("res/settings/config.xml");
			new RunGame();
		}
			
		});
		
		options.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Options();
			}
				
			});
		
		about.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
				
			});
		
		quit.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
				
			});
		
		
		
	}
	
	public void renderMenu() throws IllegalStateException{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,800,400);
		try {
			g.drawImage(ImageIO.read(Game.class.getResource("/menu_image.jpg")), 0, 0 ,800, 400, null);
			
			if(Mouse.mouseX > 690 && Mouse.mouseX < 690 + 80 && Mouse.mouseY > 130 && Mouse.mouseY < 130 + 30){
				g.drawImage(ImageIO.read(Launcher.class.getResource("/menu/play_b1.png")), 690, 130, 80, 30, null);
				if(Mouse.getButton() == 1){
					config.loadConfig("res/settings/config.xml");
					frame.dispose();
					new RunGame();
				}
			}else{
				g.drawImage(ImageIO.read(Launcher.class.getResource("/menu/play_b.png")), 690, 130, 80, 30, null);
			}
			if(Mouse.mouseX > 650 && Mouse.mouseX < 650 + 130 && Mouse.mouseY > 170 && Mouse.mouseY < 170 + 30){
				g.drawImage(ImageIO.read(Launcher.class.getResource("/menu/options_b1.png")), 650, 170, 130, 30, null);
				if(Mouse.getButton() == 1){
					new Options();
				}
			}else{
				g.drawImage(ImageIO.read(Launcher.class.getResource("/menu/options_b.png")), 650, 170, 130, 30, null);
			}
			if(Mouse.mouseX > 690 && Mouse.mouseX < 690 + 80 && Mouse.mouseY > 210 && Mouse.mouseY < 210 + 30){
				g.drawImage(ImageIO.read(Launcher.class.getResource("/menu/exit_b1.png")), 690, 210, 80, 30, null);
				if(Mouse.getButton() == 1){
					System.exit(0);
				}
			}else{
				g.drawImage(ImageIO.read(Launcher.class.getResource("/menu/exit_b.png")), 690, 210, 80, 30, null);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setFont(new Font("Ariel", 0, 20));
		g.dispose();
	
		bs.show();
	}
	
	public void run(){
		while(running){
			updateFrame();
			try{
			renderMenu();
			}catch(IllegalStateException e){
				System.out.println("Caught 'em all");
			}
		}
	}
}
