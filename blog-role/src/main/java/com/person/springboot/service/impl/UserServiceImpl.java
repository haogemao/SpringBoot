package com.person.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.person.springboot.entities.User;
import com.person.springboot.repository.UserRepository;
import com.person.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void removeUsersInBatch(List<User> users) {
        // TODO Auto-generated method stub
        userRepository.deleteInBatch(users);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        // TODO Auto-generated method stub
        Optional<User> user = userRepository.findById(id);
        try {
            user.get();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> listUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // TODO Auto-generated method stub
        return userRepository.findByNameLike(name, pageable);
    }

}
