package com.tdep.tadlab.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {
  @Value("${api.key}")
  private String apiKey;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // Get the API key from request headers
    String requestApiKey = request.getHeader("X-API-KEY");

    // Validate the key
    if (apiKey.equals(requestApiKey)) {
      filterChain.doFilter(request, response);
    } else {
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.getWriter().write("Unauthorized");
    }
  }
}
