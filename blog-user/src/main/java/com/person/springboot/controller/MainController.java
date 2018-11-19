/**
 *
 */
package com.person.springboot.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.person.springboot.entities.User;
import com.person.springboot.service.impl.UserServiceImpl;
import com.person.springboot.util.ConstraintViolationExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author HS
 */
@Controller
@Slf4j
public class MainController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errMsg", "��¼ʧ�ܣ��û��������������");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        try {
            user = userServiceImpl.saveUser(user);
        } catch (Exception e) {
            // TODO: handle exception
            log.error("�������û����������� = {}", ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException) e));
//			return ResponseEntity.ok().body(ResponseUtil.error(ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException)e)));
        }
        return "redirect:/login";
    }
}
