package com.academy.teos.security.provider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.service.UserAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.academy.teos.security.UserAuthenticationDetails;
import com.academy.teos.security.Roles;
import com.academy.teos.security.UserAuthentication;
import com.academy.teos.security.UserSession;

/**
 * Провайдер аутентификации пользователя
 * 
 * @author rnazirov
 * 
 */
@Service("userAuthenticationProvider")
@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, noRollbackFor = { AuthenticationException.class })
public class UserAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOG = Logger.getLogger(UserAuthenticationProvider.class);
	
	@Autowired
	private UserAccountService userAccountService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String username = (String) authentication.getPrincipal();
			String password = (String) authentication.getCredentials();

			UserAuthenticationDetails authenticationDetails = null;
			if (authentication.getDetails() != null && authentication.getDetails() instanceof UserAuthenticationDetails) {
				authenticationDetails = (UserAuthenticationDetails) authentication.getDetails();
			}

			if (username == null || username.isEmpty()) {
				throw new BadCredentialsException("Username can not be null");
			}

			if (password == null) {
				throw new BadCredentialsException("Password can not be null");
			}
			
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
				messageDigest.update(password.getBytes());
				byte byteData[] = messageDigest.digest();
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}
				password = sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			UserAccountDTO userAccountDTO = userAccountService.findUserByUsernameAndPassword(username, password);
			
			if(userAccountDTO == null) {
				throw new BadCredentialsException("Неверные логин или пароль");
			}
			
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(Roles.ROLE_USER.getValue()));

			UserSession userSession = new UserSession(username, password, authorities);
			userSession.setUserId(userAccountDTO.getUserAccountId());
			Authentication userAuthentication = new UserAuthentication(userSession, authenticationDetails);
			userAuthentication.setAuthenticated(true);

			return userAuthentication;

		} catch (AuthenticationException ae) {
			throw ae;
		}
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
