package com.adsima.spring.http.controller;

import com.adsima.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/greeting")
@SessionAttributes({"user"})
public class GreetingController {

    @GetMapping("/hello")
    public String hello(Model model,
                        @RequestParam("username") String username,
                        @ModelAttribute("userDto") UserReadDto userReadDto) {
        return "greeting/hello";
    }

    @GetMapping("/hello/{id}")
    public String hello(Model model,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @PathVariable Integer id,
                              @CookieValue("JSESSIONID") String jSessionId) {
        return "greeting/hello";
    }

    @RequestMapping("/bye")
    public String bye(ModelAndView modelAndView,
                            @SessionAttribute UserReadDto user) {
        return "greeting/bye";
    }
}
