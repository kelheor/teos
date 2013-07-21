package com.academy.teos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Kelheor
 */
@Controller
@RequestMapping("/controller/userAccount")
public class UserAccountController extends ExceptionHandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(UserAccountController.class);


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    String test(Model model) throws Exception {
        if (true) {
            throw new Exception("TEST");
        }

        return "main";
    }
}
