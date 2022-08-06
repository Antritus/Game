package eventtodo;

public class RegisteredListener {
	private final Listener listener;
	private final EventPriority priority;
	private final EventExecutor eventExecutor;
	private final boolean ignoreCancelled;


	public RegisteredListener(Listener listener, EventPriority priority, EventExecutor eventExecutor, boolean ignoreCancelled) {
		this.listener = listener;
		this.priority = priority;
		this.eventExecutor = eventExecutor;
		this.ignoreCancelled = ignoreCancelled;
	}

	public Listener getListener() {
		return listener;
	}

	public EventPriority getPriority() {
		return priority;
	}

	public EventExecutor getEventExecutor() {
		return eventExecutor;
	}

	public boolean isIgnoreCancelled() {
		return ignoreCancelled;
	}

	public void callEvent(final Event event) throws EventException{
		if (event instanceof Cancellable) {
			if (((Cancellable) event).isCancelled() && isIgnoreCancelled()) {
				return;
			}
		}
		eventExecutor.execute(listener, event);
	}
}
