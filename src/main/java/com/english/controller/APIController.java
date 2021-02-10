package com.english.controller;

import com.english.actionfactory.Action;
import com.english.actionfactory.ActionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

public class APIController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionFactory factory = ActionFactory.getInstance();
        Action action = factory.getAction(request);
        if(Objects.nonNull(action)){
            action.execute(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
