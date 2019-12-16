package com.alex.game;

import com.oroarmor.lwjgl.Game;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Main Game Function");
		Game game = new AlexGame("Game", 1920 / 2, 1080 / 2);
		game.runGame();
		game.endGame();
	}
}
