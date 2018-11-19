/**
 *
 */
package com.person.ssm.service;

import java.util.List;

import com.person.ssm.dto.AreaExecution;
import com.person.ssm.entities.Area;

/**
 * @author HS
 */
public interface AreaService {

    public List<Area> getAreaList();

    /**
     * @param area
     * @return
     */
    AreaExecution addArea(Area area);

    /**
     * @param area
     * @return
     */
    AreaExecution modifyArea(Area area);

    /**
     * @param areaId
     * @return
     */
    AreaExecution removeArea(long areaId);

    /**
     * @param areaIdList
     * @return
     */
    AreaExecution removeAreaList(List<Long> areaIdList);
}
