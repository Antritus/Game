package eventtodo;

public interface Listener {
	public void triggerEvent();
	public boolean isCancelled();
}
