package com.map;

import java.util.Iterator;
import com.Cenital;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;

import constants.Config;

public class Map {
	private Tile mapArray[][];
	
	public Map() {
		Array loadedMap = loadMapData();
		int j = 0;
		if (loadedMap.size > 0) {
			for (int i = 0; i < loadedMap.size; i++) {
				Array row = (Array) loadedMap.get(i);
				if (mapArray == null) {
					mapArray = new Tile[loadedMap.size][row.size];
				}
				Iterator it = row.iterator();
				while (it.hasNext()) {
					mapArray[i][j] = new Tile((int)Float.parseFloat(it.next().toString()));
					j++;
				}
				j = 0;
			}
		}
	}
	
	public void draw(SpriteBatch batch) throws Exception {
		Texture mapTilesTexture = new Texture(Gdx.files.internal(Cenital.assets.getAsset("mapTiles")));
		TextureRegion[][] mapTiles = TextureRegion.split(mapTilesTexture, 32, 32);
		
		batch.begin();
		for (int i = 0; i < mapArray.length; i++) {
			for (int j = 0; j < mapArray[i].length; j++) {
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
