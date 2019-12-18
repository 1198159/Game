package com.alex.game.blocks;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alex.game.Commons;
import com.alex.game.Items.Item;
import com.alex.libraries.Position;
import com.alex.libraries.Size;
import com.alex.libraries.SpriteSheet;

public class GrassBlock extends Block implements Commons {

	private static final int DURABILITY_VALUE = 1;

	// filepath
	private String path = "src\\main\\resources\\images\\simplegrass.png";
	// size
	private Size size = new Size(Commons.BLOCKSIZE);

	public GrassBlock(Position position, SpriteSheet image, int durability) {
		super(position, image, DURABILITY_VALUE, BlockType.NORMAL, ToolType.SWORD, ToolLevel.ALL, LightLevel.NONE);
	}

	public GrassBlock(Position position, String imagePath, int durability) {
		super(position, imagePath, DURABILITY_VALUE, BlockType.NORMAL, ToolType.SWORD, ToolLevel.ALL, LightLevel.NONE);
	}

	@Override
	protected void update() {
		
	}

	@Override
	protected SpriteSheet loadTexture(String imagePath) {
		SpriteSheet textures;
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textures = new SpriteSheet(img, 2, 2, size);

		return textures;
	}

	@Override
	public Item getItem() {
		return new Item(); // Switch eventually to a grass block item
	}

}
