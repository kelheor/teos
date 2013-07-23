package com.academy.teos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class MainController extends ExceptionHandlerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "main";
	}

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String main(HttpServletRequest request, Model model) {
        LOG.info("Warning! Intruder alert: ");
        LOG.info("IP: " + request.getRemoteAddr());
        LOG.info("Client: " + request.getHeader("User-Agent"));
        return "main";
    }

}
