/**
 *
 */
package com.person.ssm.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HS
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopAdminController {

    @GetMapping("shopoperation")
    public String shopoperation() {
        return "shop/shopoperation";
    }
}
