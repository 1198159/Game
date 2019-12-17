package com.alex.libraries;

public class Size {
	private int w, h;
	//set size
	public Size(int w, int h) {
		this.w = w;
		this.h = h;
	}
	//set size if sprite is a square
	public Size(int w_h) {
		this.w = w_h;
		this.h = w_h;
	}
	//get size
	public Size getSize() {
		return this;
	}
	//get individual width and height
	public int getHeight() {
		return this.h;
	}
	public int getWidth() {
		return this.w;
	}
	

}
