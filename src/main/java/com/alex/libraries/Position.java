package com.alex.libraries;

public class Position {
	public float x, y, z;

	public Position(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public Position addPosition(float x, float y, float z) {
		return new Position(this.x + x, this.y + y, this.z + z);
	}

	public Position addPosition(Position other) {
		return addPosition(other.x, other.y, other.z);
	}

}
