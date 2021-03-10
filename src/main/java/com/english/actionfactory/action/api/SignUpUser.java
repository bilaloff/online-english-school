package com.english.actionfactory.action.api;

import com.english.actionfactory.Action;
import com.english.actionfactory.ActionResult;
import com.english.model.User;
import com.english.service.ServiceException;
import com.english.service.UserService;
import com.english.service.impl.UserServiceImpl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class SignUpUser implements Action {

    private static final String BODY = "body";
    private static final String ERROR = "error";

    @Override
    public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        User user = gson.fromJson(request.getAttribute(BODY).toString(), User.class);
        UserService userService = new UserServiceImpl();
        try {
            userService.signUpUser(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write(new JsonObject().toString());
        } catch (ServiceException e) {
            ResourceBundle errorsBundle = ResourceBundle.getBundle("errors", response.getLocale());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            JsonObject errorResponse = new JsonObject();
            errorResponse.addProperty(ERROR, errorsBundle.getString(e.getMessage()));
            response.getWriter().write(errorResponse.toString());
        }
        return ActionResult.SKIP;
    }
}
