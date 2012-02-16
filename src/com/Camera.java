package com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import constants.Config;

public class Camera {
	private static Camera camera;
	private static OrthographicCamera cam;
	
	private Rectangle glViewport;
	
	private Camera() {
		cam = new OrthographicCamera(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		cam.position.set(Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2, 0);
		glViewport = new Rectangle(0,0,Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
	}
	
	public static Camera getInstance() {
		if (camera == null) {
			camera = new Camera();
		}		
		return camera;
	}
	
	
	/**
	 * Moves the camera to face the given position, smoothly and taking care of the boundaries of the world
	 * @param position
	 */
	public static void moveTo(Vector2 position) {
		
	}
	
	public OrthographicCamera getCamera() {
		return cam;
	}
	
	public void updateCamera() {
		GL10 gl = Gdx.graphics.getGL10();
		
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glViewport(
        	(int) glViewport.x, (int) glViewport.y,
            (int) glViewport.width, (int) glViewport.height
        );
        cam.update();
        cam.apply(gl);
	}
	
	public Matrix4 getProjectionMatrix() {
		return cam.combined;
	}
}
