package com.person.springboot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.domain.User;


/**
 * 鐢ㄦ埛浠撳簱.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�2鏃�
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶅垎椤垫煡璇㈢敤鎴峰垪琛�
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 鏍规嵁鍚嶇О鏌ヨ
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 鏍规嵁鍚嶇О鍒楄〃鏌ヨ
     *
     * @param usernames
     * @return
     */
    List<User> findByUsernameIn(Collection<String> usernames);
}
