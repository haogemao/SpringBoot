package com.person.springboot.repository;


import org.springframework.data.repository.CrudRepository;

import com.person.springboot.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

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
