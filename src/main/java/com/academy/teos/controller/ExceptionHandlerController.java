package com.academy.teos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Kelheor
 */
@Controller
public class ExceptionHandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    public @ResponseBody
    String handleException(Exception e) {
        LOG.error("Error: " + e.getMessage(), e);
        return "Error: " + e.getMessage();
    }
}
