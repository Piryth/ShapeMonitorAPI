package com.piryth.shapemonitorapi.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        //Extracting Authorization header
        final String authorization = request.getHeader("Authorization");
        //Checking token validity
        if(authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
        }
        //Extracting token from header
        String jwt = authorization.substring(7);



    }
}
