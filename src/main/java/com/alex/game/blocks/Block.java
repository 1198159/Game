package com.alex.game.blocks;

import java.awt.Graphics;

import com.alex.game.Items.Item;
import com.alex.game.world.World;
import com.alex.libraries.Position;
import com.alex.libraries.SpriteSheet;

public abstract class Block {

	// Fields that can change
	public SpriteSheet image;
	public Position position;

	// Fields that are created once
	public int durability;
	public BlockType blockType;
	public ToolType toolType;
	public ToolLevel toolLevel;
	public LightLevel lightLevel;
	public ConnectedBlocks connectedBlocks;

	public Block(Position position, SpriteSheet image, int durability, BlockType blockType, ToolType toolType,
			ToolLevel toolLevel, LightLevel lightLevel) {
		this.image = image;
		this.position = position;
		this.durability = durability;
		this.blockType = blockType;
		this.toolType = toolType;
		this.toolLevel = toolLevel;
		this.lightLevel = lightLevel;
		this.connectedBlocks = ConnectedBlocks.NEUTRAL;
	}

	public abstract void update(World world);

	public Block(Position position, String imagePath, int durability, BlockType blockType, ToolType toolType,
			ToolLevel toolLevel, LightLevel lightLevel) {
		this.image = loadTexture(imagePath);
		this.position = position;
		this.durability = durability;
		this.blockType = blockType;
		this.toolType = toolType;
		this.toolLevel = toolLevel;
		this.lightLevel = lightLevel;
	}

	protected abstract SpriteSheet loadTexture(String imagePath);

	public SpriteSheet getImage() {
		return image;
	}

	public void setImage(SpriteSheet image) {
		this.image = image;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getDurability() {
		return durability;
	}

	public BlockType getBlockType() {
		return blockType;
	}

	public ToolType getToolType() {
		return toolType;
	}

	public ToolLevel getToolLevel() {
		return toolLevel;
	}

	public LightLevel getLightLevel() {
		return lightLevel;
	}

	// public abstract Item getSilkTouchItem(); Only if we do enchanments
	public abstract Item getItem();

	public abstract void render(Graphics g);

	public enum BlockType {
		NORMAL, TILE
	}

	public enum LightLevel {
		NONE, LOW, MEDIUM, HIGH
	}

	public enum ToolType {
		AXE, PICKAXE, SHOVEL, SWORD, SHEARS, NONE
	}

	public enum ToolLevel {
		ALL, WOOD, STONE, IRON, DIAMOND
	}

	public enum ConnectedBlocks {
		NEUTRAL, DROPDOWN, NEXT_TO_WALL, DROPDOWN_AND_NEXT_TO_WALL;
	}
}
