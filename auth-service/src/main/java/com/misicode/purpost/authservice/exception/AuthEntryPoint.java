package com.misicode.purpost.authservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.misicode.purpost.authservice.constants.HttpConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence (HttpServletRequest request,
                          HttpServletResponse response,
                          AuthenticationException authException)
            throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final Map<String, Object> body = new HashMap<>();
        body.put(HttpConstants.TIMESTAMP, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(ZonedDateTime.now()));
        body.put(HttpConstants.STATUS, HttpServletResponse.SC_UNAUTHORIZED);
        body.put(HttpConstants.ERROR, "UNAUTHORIZED");
        body.put(HttpConstants.MESSAGE, "Sesión inválida");
        body.put(HttpConstants.PATH, request.getServletPath());

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}
