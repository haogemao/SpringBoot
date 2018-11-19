package com.person.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.person.springboot.domain.Blog;
import com.person.springboot.domain.Catalog;
import com.person.springboot.domain.User;


/**
 * Blog 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�7鏃�
 */
public interface BlogService {
    /**
     * 淇濆瓨Blog
     *
     * @param EsBlog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 鍒犻櫎Blog
     *
     * @param id
     * @return
     */
    void removeBlog(Long id);

    /**
     * 鏍规嵁id鑾峰彇Blog
     *
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶈繘琛屽垎椤垫ā绯婃煡璇紙鏈�鏂帮級
     *
     * @param user
     * @return
     */
    Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶈繘琛屽垎椤垫ā绯婃煡璇紙鏈�鐑級
     *
     * @param user
     * @return
     */
    Page<Blog> listBlogsByTitleVoteAndSort(User suser, String title, Pageable pageable);

    /**
     * 鏍规嵁鍒嗙被杩涜鏌ヨ
     *
     * @param catalog
     * @param pageable
     * @return
     */
    Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable);

    /**
     * 闃呰閲忛�掑
     *
     * @param id
     */
    void readingIncrease(Long id);

    /**
     * 鍙戣〃璇勮
     *
     * @param blogId
     * @param commentContent
     * @return
     */
    Blog createComment(Long blogId, String commentContent);

    /**
     * 鍒犻櫎璇勮
     *
     * @param blogId
     * @param commentId
     * @return
     */
    void removeComment(Long blogId, Long commentId);

    /**
     * 鐐硅禐
     *
     * @param blogId
     * @return
     */
    Blog createVote(Long blogId);

    /**
     * 鍙栨秷鐐硅禐
     *
     * @param blogId
     * @param voteId
     * @return
     */
    void removeVote(Long blogId, Long voteId);
}
