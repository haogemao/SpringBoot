/**
 *
 */
package com.person.ssm.entities;

import java.util.Date;

/**
 * @author HS
 */
public class HeadLine {

    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    //0.不可用 1.可用
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;

    /**
     * @return the lineId
     */
    public Long getLineId() {
        return lineId;
    }

    /**
     * @param lineId the lineId to set
     */
    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    /**
     * @return the lineName
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * @param lineName the lineName to set
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * @return the lineLink
     */
    public String getLineLink() {
        return lineLink;
    }

    /**
     * @param lineLink the lineLink to set
     */
    public void setLineLink(String lineLink) {
        this.lineLink = lineLink;
    }

    /**
     * @return the lineImg
     */
    public String getLineImg() {
        return lineImg;
    }

    /**
     * @param lineImg the lineImg to set
     */
    public void setLineImg(String lineImg) {
        this.lineImg = lineImg;
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return the enableStatus
     */
    public Integer getEnableStatus() {
        return enableStatus;
    }

    /**
     * @param enableStatus the enableStatus to set
     */
    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the lastEditTime
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }

    /**
     * @param lastEditTime the lastEditTime to set
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
