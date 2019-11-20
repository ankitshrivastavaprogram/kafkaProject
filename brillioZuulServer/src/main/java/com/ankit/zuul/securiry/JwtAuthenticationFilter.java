package com.ankit.zuul.securiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ankit.zuul.exception.InvalidCounterIdException;
import com.ankit.zuul.model.Counter;
import com.ankit.zuul.repository.CounterRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;  
    
    @Autowired
    private CounterRepository counterRepository;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);
            
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
            	
                Long counterId = tokenProvider.getCounterIdFromJWT(jwt);
                
                //get user through userId
                Counter counter = counterRepository.findById(counterId).orElseThrow(()->new InvalidCounterIdException());
                
                //convert  user to userDetail
                UserDetails userDetails = UserPrincipal.create(counter);     
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
        	
            logger.error("Could not set user authentication in security context", ex);
        }
       
        String bearerToken = request.getHeader("Authorization");
        System.out.println("yyyyyyyyyyyyyyyyyyyyyy"+bearerToken);
       // request.setAttribute("abc", "abcd");
       
        filterChain.doFilter(request, response);
        
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
