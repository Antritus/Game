package com.gmail.antcoreservices.games.laura.item;

import java.util.ArrayList;

public class ItemLore {
	private final ItemStack itemStack;
	private ArrayList<String> lore = new ArrayList<>();


	public ItemLore(ItemStack itemStack) {
		this.itemStack = itemStack;
	}
	public ArrayList<String> getLore() {
		return lore;
	}
	public void setLore(ArrayList<String> lore) {
		this.lore = lore;
	}
	public void deleteLore() {
		this.lore.clear();
	}
	public void insertLine(int i, String loreLine) {
		ArrayList<String> newLore = lore;
		for (int line = 0; line < lore.size(); i++) {
			if (line == i) {
				newLore.add(loreLine);
				line++;
			}
			newLore.add(lore.get(line));
		}
		lore.clear();
		lore.addAll(newLore);
	}
	public void removeLine(int i) {
		ArrayList<String> newLore = lore;
		for (int line = 0; line < lore.size(); i++) {
			if (line == i) {
				continue;
			}
			newLore.add(lore.get(line));
		}
		lore.clear();
		lore.addAll(newLore);
	}
}