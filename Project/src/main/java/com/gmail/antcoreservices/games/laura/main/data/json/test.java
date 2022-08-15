package com.gmail.antcoreservices.games.laura.main.data.json;

import com.gmail.antcoreservices.games.laura.item.ItemStack;
import com.gmail.antcoreservices.games.laura.item.Material;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		ItemStack item = new ItemStack(Material.SWORD);
		item.getItemMeta().setDisplayName("ANTRITUS");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Antrittus");
		lore.add("Antrittus");
		lore.add("Testing");
		item.getItemMeta().getLore().setLore(lore);
		System.out.println(item.getItemNBT());

		ItemStack itemStack = new ItemStack(item.getItemNBT());
		System.out.println(itemStack.getItemNBT());

	}
}
