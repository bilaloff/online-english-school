package com.english.actionfactory.action.api;

import com.english.actionfactory.Action;
import com.english.actionfactory.ActionResult;
import com.english.dao.impl.UserDaoImpl;
import com.english.model.User;
import com.english.service.ServiceException;
import com.english.service.UserService;
import com.english.service.impl.UserServiceImpl;
import com.google.gson.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class FindUserByEmail implements Action {

    private static final String BODY = "body";
    private static final String EMAIL = "email";

    @Override
    public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        String body = request.getAttribute(BODY).toString();
        JsonObject object = JsonParser.parseString(body).getAsJsonObject();
        String email = object.get(EMAIL).getAsString();
        UserService userService = new UserServiceImpl();
        try {
            Optional<User> optionalUser = userService.getUserByEmail(email);
            if (optionalUser.isPresent()) {
                response.getWriter().write(gson.toJson(optionalUser.get()));
            } else {
                response.getWriter().write(new JsonObject().toString());
            }
        } catch (ServiceException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return ActionResult.SKIP;
    }

}
