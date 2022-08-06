package eventtodo;

import eventtodo.Event;
import eventtodo.EventException;
import eventtodo.Listener;

public interface EventExecutor {
	public void execute(Listener listener, Event event) throws EventException;
}
