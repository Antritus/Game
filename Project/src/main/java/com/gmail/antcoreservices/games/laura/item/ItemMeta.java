package com.gmail.antcoreservices.games.laura.item;

import com.gmail.antcoreservices.games.laura.util.TextUtility;


public class ItemMeta {
	private final ItemStack itemStack;
	private ItemLore itemLore;
	private String name;
	private String displayName;
	private int durability;


	public ItemMeta(ItemStack itemStack) {
		this.itemStack = itemStack;
		String name = itemStack.getMaterial().name();
		TextUtility textUtility = new TextUtility(name.replace("_", " "));
		textUtility.setAsStrictPascalCase();
		name = textUtility.get();
		itemLore = new ItemLore(itemStack);
	}
	public boolean hasLore() {
		return itemLore.getLore() != null;
	}
	public boolean hasDisplayName(){
		return displayName != null;
	}

	public void setDisplayName(String name) {
		this.displayName = name;
	}
	public String getName() {
		return displayName;
	}
	public ItemLore getLore() {
		return this.itemLore;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public void removeDurability(int durability) {
		this.durability = this.durability-durability;
	}
	public void addDurability(int durability) {
		this.durability = this.durability+durability;
	}
	public int getDurability() {
		return durability;
	}
}
