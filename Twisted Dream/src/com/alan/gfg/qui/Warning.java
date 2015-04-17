package com.alan.gfg.qui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.alan.gfg.Game;

public class Warning extends Launcher{
	
	private int width = 250;
	private int height = 100;
	
	private JButton back, go;
	private Rectangle rback, rgo;
	private JLabel string;
	
	Options options = new Options();
	
	public Warning(){
		super(2);
		frame.setTitle("WARNING! - wrong screen ration");
		frame.setSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null);
		
		draw();
		
		repaint();
	}
	
	public void draw(){
		back = new JButton("Go Back");
		rback = new Rectangle(70, 60, 80, 30);
		back.setBounds(rback);
		window.add(back);
		
		go = new JButton("Proceed");
		rgo = new Rectangle(250 - 90, 60, 80, 30);
		go.setBounds(rgo);
		window.add(go);
		
		go.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				
				frame.dispose();
				new Launcher(0);
				config.saveConfig("width", options.parseWidth());
				config.saveConfig("height", options.parseHeight());
			
				
			}
			
		});
		
	}

}
