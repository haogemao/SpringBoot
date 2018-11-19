package com.person.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * �����û�������ҳ��ѯ�û��б�
     *
     * @param name
     * @param pageable
     * @return
     */
    public Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * �����û��˺Ų�ѯ�û�
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);
//	/**
//	 * ������߸����û�
//	 * @param user
//	 * @return
//	 */
//	public User saveOrUpdateUser(User user);
//	
//	/**
//	 * ɾ���û�
//	 * @param id
//	 */
//	public void deleteUser(Long id);
//	
//	/**
//	 * ��ѯ�û�
//	 * @param id
//	 * @return
//	 */
//	public User findUser(Long id);
//	
//	/**
//	 * ��ѯ�û��б�
//	 * @return
//	 */
//	public List<User> findUserList();
}
