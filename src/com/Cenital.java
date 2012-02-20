package com;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cenital implements ApplicationListener {
	
	public static WorldMap worldMap;
	public static Camera cam;
	
	private SpriteBatch batch;	
	private InputHandler inputHandler;
	
	public void create() {
		cam = Camera.getInstance();
		batch = new SpriteBatch();
		inputHandler = InputHandler.getInstance();
				
		
		try {
			worldMap = new WorldMap();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void pause() {
		// TODO Auto-generated method stub
		
	}

	public void render() {		  
		cam.updateCamera();
        batch.setProjectionMatrix(cam.getProjectionMatrix());        
        worldMap.draw(batch, Gdx.graphics.getDeltaTime());        
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
