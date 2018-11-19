package com.person.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.domain.Blog;
import com.person.springboot.domain.Catalog;
import com.person.springboot.domain.User;


/**
 * Blog 浠撳簱.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�7鏃�
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
    /**
     * 鏍规嵁鐢ㄦ埛鍚嶅垎椤垫煡璇㈢敤鎴峰垪琛紙鏈�鏂帮級
     * 鐢� findByUserAndTitleLikeOrTagsLikeOrderByCreateTimeDesc 浠ｆ浛锛屽彲浠ユ牴鎹爣绛捐繘琛屾煡璇�
     *
     * @param user
     * @param title
     * @param pageable
     * @return
     * @see findByTitleLikeOrTagsLikeAndUserOrderByCreateTimeDesc
     */
    @Deprecated
    Page<Blog> findByUserAndTitleLikeOrderByCreateTimeDesc(User user, String title, Pageable pageable);

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶅垎椤垫煡璇㈢敤鎴峰垪琛�
     *
     * @param user
     * @param title
     * @param sort
     * @param pageable
     * @return
     */
    Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶅垎椤垫煡璇㈢敤鎴峰垪琛�
     *
     * @param user
     * @param title
     * @param sort
     * @param pageable
     * @return
     */
    Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title, User user, String tags, User user2, Pageable pageable);

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶅垎椤垫煡璇㈢敤鎴峰垪琛�
     *
     * @param user
     * @param title
     * @param sort
     * @param pageable
     * @return
     */
    Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);
}
