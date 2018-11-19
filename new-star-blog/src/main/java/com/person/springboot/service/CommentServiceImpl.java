package com.person.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.springboot.domain.Comment;
import com.person.springboot.repository.CommentRepository;


/**
 * Comment 鏈嶅姟.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�9鏃�
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /* (non-Javadoc)
     * @see com.waylau.spring.boot.blog.service.CommentService#removeComment(java.lang.Long)
     */
    @Override
    @Transactional
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
        ;
    }

    @Override
    public Comment getCommentById(Long id) {
        Comment comment = null;
        try {
            comment = commentRepository.findById(id).get();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return comment;
    }

}
