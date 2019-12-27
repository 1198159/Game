package com.alex.game.world;

import com.alex.game.Commons;
import com.alex.game.blocks.GrassBlock;
import com.alex.game.blocks.StoneBlock;

public class Chunk implements Commons {
	public Block blocks = null;
	public GrassBlock[][][] grassBlocks = null;
	public StoneBlock[][][] stoneBlocks = null;

	public Chunk() {
		for(GrassBlock[][] i : grassBlocks) {
			
		}
	}

}
