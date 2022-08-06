package eventtodo;

public abstract class Event {
	private String name;
	public Event(Event event, String eventName) {
	}


	private void triggerEvent() {
		for (Listener listener;;){
		}
	}

	public String getEventName() {
		if (name == null) {
			return getClass().getSimpleName();
		}
		return name;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
