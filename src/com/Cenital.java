package com;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import constants.Config;

public class Cenital implements ApplicationListener, InputProcessor {
	
	private Rectangle glViewport;
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private WorldMap worldMap;
	
	public void create() {
		cam = new OrthographicCamera(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);		
		glViewport = new Rectangle(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		
		cam.position.set(Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2, 0);
		
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
		handleInput();
		GL10 gl = Gdx.graphics.getGL10();
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glViewport(
        	(int) glViewport.x, (int) glViewport.y,
            (int) glViewport.width, (int) glViewport.height
        );
        cam.update();
        cam.apply(gl);  
        batch.setProjectionMatrix(cam.combined);
        
        worldMap.draw(batch, Gdx.graphics.getDeltaTime());
        
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	private void handleInput() {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
                if (cam.position.x > 0)
                        cam.translate(-3, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
                if (cam.position.x < 1024)
                        cam.translate(3, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
                if (cam.position.y > 0)
                        cam.translate(0, -3, 0);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
                if (cam.position.y < 1024)
                        cam.translate(0, 3, 0);
        }
}
	
	/*******************
	 * INPUT PROCESSOR
	 * *********/

	public boolean keyDown(int key) {
		//worldMap.handleInput(key);
			switch (key)
			{
				case Keys.UP:
					cam.translate(0, 16, 0);
					//glViewport.y -= 16;
					//cam.position.set(cam.position.x, cam.position.y + 16, cam.position.z);
					break;
				case Keys.DOWN:
					cam.translate(0, -16, 0);
					//cam.position.set(cam.position.x, cam.position.y - 16, cam.position.z);
					break;
				case Keys.RIGHT:
					cam.translate(16, 0, 0);
					break;
				case Keys.LEFT:
					cam.translate(-16, 0, 0);
					break;
			}
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
