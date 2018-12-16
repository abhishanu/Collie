package frnds.collie.services.collie.security.configs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private static Logger logger = Logger.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {

		logger.error("UNAUTHORIZED error:"+e.getMessage());
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		/*response.getOutputStream().println("{ \"status\": \"" + ResponseStatus.UNAUTHORIZED + "\",\"response\": \""
				+ "Please login to access this URL" + "\" }");*/
	}

}

