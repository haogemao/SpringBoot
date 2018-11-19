/**
 *
 */
package com.person.springboot.controller;

import java.util.concurrent.atomic.LongAccumulator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HS
 */
@Controller
@RequestMapping("blogs")
public class BlogController {

    /**
     * ��ѯ����
     *
     * @param order(����)
     * @param keyword(��ǩ)
     * @return
     */
    @GetMapping
    public String listBlog(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
                           @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        System.out.println("order = " + order + ";keyword = " + keyword);
        return "redirect:index?order=" + order + "&keyword=" + keyword;
    }
}
