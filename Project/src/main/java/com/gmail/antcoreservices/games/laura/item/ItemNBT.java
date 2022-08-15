package com.gmail.antcoreservices.games.laura.item;

import com.google.gson.*;

import java.util.ArrayList;

public class ItemNBT {
	private ItemStack itemStack;
	public ItemNBT(ItemStack itemStack) {
		this.itemStack = itemStack;
	}
	public ItemNBT() {
	}
	public String getNBT() {
		JsonObject object = new JsonObject();
		object.addProperty("Material", itemStack.getMaterial().toString());
		if (itemStack.getItemMeta().hasDisplayName()) {
			object.addProperty("DisplayName", itemStack.getItemMeta().getName());
		}
		JsonArray array = new JsonArray();
		if (itemStack.getItemMeta().hasLore() && itemStack.getItemMeta().getLore().getLore().size() > 0) {
			for (String line : itemStack.getItemMeta().getLore().getLore()){
				array.add(line);
			}
			object.add("Lore", array);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(object);
		return json;
	}

	public ItemStack getItemStackFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		ItemStack itemStack = new ItemStack(Material.valueOf(jsonObject.get("Material").getAsString()));
		if (jsonObject.has("DisplayName")) {
			itemStack.getItemMeta().setDisplayName(jsonObject.get("DisplayName").getAsString());
		}
		if (jsonObject.has("Lore")) {
			ArrayList<String> lore = new ArrayList<>();
			for (JsonElement element : jsonObject.getAsJsonArray("Lore")) {
				lore.add(element.getAsString());
			}
			itemStack.getItemMeta().getLore().setLore(lore);
		}
		return itemStack;
	}
	public Material getMaterialFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		return Material.valueOf(jsonObject.get("Material").getAsString());
	}
	public ArrayList<String> getLoreFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		if (jsonObject.has("Lore")) {
			ArrayList<String> lore = new ArrayList<>();
			for (JsonElement element : jsonObject.getAsJsonArray("Lore")) {
				lore.add(element.getAsString());
			}
			return lore;
		}
		return null;
	}
	public String getDisplayNameFromNBT(String nbt) {
		JsonElement jsonElement = JsonParser.parseString(nbt);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		if (jsonObject.has("DisplayName")) {
			return jsonObject.get("DisplayName").getAsString();
		}
		return null;
	}
}
