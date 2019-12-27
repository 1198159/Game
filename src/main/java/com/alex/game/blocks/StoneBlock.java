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

public class StoneBlock extends Block implements Commons {

	private static final int DURABILITY_VALUE = 1;

	public StoneBlock(Position position, SpriteSheet image, int durability) {
		super(position, image, DURABILITY_VALUE, BlockType.NORMAL, ToolType.PICKAXE, ToolLevel.ALL, LightLevel.NONE);
	}

	public StoneBlock(Position position, String imagePath, int durability) {
		super(position, imagePath, DURABILITY_VALUE, BlockType.NORMAL, ToolType.PICKAXE, ToolLevel.ALL, LightLevel.NONE);
	}

	protected void update() {

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
		g.drawImage(image.getSheet()[0][1], (int) position.x, (int) position.y, null);
	}

	@Override
	public void update(World world) {
		// TODO Auto-generated method stub
		
	}

}
