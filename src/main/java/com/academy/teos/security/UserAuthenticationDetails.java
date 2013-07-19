package com.academy.teos.security;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserAuthenticationDetails implements Serializable {

	private static final long serialVersionUID = 9046255233032865211L;

	private final String remoteAddress;
	private final String sessionId;	
	
	/**
	 * Records the remote address, access level id and will also set the session Id if a session already exists (it
	 * won't create one).
	 * 
	 * @param request
	 *            that the authentication request was received from
	 */
	public UserAuthenticationDetails(HttpServletRequest request) {
		this.remoteAddress = request.getRemoteAddr();
		HttpSession session = request.getSession(false);
		this.sessionId = (session != null) ? session.getId() : null;
	}

	public UserAuthenticationDetails(String remoteAddress, String sessionId, String accessLevelId,
			String osSign, String isSecure, String isLoginPlugin) {
		super();
		this.remoteAddress = remoteAddress;
		this.sessionId = sessionId;
	}

	/**
	 * Indicates the TCP/IP address the authentication request was received from.
	 * 
	 * @return the address
	 */
	public String getRemoteAddress() {
		return remoteAddress;
	}

	
	/**
	 * Indicates the <code>HttpSession</code> id the authentication request was received from.
	 * 
	 * @return the session ID
	 */
	public String getSessionId() {
		return sessionId;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		UserAuthenticationDetails alad = (UserAuthenticationDetails) obj;

		return new EqualsBuilder().append(getRemoteAddress(), alad.getRemoteAddress())
				.append(getSessionId(), alad.getSessionId())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRemoteAddress()).append(getSessionId())
				.toHashCode();
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
