package com.mm.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	
	@Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Autowired
    PasswordEncoder passwordEncoder;

    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }
    
    
    
    
    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

		
		 http
		  .cors()
		  .and()
		  .csrf()
		  .disable()
		  .authorizeRequests()
		  .antMatchers("/authenticate", "/actuator/*", "/**")
		  .permitAll()
		  .anyRequest().authenticated() .and()
		  .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		 
    	http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
    	 .addFilterBefore(new CorsFilter(), SessionManagementFilter.class);
    }
    
    
   
    /*CorsFilter corsFilter() {
    	CorsFilter filter = new CorsFilter();
        return filter;
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
        .ignoring()
                .antMatchers("/resources/**", 
                		"/static/**", 
                		"/css/**", 
                		"/js/**", 
                		"/images/**",
                		"/v1/auth/*",
                		"/swagger-ui.html",
                		"/webjars/**",
                		"/",
                		"/swagger-resources/**",
                		"/v2/api-docs",
                        "/configuration/ui"
                		);
    }
    
}
