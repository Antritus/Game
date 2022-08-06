package eventtodo;

public @interface Handler {
	EventPriority priority() default EventPriority.MEDIUM;

	boolean ignoreCancelled() default false;
}
