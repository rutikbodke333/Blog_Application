package com.blogapplication.security;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;



@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // set  HTTP status code to 403 Forbidden
        response.setContentType("application/json"); // set the content type of the response to JSON
        response.getWriter().write("{\"error\": \"Access Denied: You don't have permission to access this resource.\"}");

    }
}
