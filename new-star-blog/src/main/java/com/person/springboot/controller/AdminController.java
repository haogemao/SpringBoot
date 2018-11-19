package com.person.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.person.springboot.vo.Menu;


/**
 * 鐢ㄦ埛鎺у埗鍣�.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017骞�2鏈�26鏃�
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    /**
     * 鑾峰彇鍚庡彴绠＄悊涓婚〉闈�
     *
     * @return
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("鐢ㄦ埛绠＄悊", "/users"));
        model.addAttribute("list", list);
        return new ModelAndView("/admins/index", "model", model);
    }


}
