package com.english.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonFilter extends HttpFilter {

    public static final String APPLICATION_JSON = "application/json";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getContentType().equals(APPLICATION_JSON)) {
            response.setContentType(APPLICATION_JSON);
            super.doFilter(request, response, chain);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
