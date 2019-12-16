package com.oroarmor.lwjgl;

import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.opengl.GL11.glViewport;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public abstract class Game {

	protected String name;
	protected Window window;

	private long frames;
	private long startTime;

	private int frameRateCounts = 60;
	private ArrayList<Long> frameLengths = new ArrayList<Long>(frameRateCounts);

	public Game(String name, int width, int height) {
		this.name = name;
		window = new Window(name, width, height, true);
		initalizeGame();
	}

	private void initalizeGame() {
		GL.createCapabilities();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		startTime = System.currentTimeMillis();

		glfwSetMouseButtonCallback(window.getWindowHandle(), getMouseHandler());
		glfwSetKeyCallback(window.getWindowHandle(), getKeyHandler());
	}

	public void runGame() {
		while (!window.windowShouldClose()) {
			long frameStartTime = getEllapsedMillis();

			GL11.glClearColor(1, 1, 1, 0);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

			if (window.isResized()) {
				glViewport(0, 0, window.getWidth(), window.getHeight());
				window.setResized(false);
			}

			gameTick();
			window.update();

			frames++;
			frameLengths.add(0, getEllapsedMillis() - frameStartTime);
			if (frameLengths.size() > frameRateCounts) {
				frameLengths.remove(frameRateCounts);
			}
		}
	}

	protected abstract void gameTick();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void endGame() {

	}

	public long getFrames() {
		return frames;
	}

	public double getFrameRate() {
		long past100Frames = 0;
		for (long frameLength : frameLengths) {
			past100Frames += frameLength;
		}
		return 1000d / (past100Frames / (double) frameRateCounts);
	}

	public long getEllapsedMillis() {
		return (System.currentTimeMillis() - startTime);
	}

	public abstract GLFWMouseButtonCallback getMouseHandler();

	public abstract GLFWKeyCallback getKeyHandler();
}
