package com.academy.teos.controller;

import com.academy.teos.controller.utils.Ajax;
import com.academy.teos.dto.UserAccountDTO;
import com.academy.teos.service.UserAccountService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController extends ExceptionHandlerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserAccountService userAccountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> register(String userAccount) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UserAccountDTO userAccountDTO = mapper.readValue(userAccount, UserAccountDTO.class);
            userAccountDTO = userAccountService.persist(userAccountDTO);
            return Ajax.successResponse(userAccountDTO);
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage(), e);
            return Ajax.errorResponse(e.getMessage());
        }
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
