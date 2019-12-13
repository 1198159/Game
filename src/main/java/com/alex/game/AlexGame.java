package com.alex.game;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;

import org.lwjgl.opengl.GL11;

import com.oroarmor.lwjgl.Game;
import com.oroarmor.lwjgl.textures.Texture;
import com.oroarmor.lwjgl.textures.TextureLoader;

public class AlexGame extends Game {

	TextureLoader loader = new TextureLoader();
	Texture test;

	public AlexGame(String name, int width, int height) {
		super(name, width, height);

//		try {
//			test = loader.getTexture("Game/src/main/resources/images/test.png");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	protected void gameTick() {

		System.out.println(getFrameRate());

//		test.bind();
		GL11.glColor4f(1, 0, 0, 1);

		glBegin(GL11.GL_QUADS);
		glVertex2d(-0.5, -0.5);
		glVertex2d(-0.5, 0.5);
		glVertex2d(0.5, 0.5);
		glVertex2d(0.5, -0.5);
		glEnd();
	}

}
