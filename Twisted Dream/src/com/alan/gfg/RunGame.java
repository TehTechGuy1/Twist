package com.alan.gfg;

import javax.swing.JFrame;

import com.alan.gfg.qui.Launcher;

public class RunGame {
 
	public RunGame(){
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.add(game);
		frame.setSize(Game.getGameWidth() * 3, Game.getGameHeight() * 3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		stopMenuThread();
		
	}
	
	private void stopMenuThread(){
		Game.getInstance().stopMenu();
	}
}
