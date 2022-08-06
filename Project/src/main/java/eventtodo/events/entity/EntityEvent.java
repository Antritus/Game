package eventtodo.events.entity;

import entity.Entity;
import eventtodo.Event;

public class EntityEvent extends Event {
	private final Entity entity;


	public EntityEvent(Entity entity, String eventName, Event event) {
		super(event, eventName);
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}
}
