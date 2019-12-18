package com.alex.libraries;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class SpriteSheet {

	// individual sprites
	public Image[][] sprites;

	// dimension of sprite
	public Size size;

	// create a new sheet
	public SpriteSheet(BufferedImage spriteSheet, int rows, int columns, Size spriteSize) {

		sprites = new Image[rows][columns];
		this.size = spriteSize;

		sprites = convertToIndividualSprites(spriteSheet, rows, columns, spriteSize);

	}

	// set individual sprites
	public Image[][] convertToIndividualSprites(BufferedImage sheet, int rows, int columns, Size spriteSize) {
		Image[][] localSprites = new Image[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				localSprites[i][j] = sheet.getSubimage(j * spriteSize.getWidth(), i * spriteSize.getHeight(),
						spriteSize.getWidth(), spriteSize.getHeight());
			}
		}
		return localSprites;
	}

	public Image[][] getSheet() {
		return sprites;
	}

}
