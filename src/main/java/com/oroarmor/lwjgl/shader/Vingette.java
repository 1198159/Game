package com.oroarmor.lwjgl.shader;

import java.nio.FloatBuffer;

import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.opengl.GL30.*;

public class Vingette {

	ShaderProgram vingette;

	private int vaoId;
	private int vboId;

	private float strength;

	public Vingette(float strength) {
		this.strength = strength;
	}

	public void init() throws Exception {
		vingette = new ShaderProgram();
		vingette.createVertexShader("#version 330\r\n" + "\r\n" + "layout (location =0) in vec3 position;\r\n"
				+ "out vec4 pos;\r\n" + "\r\n" + "void main()\r\n" + "{\r\n"
				+ "	gl_Position = vec4(position, 1.0);\r\n" + "	pos = gl_Position;\r\n" + "}");
		vingette.createFragmentShader("#version 330\r\n" + "\r\n" + "in vec4 pos;\r\n" + "\r\n"
				+ "out vec4 fragColor;\r\n" + "\r\n" + "void main()\r\n" + "{\r\n"
				+ "	fragColor = vec4(0, 0,0, (pos.x*pos.x + pos.y*pos.y)*" + strength + ");\r\n" + "}");
		vingette.link();

		float[] vertices = new float[] { 1f, 1f, 0.0f, -1f, -1f, 0.0f, 1f, -1f, 0.0f, //
				1f, 1f, 0.0f, -1f, 1f, 0.0f, -1f, -1f, 0.0f };

		FloatBuffer verticesBuffer = null;
		try {
			verticesBuffer = MemoryUtil.memAllocFloat(vertices.length);
			verticesBuffer.put(vertices).flip();

			// Create the VAO and bind to it
			vaoId = glGenVertexArrays();
			glBindVertexArray(vaoId);

			// Create the VBO and bint to it
			vboId = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, vboId);
			glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
			// Define structure of the data
			glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

			// Unbind the VBO
			glBindBuffer(GL_ARRAY_BUFFER, 0);

			// Unbind the VAO
			glBindVertexArray(0);
		} finally {
			if (verticesBuffer != null) {
				MemoryUtil.memFree(verticesBuffer);
			}
		}
	}

	public void render() {
		vingette.bind();

		// Bind to the VAO
		glBindVertexArray(vaoId);
		glEnableVertexAttribArray(0);

		// Draw the vertices
		glDrawArrays(GL_TRIANGLES, 0, 3);
		glDrawArrays(GL_TRIANGLES, 3, 3);

		// Restore state
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);

		vingette.unbind();
	}

	public void cleanup() {
		if (vingette != null) {
			vingette.cleanup();
		}

		glDisableVertexAttribArray(0);

		// Delete the VBO
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vboId);

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(vaoId);
	}

}
