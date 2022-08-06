package main.tile.mapgeneration;

import com.google.gson.*;
import main.tile.Tile;

public class TileNBT {
	private Tile tile;

	public TileNBT(Tile itemStack) {
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

	public Tile getTileFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		Tile tile = new Tile("");
		tile.getBiome();
		return tile;
	}

	public Tile getMaterialFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		return new Tile(jsonObject.getAsString());
	}

}