package com;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import constants.GameData;

public class Cenital implements ApplicationListener, InputProcessor {
	
	private Rectangle glViewport;
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private WorldMap worldMap;
	
	public void create() {
		cam = new OrthographicCamera(GameData.SCREEN_WIDTH, GameData.SCREEN_HEIGHT);
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);		
		
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
		GL10 gl = Gdx.graphics.getGL10();
		glViewport = new Rectangle(0, 0, GameData.SCREEN_WIDTH, GameData.SCREEN_HEIGHT);
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glViewport(
        	(int) glViewport.x, (int) glViewport.y,
            (int) glViewport.width, (int) glViewport.height
        );
        cam.update();
        cam.apply(gl);  
        
        worldMap.draw(batch, Gdx.graphics.getDeltaTime());
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	/*******************
	 * INPUT PROCESSOR
	 * *********/

	public boolean keyDown(int key) {
		worldMap.handleInput(key);
		return false;
	}

	public boolean keyTyped(char key) {
		
		return false;
	}

	public boolean keyUp(int arg0) {
		return false;
	}

	public boolean scrolled(int arg0) {
		return false;
	}

	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}

	public boolean touchDragged(int arg0, int arg1, int arg2) {
		return false;
	}

	public boolean touchMoved(int arg0, int arg1) {
		return false;
	}

	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}
}