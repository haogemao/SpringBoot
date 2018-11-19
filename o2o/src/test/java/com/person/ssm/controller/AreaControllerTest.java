/**
 *
 */
package com.person.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.person.ssm.BaseTest;
import com.person.ssm.web.superadmin.AreaController;

/**
 * @author HS
 */
public class AreaControllerTest extends BaseTest {

    @Autowired
    private AreaController areaController;

    @Test
    public void listAreaTest() {
        Map<String, Object> model = new HashMap<>();
        model = areaController.listArea();
        Assert.assertEquals(4, model.get("total"));
    }
}
