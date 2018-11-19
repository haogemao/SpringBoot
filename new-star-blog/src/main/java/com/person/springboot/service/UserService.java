package com.person.springboot.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.person.springboot.domain.User;


/**
 * User 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�18鏃�
 */
public interface UserService {
    /**
     * 淇濆瓨鐢ㄦ埛
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 鍒犻櫎鐢ㄦ埛
     *
     * @param id
     * @return
     */
    void removeUser(Long id);

    /**
     * 鍒犻櫎鍒楄〃閲岄潰鐨勭敤鎴�
     *
     * @param users
     * @return
     */
    void removeUsersInBatch(List<User> users);

    /**
     * 鏇存柊鐢ㄦ埛
     *
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 鏍规嵁id鑾峰彇鐢ㄦ埛
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 鑾峰彇鐢ㄦ埛鍒楄〃
     *
     * @return
     */
    List<User> listUsers();

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶈繘琛屽垎椤垫ā绯婃煡璇�
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 鏇村叿鍚嶇О鍒楄〃鏌ヨ
     *
     * @param usernames
     * @return
     */
    List<User> listUsersByUsernames(Collection<String> usernames);
}
