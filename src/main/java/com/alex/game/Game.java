package com.alex.game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.alex.game.blocks.GrassBlock;
import com.alex.libraries.Position;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Game() {
		super();
		setSize(new Dimension(500, 500));
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());

		GrassBlock block = new GrassBlock(new Position(200, 200, 0), "/src/main/resources/images/blocks/grass.png", 10);
		GrassBlock block2 = new GrassBlock(new Position(100, 100, 0), "/src/main/resources/images/blocks/grass.png",
				10);
		block.render(g);
		block2.render(g);
	}

}
