package com.english.factory;

import com.english.factory.action.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ActionFactory {

    private static final Map<String, Action> actionMap = new HashMap<>();
    private static final ActionFactory INSTANCE = new ActionFactory();

    static {
    }

    private ActionFactory(){}

    public static ActionFactory getInstance() {
        return INSTANCE;
    }

    public Action getAction(HttpServletRequest request) {
        String method = request.getMethod();
        String path = Objects.requireNonNullElse(request.getPathInfo(), "/");
        return actionMap.get(method.concat(path));
    }
}
