package com.person.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.domain.Vote;


/**
 * Vote 浠撳簱.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�9鏃�
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
