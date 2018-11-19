package com.person.springboot.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.springboot.domain.Vote;
import com.person.springboot.repository.VoteRepository;


/**
 * Vote 鏈嶅姟.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�9鏃�
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    /* (non-Javadoc)
     * @see com.waylau.spring.boot.blog.service.VoteService#removeVote(java.lang.Long)
     */
    @Override
    @Transactional
    public void removeVote(Long id) {
        voteRepository.deleteById(id);
    }

    @Override
    public Vote getVoteById(Long id) {
        Vote vote = null;
        try {
            vote = voteRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            // TODO: handle exception
        }
        return vote;
    }

}
