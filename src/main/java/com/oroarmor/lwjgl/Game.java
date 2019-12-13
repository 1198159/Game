package com.oroarmor.lwjgl;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowTitle;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.util.ArrayList;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public abstract class Game {

	private String name;
	private long window;

	private long frames;
	private long startTime;

	private int frameRateCounts = 60;
	ArrayList<Long> frameLengths = new ArrayList<Long>(frameRateCounts);

	public Game(String name, int width, int height) {
		this.name = name;
		window = Display.CreateDisplay(width, height, name);
		initalizeGame();
	}

	private void initalizeGame() {
		GL.createCapabilities();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		startTime = System.currentTimeMillis();
	}

	public void runGame() {
		while (!glfwWindowShouldClose(window)) {

			long frameStartTime = getEllapsedMillis();

			gameTick();
			glfwSwapBuffers(window);
			glfwPollEvents();
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
		glfwSetWindowTitle(window, name);
		this.name = name;
	}

	public void endGame() {
		Display.destroyDisplay(window);
		GLFWManager.deinitalize();
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
}