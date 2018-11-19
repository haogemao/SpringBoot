/**
 *
 */
package com.person.ssm.entities;

import java.util.Date;

/**
 * @author HS
 */
public class LocalAuth {

    private Long localAuthId;

    private String userName;

    private String password;

    //	private Long userId;
    private Date createTime;

    private Date lastEditTime;

    private PersonInfo personInfo;

    /**
     * @return the localAuthId
     */
    public Long getLocalAuthId() {
        return localAuthId;
    }

    /**
     * @param localAuthId the localAuthId to set
     */
    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
