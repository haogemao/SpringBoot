package com.person.springboot.service;

import com.person.springboot.domain.Authority;

/**
 * Authority 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�18鏃�
 */
public interface AuthorityService {


    /**
     * 鏍规嵁id鑾峰彇 Authority
     *
     * @param Authority
     * @return
     */
    Authority getAuthorityById(Long id);
}
