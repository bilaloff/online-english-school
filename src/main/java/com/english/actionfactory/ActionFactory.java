package com.english.actionfactory;

import com.english.actionfactory.action.api.FindUserByEmail;
import com.english.actionfactory.action.api.SignUpUser;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ActionFactory {

    private static final Map<String, Action> actionMap = new HashMap<>();
    private static final ActionFactory INSTANCE = new ActionFactory();

    static {
        /* APIs */
        actionMap.put("POST/api/user/email", new FindUserByEmail());
        actionMap.put("POST/api/user/add", new SignUpUser());
    }

    private ActionFactory(){}

    public static ActionFactory getInstance() {
        return INSTANCE;
    }

    public Action getAction(HttpServletRequest request) {
        String method = request.getMethod();
        String servletPath = request.getServletPath();
        String path = Objects.requireNonNullElse(request.getPathInfo(), "/");
        return actionMap.get(method.concat(servletPath).concat(path));
    }
}
