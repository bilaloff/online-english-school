package com.english.controller;

import com.english.factory.Action;
import com.english.factory.ActionFactory;
import com.english.factory.ActionResult;
import com.english.factory.Direction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class FrontController extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionFactory factory = ActionFactory.getInstance();
        Action action = factory.getAction(request);
        if(Objects.nonNull(action)){
            ActionResult actionResult = action.execute(request, response);
            Direction direction = actionResult.getDirection();
            if (direction == Direction.FORWARD) {
                request.getRequestDispatcher(actionResult.getPage())
                        .forward(request, response);
            } else if (direction == Direction.REDIRECT) {
                response.sendRedirect(request.getContextPath().concat(actionResult.getPage()));
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
