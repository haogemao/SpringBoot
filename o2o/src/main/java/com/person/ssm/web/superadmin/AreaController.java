/**
 *
 */
package com.person.ssm.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.person.ssm.entities.Area;
import com.person.ssm.service.AreaService;

/**
 * @author HS
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    @GetMapping("/listarea")
    @ResponseBody
    public Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> areas = new ArrayList<>();
        try {
            areas = areaService.getAreaList();
            modelMap.put("rows", areas);
            modelMap.put("total", areas.size());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        logger.debug("测试");
        return modelMap;
    }
}
