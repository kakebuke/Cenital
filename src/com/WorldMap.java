package com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import constants.Assets;
import constants.GameData;

public class WorldMap {
	private static final int SCROLLING_UP = 0;
	private static final int SCROLLING_DOWN = 2;
	private static final int SCROLLING_RIGHT = 3;
	private static final int SCROLLING_LEFT = 4;
	
	private static final float TIME_SCROLLING = 1.5f; //seconds
	
	private Texture texture;
	private Sprite map;
	private Assets assets = Assets.getInstance();
	private Vector2 pos;
	private SpriteBatch batch;
	private boolean scrolling;
	private int scrollDirection;
	private Vector2 origin;
		
	public WorldMap() throws Exception {
		texture = new Texture(Gdx.files.internal(assets.getAsset("map")));
		map = new Sprite (texture, GameData.WORLD_WIDTH, GameData.WORLD_HEIGTH);
		pos = new Vector2();
		scrolling = false;
	}
	
	public void draw(SpriteBatch batch, float deltaTime) {
		this.batch = batch;
		
		if (scrolling) {
			setScrollPosition(deltaTime);
		}
		
		batch.begin();
        batch.draw(map, pos.x, pos.y);
        batch.end();
	}
	
	private void setScrollPosition(float deltaTime) {
		float speed;
		int despl;
		Vector2 end = new Vector2(origin.x + GameData.SCREEN_WIDTH, origin.y + GameData.SCREEN_HEIGHT);
		
		switch (scrollDirection) {
			case SCROLLING_UP:
				speed = GameData.SCREEN_WIDTH / TIME_SCROLLING;
				if (pos.y + GameData.WORLD_HEIGTH > origin.y + GameData.SCREEN_HEIGHT) {
					pos.y -= speed * deltaTime;
					if (pos.y >= end.y) {
						scrolling = false;
					}
				}
				break;
		}
		
	}

	public void handleInput(int key) {
		//scrollMap(key);
		moveMap(key);
	}
	
	private void moveMap(int key) {		
		switch (key)
		{
			case Keys.UP:
				if (pos.y + GameData.WORLD_HEIGTH > GameData.SCREEN_HEIGHT) {
					pos.y -= GameData.TILE_HEIGHT;
				}
				break;
			case Keys.DOWN:
				if (pos.y < 0) {
					pos.y += GameData.TILE_HEIGHT;
				}
				break;
			case Keys.RIGHT:
				if (pos.x + GameData.WORLD_WIDTH > GameData.SCREEN_WIDTH) {
					pos.x -= GameData.TILE_WIDTH;
				}
				break;
			case Keys.LEFT:
				if (pos.x < 0) {
					pos.x += GameData.TILE_WIDTH;
				}
				break;
		}
	}
	
	private void scrollMap(int key) {
		scrolling = true;
		origin = pos;
		switch (key)
		{
			case Keys.UP:
				scrollDirection = SCROLLING_UP;
				break;
			case Keys.DOWN:
				scrollDirection = SCROLLING_DOWN;
				break;
			case Keys.RIGHT:
				scrollDirection = SCROLLING_RIGHT;
				break;
			case Keys.LEFT:
				scrollDirection = SCROLLING_LEFT;
				break;
			default:
				break;
		}
	}
}
