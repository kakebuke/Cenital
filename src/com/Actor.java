package com;

import com.Cenital;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Actor {
	
	protected int x;
	protected int y;
	protected float speed = 160.0f;
		
	public void draw(SpriteBatch batch) throws Exception {
		Texture actorTexture = new Texture(Gdx.files.internal(Cenital.assets.getAsset("player")));
		
		batch.begin();
		batch.draw(actorTexture, this.x, this.y);
		batch.end();
	}
	
	public void moveUp() {
		this.y += Gdx.graphics.getDeltaTime() * this.speed + 1;
	}
	
	public void moveDown() {
		this.y -= Gdx.graphics.getDeltaTime() * this.speed + 1;
	}
	
	public void moveRight() {
		this.x += Gdx.graphics.getDeltaTime() * this.speed + 1;
	}
	
	public void moveLeft() {
		this.x -= Gdx.graphics.getDeltaTime() * this.speed + 1;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
