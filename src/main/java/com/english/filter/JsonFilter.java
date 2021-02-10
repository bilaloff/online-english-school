package com.english.filter;

import com.mysql.cj.xdevapi.JsonParser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class JsonFilter extends HttpFilter {

    public static final String APPLICATION_JSON = "application/json";
    public static final String BODY = "body";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getContentType().equals(APPLICATION_JSON)) {
            try {
                request.setAttribute(BODY, JsonParser.parseDoc(getRequestBody(request)).toString());
                response.setContentType(APPLICATION_JSON);
                super.doFilter(request, response, chain);
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public static String getRequestBody(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader requestBody = request.getReader();
            builder.append(requestBody.lines().collect(Collectors.joining()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
