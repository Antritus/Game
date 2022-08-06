package eventtodo;

import java.util.ArrayList;
import java.util.EnumMap;

public class HandlerList {

	private volatile RegisteredListener[] handlers = null;

	private final EnumMap<EventPriority, ArrayList<RegisteredListener>> handlerSlots;

	private static ArrayList<HandlerList> allLists = new ArrayList<HandlerList>();


	public HandlerList(EnumMap<EventPriority, ArrayList<RegisteredListener>> handlerSlots) {
		this.handlerSlots = handlerSlots;
	}
}
