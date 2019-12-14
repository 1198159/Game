package com.alex.game;

import com.oroarmor.lwjgl.Display;
import com.oroarmor.lwjgl.Game;
import com.oroarmor.lwjgl.textures.Texture;
import com.oroarmor.lwjgl.textures.TextureLoader;

public class AlexGame extends Game {

	TextureLoader loader = new TextureLoader();
	Texture testImage;

	public AlexGame(String name, int width, int height) {
		super(name, width, height);
		testImage = loader.getTexture("src/main/resources/images/test.png");
	}

	@Override
	protected void gameTick() {
		System.out.println(getFrameRate());
		Display.renderTexture(testImage, -0.5, -0.5, 1, 1, 0, 0, 1, 1);
	}
}
