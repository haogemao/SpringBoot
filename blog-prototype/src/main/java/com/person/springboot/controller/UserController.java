package com.person.springboot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.person.springboot.entities.User;
import com.person.springboot.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * �� �û��洢�� ��ȡ�û��б�
     *
     * @return
     */
    private List<User> getUserlist() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    /**
     * ��ѯ�����û�
     *
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "�û�����");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * ����id��ѯ�û�
     *
     * @param message
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("title", "�鿴�û�");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * ��ȡ form ��ҳ��
     *
     * @param user
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "�����û�");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * �½��û�
     *
     * @param user
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * ɾ���û�
     *
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteById(id);

        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "ɾ���û�");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * �޸��û�
     *
     * @param user
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();

        model.addAttribute("user", user);
        model.addAttribute("title", "�޸��û�");
        return new ModelAndView("users/form", "userModel", model);
    }
}
