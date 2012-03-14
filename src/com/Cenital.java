package com;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.map.Map;

import constants.Assets;

public class Cenital implements ApplicationListener {
	
	public static WorldMap worldMap;
	public static Camera cam;
	public static Assets assets;
	
	private SpriteBatch batch;	
	private InputHandler inputHandler;
	
	private Map mapArray;
	public static Actor player;
	
	public void create() {
		cam = Camera.getInstance();
		batch = new SpriteBatch();
		inputHandler = InputHandler.getInstance();
		assets = Assets.getInstance();
		
		mapArray = new Map();
		player = new Actor();
	}

	public void dispose() {
		
	}

	public void pause() {
		
	}

	public void render() {		  
		cam.updateCamera();
        batch.setProjectionMatrix(cam.getProjectionMatrix());        
        //worldMap.draw(batch, Gdx.graphics.getDeltaTime()); 
        try {
			mapArray.draw(batch);
			player.draw(batch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void resize(int arg0, int arg1) {
		
	}

	public void resume() {
		
	}
}
