package com.alex.game;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.oroarmor.lwjgl.Display;
import com.oroarmor.lwjgl.Game;
import com.oroarmor.lwjgl.textures.Texture;
import com.oroarmor.lwjgl.textures.TextureLoader;

public class AlexGame extends Game {

	TextureLoader loader = new TextureLoader();
	Texture testImage;

	private int numRepeats = 1;

	public AlexGame(String name, int width, int height) {
		super(name, width, height);
		testImage = loader.getTexture("src/main/resources/images/test2.png");
	}

	@Override
	protected void gameTick() {
		System.out.println(getFrameRate());
//		Display.clear();
		for (int i = 0; i < numRepeats; i++) {
			for (int j = 0; j < numRepeats; j++) {
				Display.renderTexture(testImage, -1 + (float) 2 / numRepeats * i, -1 + (float) 2 / numRepeats * j,
						(float) 2 / numRepeats, (float) 2 / numRepeats, 0, 0, 1, 1);
			}
		}
	}

	@Override
	public GLFWMouseButtonCallback getMouseHandler() {
		return new GLFWMouseButtonCallback() {
			@Override
			public void invoke(long window, int button, int action, int mods) {
				if (action == GLFW.GLFW_PRESS) {
					numRepeats++;
				}
			}
		};
	}
}
