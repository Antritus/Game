package com.gmail.antcoreservices.games.laura.events.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventContainer {
        private final HashMap<String, String> methods = new HashMap<>();

        public void add(String path, String method)
        {
            methods.put(path, method);
        }

        public void fire(Event event)
        {
            for (String path : methods.keySet()) {
                try {
                    Class<?> c = Class.forName(path);
                    Object t = c.newInstance();
                    String a = methods.get(path);
                    Method m = null;

                    for (Method lm : c.getMethods()) {
                        if (lm.getName().equals(a)) {
                            m = lm;
                        }
                    }

                    if (m != null) {
                        m.setAccessible(true);
                        m.invoke(t, event);
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException | InstantiationException ex) {
                    Logger.getLogger(EventContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }