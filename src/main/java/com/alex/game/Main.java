package com.alex.game;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import com.oroarmor.lwjgl.Display;
import com.oroarmor.lwjgl.GLFWManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Game Function");

		long window = Display.CreateDisplay(400, 400, "Test");

		while (!glfwWindowShouldClose(window)) {
			glfwPollEvents();
		}

		Display.destroyDisplay(window);
		GLFWManager.deinitalize();
	}

}
