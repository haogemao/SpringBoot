package com.person.springboot.service;

import com.person.springboot.domain.Comment;

/**
 * Comment 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�9鏃�
 */
public interface CommentService {
    /**
     * 鏍规嵁id鑾峰彇 Comment
     *
     * @param id
     * @return
     */
    Comment getCommentById(Long id);

    /**
     * 鍒犻櫎璇勮
     *
     * @param id
     * @return
     */
    void removeComment(Long id);
}
