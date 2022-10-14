package com.group.project.configuration;

import com.group.project.services.CustomUserDetailsService;
import com.group.project.utils.JwtUtil;
import io.jsonwebtoken.security.SignatureException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 *
 * @author Andreas
 */
public class WebsocketHandshakeInterceptor implements HandshakeInterceptor {

    private final CustomUserDetailsService customUserDetailsService;

    public WebsocketHandshakeInterceptor(CustomUserDetailsService customUserDetailsManager) {
        this.customUserDetailsService = customUserDetailsManager;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpServletRequest httpServletRequest = servletRequest.getServletRequest();
            String jwtToken = httpServletRequest.getParameter("access-token");
            JwtUtil jwtUtil = JwtUtil.getInstance();
            String jwtusername;
            try {
                jwtusername = jwtUtil.getUsernameFromToken(jwtToken);
            } catch (SignatureException e) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return false;
            }
            UserDetails userfromdb = customUserDetailsService.loadUserByUsername(jwtusername);
            UsernamePasswordAuthenticationToken principal
                    = new UsernamePasswordAuthenticationToken(userfromdb, null, userfromdb.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(principal);
            return true;
        } else {
            response.setStatusCode(HttpStatus.BAD_REQUEST);
            return false;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }

}
