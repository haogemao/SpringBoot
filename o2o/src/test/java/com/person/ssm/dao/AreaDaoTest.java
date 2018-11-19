/**
 *
 */
package com.person.ssm.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.person.ssm.BaseTest;
import com.person.ssm.entities.Area;

/**
 * @author HS
 */
public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void findAllTest() {
        List<Area> areas = areaDao.getAreaList();
        Assert.assertEquals(4, areas.size());
    }
}
