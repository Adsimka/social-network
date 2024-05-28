package com.adsima.spring.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/greeting")
public class GreetingController {

    @GetMapping("/hello/{id}")
    public ModelAndView hello(ModelAndView modelAndView,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @PathVariable Integer id,
                              @CookieValue("JSESSIONID") String jSessionId) {
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }

    @RequestMapping("/bye")
    public ModelAndView bye(ModelAndView modelAndView) {
        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }
}
