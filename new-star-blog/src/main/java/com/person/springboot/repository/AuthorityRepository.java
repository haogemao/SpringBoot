package com.person.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.domain.Authority;


/**
 * Authority 浠撳簱.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�2鏃�
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
