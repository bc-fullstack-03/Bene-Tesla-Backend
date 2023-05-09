package com.sysmap.api.service.security.implementation;

/*package com.sysmap.api.service.authentication.implementation;  import jakarta.servlet.FilterChain;

import com.sysmap.api.service.authentication.IJwtService;
import com.sysmap.api.service.client.IUservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class AuthenticateFilter extends OncePerRequestFilter {
    @Autowired
    private IJwtService _jwtService;
    @Autowired
    private IUservice _userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().contains("/api/v1/authentication")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getServletPath().contains("swagger") || request.getServletPath().contains("docs")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getServletPath().contains("/api/v1/user/create")) {
            filterChain.doFilter(request, response);
            return;
        }

        var token = request.getHeader("Authorization");
        var userId = request.getHeader("RequestedBy");

         if (token == null || userId == null) {
            response.getWriter().write("Tamo travando aquis");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
    

        boolean isValidToken = false;

        try {
            isValidToken = _jwtService.isValidToken(token , userId);
        } catch (Exception e) {
            response.getWriter().write(e.getMessage());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        if (isValidToken) {
            try {
                var user = _userService.getUserById(UUID.fromString(userId));

                var authentication = new UsernamePasswordAuthenticationToken(user, null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                response.getWriter().write(e.getMessage());
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        } else {
            response.getWriter().write("Invalid token!");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        filterChain.doFilter(request, response);
    }
}
 * 
 */

