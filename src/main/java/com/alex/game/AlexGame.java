package com.alex.game;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.oroarmor.lwjgl.Game;
import com.oroarmor.lwjgl.shader.Vingette;
import com.oroarmor.lwjgl.textures.Texture;
import com.oroarmor.lwjgl.textures.TextureLoader;

public class AlexGame extends Game {

	private TextureLoader loader = new TextureLoader();
	private Texture testImage;
	Vingette vingette;

	private int numRepeats = 1;

	public AlexGame(String name, int width, int height) throws Exception {
		super(name, width, height);
		testImage = loader.getTexture("src/main/resources/images/grassTextures.png");
		testImage.setWidth(16);
		testImage.setHeight(16);
		testImage.setTextureHeight(16);
		testImage.setTextureWidth(16);

		vingette = new Vingette(0.2f);
		vingette.init();

	}

	@Override
	protected void gameTick() {
		System.out.println(getFrameRate());
		vingette.render();
	}

	@Override
	public GLFWMouseButtonCallback getMouseHandler() {
		return new GLFWMouseButtonCallback() {
			@Override
			public void invoke(long window, int button, int action, int mods) {
				if (action == GLFW.GLFW_PRESS) {
					numRepeats += (button == GLFW.GLFW_MOUSE_BUTTON_LEFT) ? 1 : -1;
					if (numRepeats == 0) {
						numRepeats = 1;
					}
				}
			}
		};
	}

	@Override
	public GLFWKeyCallback getKeyHandler() {
		return new GLFWKeyCallback() {
			@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {
				if (action == GLFW.GLFW_PRESS) {
					if (key == GLFW.GLFW_KEY_SPACE) {
						numRepeats--;
						if (numRepeats == 0) {
							numRepeats = 1;
						}
					}
				}
				if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE)
					glfwSetWindowShouldClose(window, true);
			}
		};
	}
}
