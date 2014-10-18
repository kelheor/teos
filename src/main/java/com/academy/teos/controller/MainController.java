package com.academy.teos.controller;

import com.academy.teos.controller.utils.Ajax;
import com.academy.teos.controller.utils.RestException;
import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.security.Roles;
import com.academy.teos.security.UserAuthentication;
import com.academy.teos.security.UserSession;
import com.academy.teos.security.provider.UserAuthenticationDetailsSource;
import com.academy.teos.service.UserAccountService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController extends ExceptionHandlerController {
	
	private static final Logger LOG = Logger.getLogger(MainController.class);

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAuthenticationDetailsSource userAuthenticationDetailsSource;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody
    Map<String, Object> register(@RequestParam(value = "userAccount", required = true) String userAccount, HttpServletRequest request) throws RestException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);

            // TODO: Fix existing user exception catching
            userAccountDTO = userAccountService.persist(userAccountDTO);

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(Roles.ROLE_USER.getValue()));

            String password = userAccountDTO.getPassword();
            String username = userAccountDTO.getUsername();
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserSession userSession = new UserSession(username, password, authorities);
            userSession.setUserId(userAccountDTO.getUserAccountId());
            Authentication userAuthentication = new UserAuthentication(userSession, userAuthenticationDetailsSource.buildDetails(request));
            userAuthentication.setAuthenticated(true);

            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/edit_profile", method = RequestMethod.GET)
    public String edit_profile() {
        return "edit_profile";
    }

    @RequestMapping(value = "/show_profile", method = RequestMethod.GET)
    public String show_profile() {
        return "show_profile";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String main(HttpServletRequest request, Model model) {
        LOG.info("Warning! Intruder alert: ");
        LOG.info("IP: " + request.getRemoteAddr());
        LOG.info("Client: " + request.getHeader("User-Agent"));
        return "main";
    }

}
