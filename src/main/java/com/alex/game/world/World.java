package com.alex.game.world;

public class World {
	
	//chunks
	private Chunk[][] chunks = null;
	
	public World(int chunkRows, int chunkColumns) {
		 chunks = new Chunk[chunkRows][chunkColumns];
	}

}
