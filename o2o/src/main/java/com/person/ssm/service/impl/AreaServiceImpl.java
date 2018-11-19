/**
 *
 */
package com.person.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.ssm.dao.AreaDao;
import com.person.ssm.dto.AreaExecution;
import com.person.ssm.entities.Area;
import com.person.ssm.service.AreaService;

/**
 * @author HS
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    /* (non-Javadoc)
     * @see com.person.ssm.service.AreaService#findAll()
     */
    @Override
    public List<Area> getAreaList() {
        // TODO Auto-generated method stub
        return areaDao.getAreaList();
    }

    @Override
    public AreaExecution addArea(Area area) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AreaExecution modifyArea(Area area) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AreaExecution removeArea(long areaId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AreaExecution removeAreaList(List<Long> areaIdList) {
        // TODO Auto-generated method stub
        return null;
    }

}
