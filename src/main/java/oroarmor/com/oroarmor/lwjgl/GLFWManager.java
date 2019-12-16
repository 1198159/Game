package com.oroarmor.lwjgl;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;

import org.lwjgl.glfw.GLFWErrorCallback;

public class GLFWManager {
	private static boolean intialized = false;

	public static void init() {
		if (intialized) {
			return;
		}

		intialized = true;

		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");
	}

	public static void deinitalize() {
		intialized = false;

		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
}
