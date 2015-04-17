package com.alan.gfg.qui;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.alan.gfg.Config;
import com.alan.gfg.Game;

public class Options{
	
	private Choice res = new Choice();
	
	private int width = 550;
	private int height = 450;
	public static int w = 1024;
	public static int h = 576;
	protected int button_width = 80;
	protected int button_height = 40;
	
	private JButton OK;
	private JTextField twidth, theight;
	private JLabel lwidth, lheight;
	private Rectangle rKO, rres;
	
	JFrame frame = new JFrame();
	JPanel window = new JPanel();
	Config config = new Config();

	public Options(){
		frame.setTitle("Options");
		frame.setSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null);
		frame.add(window);
		frame.setVisible(true);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		window.setLayout(null);
		
		draw();
		frame.repaint();
	}
	
	private void draw(){
		OK = new JButton("OK");
		rKO = new Rectangle(width - 100, height - 70, button_width, button_height - 10);
		OK.setBounds(rKO);
		window.add(OK);
		
		rres = new Rectangle(50, 80, 80, 25);
		res.setBounds(rres);
		res.add("1024 * 576");
		res.add("1280 * 720");
		res.select(0);
		window.add(res);
		
		
		lwidth = new JLabel("Width");
		lwidth.setBounds(28, 150, 120, 20);
		lwidth.setFont(new Font("Verdana", 0, 15));
		window.add(lwidth);
		
		lheight = new JLabel("Height");
		lheight.setBounds(30, 180, 120, 20);
		lheight.setFont(new Font("Verdana", 0, 15));
		window.add(lheight);
		
		twidth = new JTextField();
		twidth.setBounds(80, 150, 60, 20);
		window.add(twidth);
		
		theight = new JTextField();
		theight.setBounds(80, 180, 60, 20);
		window.add(theight);
		
		OK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new Launcher(0);
				config.saveConfig("width", parseWidth());
				config.saveConfig("height", parseHeight());
				
			
			}
			
		});
	}
	
	private void drop(){
		Game.selection = res.getSelectedIndex();
		
		if(Game.selection == 0){
			w = 1024;
			h = 576;
		}
		if(Game.selection == 1){
			w = 1280;
			h = 720;
		}
		
	}
	protected int parseWidth(){
		try{
		int w = Integer.parseInt(twidth.getText());
		return w;
		}catch(NumberFormatException e){
			drop();
			return w;
		}
	}
	
	protected int parseHeight(){
		try{
		int h = Integer.parseInt(theight.getText());
		return h;
		}catch(NumberFormatException e){
			drop();
			return h;
		}
	}
}
