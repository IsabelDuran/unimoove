package unimoove.security.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClock;

public class AuthenticationFilter extends OncePerRequestFilter {

	private UserDetailsService userDetailsService;

	private Clock clock = DefaultClock.INSTANCE;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String secret;

	public AuthenticationFilter(UserDetailsService userDetailsService, String secret) {
		super();
		this.userDetailsService = userDetailsService;
		this.secret = secret;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String xApiKey = request.getHeader("X-API-KEY");
		String username = null;
		Jws<Claims> jws;
		if (xApiKey != null) {
			try {
				jws = Jwts.parser().setSigningKey(secret).parseClaimsJws(xApiKey);
				username = jws.getBody().getSubject();

				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					logger.debug("Se ha obtenido el usuario " + userDetails.getUsername());
					if (isTokenNonExpired(jws)) {
						UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
								userDetails.getUsername(), null, userDetails.getAuthorities());
						SecurityContextHolder.getContext().setAuthentication(usernamePAT);
					}
				}
			} catch (JwtException ex) {
				logger.error(ex.getMessage());
			}
		}

		filterChain.doFilter(request, response);

	}

	private boolean isTokenNonExpired(Jws<Claims> jws) {
		return jws.getBody().getExpiration().after(clock.now());
	}

}
