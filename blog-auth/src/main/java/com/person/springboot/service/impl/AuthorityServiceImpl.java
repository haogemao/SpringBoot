/**
 *
 */
package com.person.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.springboot.entities.Authority;
import com.person.springboot.repository.AuthorityRepository;
import com.person.springboot.service.AuthorityService;

/**
 * @author HS
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    /* (non-Javadoc)
     * @see com.person.springboot.service.AuthorityService#getAuthorityById(java.lang.Long)
     */
    @Override
    public Authority getAuthorityById(Long id) {
        // TODO Auto-generated method stub
        Authority authority;
        try {
            authority = authorityRepository.findById(id).get();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return authority;
    }

}
