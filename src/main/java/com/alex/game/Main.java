package com.alex.game;

import com.oroarmor.lwjgl.Game;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Game Function");
		Game game = new AlexGame("Game", 400, 400);
		game.runGame();
		game.endGame();
	}

}
