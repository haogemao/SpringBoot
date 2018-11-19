/**
 *
 */
package com.person.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.springboot.domain.Authority;
import com.person.springboot.repository.AuthorityRepository;


/**
 * Authority 鏈嶅姟.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�30鏃�
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        Authority authority = null;
        try {
            authority = authorityRepository.findById(id).get();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return authority;
    }

}
