package com.gmail.antcoreservices.games.laura.main.tile.mapgeneration;

import com.google.gson.*;
import com.gmail.antcoreservices.games.laura.map.TileOld;

public class TileNBT {
	private TileOld tile;

	public TileNBT(TileOld itemStack) {
		this.tile = itemStack;
	}

	public TileNBT() {
	}

	public String getNBT() {
		JsonObject object = new JsonObject();
		object.addProperty("Material", "");
		object.addProperty("Biome", "");
		JsonArray array = new JsonArray();
		object.add("Lore", array);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(object);
		return json;
	}

	public TileOld getTileFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		TileOld tile = new TileOld("");
		tile.getBiome();
		return tile;
	}

	public TileOld getMaterialFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		return new TileOld(jsonObject.getAsString());
	}

}