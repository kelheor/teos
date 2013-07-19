package com.academy.teos.security.provider;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import com.academy.teos.security.UserAuthenticationDetails;


@Service("userAuthenticationDetailsSource")
public class UserAuthenticationDetailsSource implements
		AuthenticationDetailsSource<HttpServletRequest, UserAuthenticationDetails> {

	/**
	 * @param context
	 *            the {@code HttpServletRequest} object.
	 * @return the {@code UserAuthenticationDetails} containing information about the current request
	 */
	@Override
	public UserAuthenticationDetails buildDetails(HttpServletRequest context) {
		return new UserAuthenticationDetails(context);
	}
}
