package com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import constants.Assets;
import constants.Config;

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
	private int despl = 0;
	private int maxDespl = 0;
		
	public WorldMap() throws Exception {
		texture = new Texture(Gdx.files.internal(assets.getAsset("map")));
		map = new Sprite (texture, Config.WORLD_WIDTH, Config.WORLD_HEIGTH);
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
		if (maxDespl == 0) {
			Gdx.app.log("DEBUG", "GameData.WORLD_HEIGTH + pos.y = " + (Config.WORLD_HEIGTH + pos.y));
			maxDespl = (int) (Math.min(Config.WORLD_HEIGTH + pos.y, Config.SCREEN_HEIGHT));
		}		
		Gdx.app.log("DEBUG", "" + maxDespl + ", " + pos.y);
		speed = Config.SCREEN_HEIGHT / TIME_SCROLLING;

		switch (scrollDirection) 
		{
			case SCROLLING_UP:				
				if (pos.y + Config.WORLD_HEIGTH > origin.y + Config.SCREEN_HEIGHT) {
					pos.y -= speed * deltaTime;
					despl += (int) (speed * deltaTime);
					if (despl >= maxDespl) {
						stopScrolling();
					}
				}
			break;
		}
	}
		
	private void stopScrolling()
	{
		scrolling = false;
		despl = 0;
		maxDespl = 0;
	}

	public void handleInput(int key) {
		scrollMap(key);
		//moveMap(key);
	}
	
	private void moveMap(int key) {		
		switch (key)
		{
			case Keys.UP:
				if (pos.y + Config.WORLD_HEIGTH > Config.SCREEN_HEIGHT) {
					pos.y -= Config.TILE_HEIGHT;
				}
				break;
			case Keys.DOWN:
				if (pos.y < 0) {
					pos.y += Config.TILE_HEIGHT;
				}
				break;
			case Keys.RIGHT:
				if (pos.x + Config.WORLD_WIDTH > Config.SCREEN_WIDTH) {
					pos.x -= Config.TILE_WIDTH;
				}
				break;
			case Keys.LEFT:
				if (pos.x < 0) {
					pos.x += Config.TILE_WIDTH;
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
