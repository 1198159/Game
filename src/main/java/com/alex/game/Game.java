package com.alex.game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.alex.game.blocks.GrassBlock;
import com.alex.game.world.World;
import com.alex.libraries.Position;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private World world;

	public Game() {
		super();
		setSize(new Dimension(500, 500));
		setVisible(true);

		world = new World();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1; k++) {
					world.setBlock(new Position(i, j, k),
							new GrassBlock(new Position(i, j, k), "/src/main/resources/images/blocks/grass.png"));
				}
			}
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		world.render(g);
	}

}
