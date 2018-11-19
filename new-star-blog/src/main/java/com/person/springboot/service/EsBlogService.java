package com.person.springboot.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.person.springboot.domain.User;
import com.person.springboot.domain.es.EsBlog;
import com.person.springboot.vo.TagVO;


/**
 * Blog 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�7鏃�
 */
public interface EsBlogService {

    /**
     * 鍒犻櫎Blog
     *
     * @param id
     * @return
     */
    void removeEsBlog(String id);

    /**
     * 鏇存柊 EsBlog
     *
     * @param EsBlog
     * @return
     */
    EsBlog updateEsBlog(EsBlog esBlog);

    /**
     * 鏍规嵁id鑾峰彇Blog
     *
     * @param id
     * @return
     */
    EsBlog getEsBlogByBlogId(Long blogId);

    /**
     * 鏈�鏂板崥瀹㈠垪琛紝鍒嗛〉
     *
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable);

    /**
     * 鏈�鐑崥瀹㈠垪琛紝鍒嗛〉
     *
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsBlog> listHotestEsBlogs(String keyword, Pageable pageable);

    /**
     * 鍗氬鍒楄〃锛屽垎椤�
     *
     * @param pageable
     * @return
     */
    Page<EsBlog> listEsBlogs(Pageable pageable);

    /**
     * 鏈�鏂板墠5
     *
     * @param keyword
     * @return
     */
    List<EsBlog> listTop5NewestEsBlogs();

    /**
     * 鏈�鐑墠5
     *
     * @param keyword
     * @return
     */
    List<EsBlog> listTop5HotestEsBlogs();

    /**
     * 鏈�鐑墠 30 鏍囩
     *
     * @return
     */
    List<TagVO> listTop30Tags();

    /**
     * 鏈�鐑墠12鐢ㄦ埛
     *
     * @return
     */
    List<User> listTop12Users();
}
