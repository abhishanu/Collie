package frnds.collie.services.collie.security.configs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	public String generateToken(Authentication authentication) {

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		Date now = new Date();

		// 2*24*60*jwtExpirationInMs (Represents 2 days)
		Date expiryDate = new Date(now.getTime() + 2 * 24 * 60 * jwtExpirationInMs);
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}

	public String getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			System.out.println("Not a valid token signature:" + ex.getMessage());
		} catch (MalformedJwtException ex) {
			System.out.println("Token malformed:" + ex.getMessage());
		} catch (ExpiredJwtException ex) {
			System.out.println("Token Exprired:" + ex.getMessage());
		} catch (UnsupportedJwtException ex) {
		} catch (IllegalArgumentException ex) {
		}
		return false;
	}
}