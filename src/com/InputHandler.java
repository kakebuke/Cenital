package com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import constants.Config;

public class InputHandler implements InputProcessor {
	private static InputHandler self;
	
	private InputHandler() {
		Gdx.input.setInputProcessor(this);
	}
	
	public static InputHandler getInstance() {
		if (self == null) {
			self = new InputHandler();
		}
		return self;
	}

	public boolean keyDown(int arg0) {
		
		if (arg0 == Input.Keys.UP) {
			Camera.moveCamera(0, Config.TILE_HEIGHT, 0);
		}
		
		if (arg0 == Input.Keys.DOWN) {
			Camera.moveCamera(0, -Config.TILE_HEIGHT, 0);
		}
		
		if (arg0 == Input.Keys.LEFT) {
			Camera.moveCamera(-Config.TILE_WIDTH, 0, 0);
		}
		
		if (arg0 == Input.Keys.RIGHT) {
			Camera.moveCamera(Config.TILE_WIDTH, 0, 0);
		}
		
		Gdx.app.log("DEBUG","Key= " + arg0 + " X=" + Camera.getX() + " Y=" + Camera.getY());
		
		return false;
	}

	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
