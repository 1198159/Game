package com.oroarmor.lwjgl;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;

import com.oroarmor.lwjgl.textures.Texture;

public class Display {
	public static long CreateDisplay(int width, int height, String windowName) {
		GLFWManager.init();
		long window;
		window = glfwCreateWindow(width, height, windowName, NULL, NULL);
		if (window == NULL)
			throw new RuntimeException("Failed to create the GLFW window");

		try (MemoryStack stack = stackPush()) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);

			glfwGetWindowSize(window, pWidth, pHeight);

			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
		}

		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);
		glfwShowWindow(window);

		return window;
	}

	public static void destroyDisplay(long window) {
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
	}

	public static void renderTexture(Texture texture, double x, double y, double w, double h, double tx, double ty,
			double tw, double th) {

		texture.bind();

		glBegin(GL11.GL_QUADS);

		glVertex2d(x, y);
		glTexCoord2d(tx, ty);

		glVertex2d(x, y + h);
		glTexCoord2d(tx + tw, ty);

		glVertex2d(x + w, y + h);
		glTexCoord2d(tx + tw, ty + th);

		glVertex2d(x + w, y);
		glTexCoord2d(tx, ty + th);

		glEnd();
	}

	public static void clear() {
		GL11.glColor4f(1, 0, 1, 1);
		glBegin(GL11.GL_QUADS);
		glVertex2d(-1, -1);
		glVertex2d(1, -1);
		glVertex2d(1, 1);
		glVertex2d(-1, 1);
		glEnd();
	}
}
