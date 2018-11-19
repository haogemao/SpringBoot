/**
 *
 */
package com.person.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author HS
 */
@Entity
public class Authority implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id // ����
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ����������
    private Long id; // �û���Ψһ��ʶ

    @Column(nullable = false) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String name;

    /* (non-Javadoc)
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//	public String getName() {
//		return name;
//	}

    public void setName(String name) {
        this.name = name;
    }

}
