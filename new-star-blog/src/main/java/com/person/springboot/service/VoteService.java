package com.person.springboot.service;

import com.person.springboot.domain.Vote;

/**
 * Vote 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�9鏃�
 */
public interface VoteService {
    /**
     * 鏍规嵁id鑾峰彇 Vote
     *
     * @param id
     * @return
     */
    Vote getVoteById(Long id);

    /**
     * 鍒犻櫎Vote
     *
     * @param id
     * @return
     */
    void removeVote(Long id);
}
