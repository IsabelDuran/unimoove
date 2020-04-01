package unimoove.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
	public static String currentUserUsername() {
		return (String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());

	}
}
