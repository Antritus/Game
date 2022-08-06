package eventtodo;

public enum EventPriority {
	LOWEST(0),
	LOW(1),
	MEDIUM(2),
	HIGH(3),
	MONITOR(4);

	private final int slot;

	private EventPriority(int slot) {
		this.slot = slot;
	}
	public int getSlot() {
		return slot;
	}
}
