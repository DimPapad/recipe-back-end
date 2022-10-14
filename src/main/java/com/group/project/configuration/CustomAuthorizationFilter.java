package com.group.project.configuration;

import com.group.project.services.CustomUserDetailsService;
import com.group.project.utils.JwtUtil;
import io.jsonwebtoken.security.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Andreas
 */
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    //private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private final CustomUserDetailsService customUserDetailsService;

    public CustomAuthorizationFilter(CustomUserDetailsService customUserDetailsManager) {
        this.customUserDetailsService = customUserDetailsManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().startsWith("/login")
                || request.getServletPath().startsWith("/js")
                || request.getServletPath().startsWith("/users/create")
                || request.getServletPath().startsWith("/chat")) {
            filterChain.doFilter(request, response);
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String realjwt = authorizationHeader.substring("Bearer ".length()).trim();
                JwtUtil jwtUtil = JwtUtil.getInstance();
                Authentication loggedinuser = SecurityContextHolder.getContext().getAuthentication();
                String jwtusername;
                try {
                    jwtusername = jwtUtil.getUsernameFromToken(realjwt);
                } catch (SignatureException e) {
                    response.sendError(403, "You must login");
                    return;
                }
                if (loggedinuser == null && jwtusername != null) {
                    // every request is served by this segment
                    UserDetails userfromdb = customUserDetailsService.loadUserByUsername(jwtusername);
                    UsernamePasswordAuthenticationToken principal
                            = new UsernamePasswordAuthenticationToken(userfromdb, null, userfromdb.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(principal);
                    filterChain.doFilter(request, response);
                } else {
                    // SecurityContextHolder.getContext is cleared after every request, this segment never runs
                    UserDetails user = (UserDetails) loggedinuser.getPrincipal();
                    if (user.getUsername().equals(jwtusername)) {
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendError(403, "You must login");
                    }
                }
            } else {
                response.sendError(403, "You must login");
            }
        }
    }

}
