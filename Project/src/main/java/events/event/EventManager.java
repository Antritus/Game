package events.event;

import util.panelextenions.ACAlert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.EventListener;
import java.util.HashMap;

public class EventManager {
    ACAlert acAlert = new ACAlert();
    private final HashMap<String, EventContainer> events = new HashMap<>();

    public EventManager() {
    }

    public void registerEvents(EventListener instance, Class clazz) {
        Class<? extends EventListener> iClass = instance.getClass();

        for (Method method : iClass.getMethods()) {
            if (method.getAnnotations().length == 0) {
                continue;
            }

            boolean isEvent = false;
            for (Annotation an : method.getAnnotations()) {
                if (an.annotationType().getName().equals(EventHandler.class.getName())) {
                    isEvent = true;
                    break;
                }
            }

            if (isEvent) {
                if (method.getParameterTypes().length != 1) {
                    acAlert.errorMessage("EVENT HANDLER - METHOD FOUND (FAIL: INVALID PARAMETERS par(Method: +" + method.getName() + "))");
                }
                Class<?> pt = method.getParameterTypes()[0];

                if (!events.containsKey(pt.getName())) {
                    events.put(pt.getName(), new EventContainer());
                }

                events.get(pt.getName()).add(instance.getClass().getName(), method.getName());
            }
        }
    }

    public void fireEvent(Event event) {
        if (!events.containsKey(event.getClass().getName())) {
            return;
        }
        events.get(event.getClass().getName()).fire(event);
    }
}
