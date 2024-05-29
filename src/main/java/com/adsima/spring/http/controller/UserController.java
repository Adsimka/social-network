package com.adsima.spring.http.controller;

import com.adsima.spring.dto.UserCreateEditDto;
import com.adsima.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userService.findByAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(Model model,
                           @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "user/user";
    }

    @PostMapping
    public String create(UserCreateEditDto userCreateEditDto) {
        userService.create(userCreateEditDto);

        return String.format("redirect:/users/%s", 1);
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                         UserCreateEditDto userUpdateEditDto) {
        userService.update(id, userUpdateEditDto);

        return "redirect:/users/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);

        return "redirect:/users";
    }
}
