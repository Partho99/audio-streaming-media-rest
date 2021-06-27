package com.audio.stream.media.audiostreamingmedia.configuration;

import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JwtTokenFilter extends OncePerRequestFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);

    private final JwtTokenProvider tokenProvider;

    public JwtTokenFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        LOGGER.info("JwtTokenFilter : doFilterInternal");
        String token = request.getHeader("Authorization");
        if (token != null) {
            try {
                Claims claims = tokenProvider.getClaimsFromToken(token);
                if (!claims.getExpiration().before(new Date())) {
                    Authentication authentication = tokenProvider.getAuthentication(claims.getSubject());
                    if (authentication.isAuthenticated()) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (RuntimeException ex) {
                SecurityContextHolder.clearContext();
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return;
        } else {
            LOGGER.info("first time so creating token using UserResourceImpl - authenticate method");
        }
        filterChain.doFilter(request, response);
    }
}
