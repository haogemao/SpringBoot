package com.person.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.person.springboot.vo.Menu;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @GetMapping
    public ModelAndView listUser(Model model) {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("�û�����", "/users"));
        list.add(new Menu("��ɫ����", "/roles"));
        list.add(new Menu("���͹���", "/blogs"));
        list.add(new Menu("���۹���", "/commits"));
        model.addAttribute("list", list);
        return new ModelAndView("admins/index", "menuList", model);
    }
}
