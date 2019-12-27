package com.alex.game.world;

import java.awt.Graphics;

import com.alex.game.blocks.Block;
import com.alex.libraries.Position;

public class World {

	// x y z
	private Block[][][] blocks;

	public World() {
		blocks = new Block[10][10][1];
	}

	public void setBlock(Position position, Block block) {
		blocks[(int) position.x][(int) position.y][(int) position.z] = block;
		block.setPosition(position);
		block.update(this);
	}

	public Block getBlock(Position position) {
		try {
			Block block = blocks[(int) position.x][(int) position.y][(int) position.z];
			return block;
		} catch (Exception e) {
			System.out.println("Block out of bounds");
		}

		return null;
	}

	public void render(Graphics g) {
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				for (int k = 0; k < blocks[0][0].length; k++) {
					Block block = blocks[i][j][k];

					if (block != null) {
						System.out.println("render");
						block.render(g);
					}
				}
			}
		}
	}
}
