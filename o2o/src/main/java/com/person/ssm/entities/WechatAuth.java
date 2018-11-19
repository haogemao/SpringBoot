/**
 *
 */
package com.person.ssm.entities;

import java.util.Date;

/**
 * @author HS
 */
public class WechatAuth {


    private Long wechatAuthId;

    private String openId;

    private Date createTime;

    private PersonInfo personInfo;

    /**
     * @return the wechatAuthId
     */
    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    /**
     * @param wechatAuthId the wechatAuthId to set
     */
    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    /**
     * @return the openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId the openId to set
     */
    public void setOpenId(String openId) {
        this.openId = openId;
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
     * @return the personInfo
     */
    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    /**
     * @param personInfo the personInfo to set
     */
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
