package com.person.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.person.springboot.entities.User;

/**
 * User����ӿ�
 *
 * @author HS
 */
public interface UserService {

    /**
     * �����û�
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * ɾ���û�
     *
     * @param user
     * @return
     */
    void removeUser(Long id);

    /**
     * ɾ���б�������û�
     *
     * @param user
     * @return
     */
    void removeUsersInBatch(List<User> users);

    /**
     * �����û�
     *
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * ����id��ȡ�û�
     *
     * @param user
     * @return
     */
    User getUserById(Long id);

    /**
     * ��ȡ�û��б�
     *
     * @param user
     * @return
     */
    List<User> listUsers();

    /**
     * �����û������з�ҳģ����ѯ
     *
     * @param user
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

}
