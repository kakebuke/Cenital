package constants;

import java.util.HashMap;

public class Assets {
	private static Assets assetsInstance;
	
	private HashMap assets;	

	private Assets() {
		this.assets = new HashMap();
		
		assets.put("map", "map.png");
	}
	
	public static Assets getInstance() 
	{
		if (assetsInstance == null) {
			assetsInstance = new Assets();
		}
		return assetsInstance;
	}
	
	public String getAsset(String assetName) throws Exception {
		String name;
		if (this.assets.containsKey(assetName))
		{
			name = (String) this.assets.get(assetName);
		}
		else
		{
			throw new Exception("The asset " + assetName + " doesn't exist");
		}
		return name;
	}	
}
