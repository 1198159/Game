package com.alex.game.blocks;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alex.game.Commons;
import com.alex.libraries.Size;
import com.alex.libraries.SpriteSheet;

public class Grass extends Block implements Commons{
	
	//textures
	private SpriteSheet textures;
	
	//filepath
	private String path = "src\\main\\resources\\images\\simplegrass.png";
	
	//size
	private Size size = new Size(Commons.BLOCKSIZE);
	
	//blockstates
	public enum BlockState {
		NEUTRAL, DROPDOWN, NEXT_TO_WALL, DROPDOWN_AND_NEXT_TO_WALL;
	}
	
	//current blockstate
	public BlockState currentState = BlockState.NEUTRAL;
	
	public Grass() {
		init();
	}
	
	//for resourcepacks
	public Grass(String filePath) {
		this.path = filePath;
		init();
	}
	
	//set textures
	public void init() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textures = new SpriteSheet(img, 2, 2, size);
	}
	
	//choose which image to use
	
	public void update() {
		
	}
	
	@Override
	public void setImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImages(Image[] images) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
