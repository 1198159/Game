package com.alex.game.blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alex.game.Commons;

import com.alex.game.items.Item;
import com.alex.game.world.World;
import com.alex.libraries.Position;
import com.alex.libraries.Size;
import com.alex.libraries.SpriteSheet;

public class GrassBlock extends Block implements Commons {

	private static final int DURABILITY_VALUE = 1;

	private GrassBlock(Position position, SpriteSheet image) {

		super(position, image, DURABILITY_VALUE, BlockType.NORMAL, ToolType.SHOVEL, ToolLevel.ALL, LightLevel.NONE);

	}



	public GrassBlock(Position position, String imagePath) {

		super(position, imagePath, DURABILITY_VALUE, BlockType.NORMAL, ToolType.SHOVEL, ToolLevel.ALL, LightLevel.NONE);

	}

	@Override
	public void update(World world) {

	}

	@Override
	protected SpriteSheet loadTexture(String imagePath) {
		SpriteSheet textures;
		BufferedImage img = null;
		try {
			File imageFile = new File(System.getProperty("user.dir") + imagePath);
			img = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		textures = new SpriteSheet(img, 2, 2, new Size(Commons.BLOCKSIZE));

		return textures;
	}

	@Override
	public Item getItem() {
		return new Item(); // Switch eventually to a grass block item
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image.getSheet()[0][0], 50 + (int) position.x * 16, 50 + (int) position.y * 16, null);
	}

}
