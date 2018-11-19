package com.person.springboot.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.person.springboot.entities.User;
import com.person.springboot.repository.UserRepository;
import com.person.springboot.service.impl.UserServiceImpl;
import com.person.springboot.util.ConstraintViolationExceptionHandler;
import com.person.springboot.util.ResponseUtil;
import com.person.springboot.vo.Response;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * ��ѯ�����û�
     *
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value = "async", required = false) boolean async,
                             @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                             @RequestParam(value = "name", required = false, defaultValue = "") String name,
                             Model model) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<User> page = userServiceImpl.listUsersByNameLike("%" + name + "%", pageable);
        List<User> list = page.getContent();    // ��ǰ����ҳ�������б�

        model.addAttribute("page", page);
        model.addAttribute("userList", list);
        return new ModelAndView(async == true ? "users/list :: #mainContainerRepleace" : "users/list", "userModel", model);
    }

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
    @GetMapping("/bak")
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
     * ��ȡ form ��ҳ��
     *
     * @param user
     * @return
     */
    @GetMapping("/add")
    public ModelAndView addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "�����û�");
        return new ModelAndView("users/add", "userModel", model);
    }

    /**
     * ��ȡ form ��ҳ��
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
//	@ResponseBody
    public ModelAndView registerUser(User user) {
        try {
            user = userServiceImpl.saveUser(user);
        } catch (Exception e) {
            // TODO: handle exception
            log.error("�������û����������� = {}", ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException) e));
//			return ResponseEntity.ok().body(ResponseUtil.error(ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException)e)));
        }
        return new ModelAndView("redirect:/login");
    }
//	
//	/**
//	 * ��ȡ form ��ҳ��
//	 * @param user
//	 * @return
//	 */
//	@PostMapping("/register")
////	@ResponseBody
//	public ResponseEntity<Response> registerUser(User user) {
//		try {
//			user = userServiceImpl.saveUser(user);
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.error("�������û����������� = {}", ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException)e));
//			return ResponseEntity.ok().body(ResponseUtil.error(ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException)e)));
//		}
//		return ResponseEntity.ok().body(ResponseUtil.success(user));
//	}

    /**
     * �½��û�
     *
     * @param user
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping("/bak")
    public ModelAndView create(User user) {
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users");
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
    public ResponseEntity<Response> addUser(User user) {
        try {
            user = userRepository.save(user);
        } catch (Exception e) {
            // TODO: handle exception
            log.error("�������û����������� = {}", ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException) e));
            return ResponseEntity.ok().body(ResponseUtil.error(ConstraintViolationExceptionHandler.getMessage((ConstraintViolationException) e)));
        }
        return ResponseEntity.ok().body(ResponseUtil.success(user));
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

    /**
     * �޸��û�
     *
     * @param user
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Long id, Model model) {
        User user = userServiceImpl.getUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "�޸��û�");
        return new ModelAndView("users/edit", "userModel", model);
    }
}
