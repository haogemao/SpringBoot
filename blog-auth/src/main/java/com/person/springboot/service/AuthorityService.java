package com.person.springboot.service;

import com.person.springboot.entities.Authority;

public interface AuthorityService {

    /**
     * ����id��ȡ Authority
     *
     * @param Authority
     * @return
     */
    public Authority getAuthorityById(Long id);
}
