/**
 *
 */
package com.person.ssm.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.person.ssm.BaseTest;
import com.person.ssm.entities.Area;
import com.person.ssm.service.impl.AreaServiceImpl;

/**
 * @author HS
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Test
    public void findAllTest() {
        List<Area> areas = areaServiceImpl.getAreaList();
        System.out.println(areas.size());
        Assert.assertEquals(4, areas.size());
    }
}
