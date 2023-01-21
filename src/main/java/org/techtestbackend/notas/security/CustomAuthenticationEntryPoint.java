package org.techtestbackend.notas.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.techtestbackend.notas.domain.ExceptionResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(401);
        
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Acceso denegado",
        		authException.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        
        res.getWriter().write(objectMapper.writeValueAsString(exceptionResponse));
    }
}
