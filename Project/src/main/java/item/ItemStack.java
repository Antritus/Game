package item;

import java.awt.image.BufferedImage;

public class ItemStack {
	private Material material;
	private ItemMeta itemMeta;
	private ItemNBT itemNBT;
	private BufferedImage itemImage;

	public ItemStack(String nbt) {
		ItemNBT itemNBT = new ItemNBT();
		this.material = itemNBT.getMaterialFromNBT(nbt);
		itemMeta = new ItemMeta(this);
		this.itemNBT = new ItemNBT(this);
		itemMeta.setDisplayName(itemNBT.getDisplayNameFromNBT(nbt));
		itemMeta.getLore().setLore(itemNBT.getLoreFromNBT(nbt));
	}
	public ItemStack(Material material) {
		this.material = material;
		itemMeta = new ItemMeta(this);
		itemNBT = new ItemNBT(this);
	}
	public Material getMaterial() {
		return material;
	}
	public ItemMeta getItemMeta() {
		return itemMeta;
	}
	public BufferedImage getItemImage() {
		return itemImage;
	}
	public String getItemNBT() {
		return itemNBT.getNBT();
	}
	public boolean hasItemMeta() {
		if (itemMeta.hasLore()){
			return true;
		}
		if (itemMeta.hasDisplayName()){
			return true;
		}
		return false;
	}
}