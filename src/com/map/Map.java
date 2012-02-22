package com.map;

import java.util.Scanner;

import com.Cenital;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;

import constants.Config;

public class Map {
	private Tile mapArray[][];
	
	private int[][] hardcodedMap = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	
	public Map() {
		Array loadedMap = loadMapData();
		if (loadedMap.size > 0) {
			for (int i = 0; i < loadedMap.size; i++) {
				Array row = (Array) loadedMap.get(i);
			}
		}
		mapArray = new Tile[hardcodedMap.length][hardcodedMap[0].length];
		
		for (int i = 0; i < hardcodedMap.length; i++) {
			for (int j = 0; j < hardcodedMap.length; j++) {
				mapArray[i][j] = new Tile(hardcodedMap[i][j]);
			}
		}
	}
	
	public void draw(SpriteBatch batch) throws Exception {
		Texture mapTilesTexture = new Texture(Gdx.files.internal(Cenital.assets.getAsset("mapTiles")));
		TextureRegion[][] mapTiles = TextureRegion.split(mapTilesTexture, 16, 16);
		
		batch.begin();
		for (int i = 0; i < mapArray.length; i++) {
			for (int j = 0; j < mapArray.length; j++) {
				batch.draw(mapTiles[0][mapArray[i][j].getType()], i * Config.TILE_WIDTH, j * Config.TILE_HEIGHT);
			}
		}
		batch.end();
	}
	
	public Array loadMapData() {
		JsonReader json = new JsonReader();
		Object o = json.parse(Gdx.files.internal("maps/map01.map"));
		return (Array) o;
	}
}
