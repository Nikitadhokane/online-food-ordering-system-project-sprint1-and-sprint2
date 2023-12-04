//package com.project.demo.config;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.filter.GenericFilterBean;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureException;
//
//public class JwtFilter extends GenericFilterBean {
//	
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//	
//		// Cast the request and response to their HTTP equivalents
//		final HttpServletRequest request=(HttpServletRequest)req;
//		final HttpServletResponse response=(HttpServletResponse)res;
//		
//		// Get the 'authorization' header from the HTTP request
//		final String authHeader=request.getHeader("authorization");
//		
//		// Check if the HTTP method is 'OPTIONS'; if so, set status to OK and proceed with the filter chain
//		if("OPTIONS".equals(request.getMethod())) {
//			response.setStatus(HttpServletResponse.SC_OK);
//			chain.doFilter(request, response);
//		}
//		else
//		{
//			// Check if 'authorization' header is missing or does not start with 'Bearer'
//			if(authHeader== null || !authHeader.startsWith("Bearer"))
//			
//				// If missing or invalid, throw a ServletException with an error message
//				throw new ServletException("Missing or Invalid Authorization");
//			
//		}
//		// Extract the token from the 'authorization' header
//		final String token=authHeader.substring(7);
//		try 
//		{
//			// Parse and validate the token using the 'secret key'
//		final Claims claims=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
//		
//		// Store the claims as an attribute in the HTTP request
//		request.setAttribute("claims", claims);
//		}
//		catch (final SignatureException e)
//		{
//		// If the token is invalid, throw a ServletException with an error message
//		throw new ServletException("Invalid token");
//		}
//		
//		 // Continue with the filter chain
//		chain.doFilter(request, response);
//		
//	}
//
//
//}