package com.mm.admin.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mm.admin.service.v1.impl.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String AUTHORITIES_KEY = "scopes";
	public static final String X_CUSTOMIZE_TOKEN = "X-CUSTOMIZE-TOKEN";
	public static final String initVector = "encryptionIntVec";
	public static final String ENCY_KEY = "a$sEncrypt!0nKey"; 

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        String username = null;
        String authToken = null;
        
       
	    if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX,"");
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
            	log.error("an error occured during getting username from token");
            } catch (ExpiredJwtException e) {
            	log.error("the token is expired and not valid anymore");
            } catch(SignatureException e){
            	log.error("Authentication Failed. Username or Password not valid.");
            }
        } else {
        	log.error("couldn't find bearer string, will ignore the header");
        }
        
	    
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        	     
        		UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);	
        		if (userDetails != null && jwtTokenUtil.validateToken(authToken, userDetails)) {
	                
        			UsernamePasswordAuthenticationToken authentication = jwtTokenUtil.getAuthentication(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	                
	            }
        	}
        	chain.doFilter(req, res);
    }
}
