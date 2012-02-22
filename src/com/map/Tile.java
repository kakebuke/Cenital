package com.map;

import java.util.Random;

public class Tile {
	public static final int TYPE_GROUND = 0;
	public static final int TYPE_WATER = 1;
	
	private int type;
	private boolean walkable;
	
	public Tile() 
	{
		Random rand = new Random();
		type = rand.nextInt(2);
		defineWalkable();		
	}
	
	public Tile(int type) {
		this.type = type;
		defineWalkable();
	}
	
	private void defineWalkable() {
		if (type == TYPE_GROUND) {
			walkable = true;
		} else {
			walkable = false;
		}
	}
		
	public int getType() {
		return type;
	}
	
	public boolean getWalkable() {
		return this.walkable;
	}
}
