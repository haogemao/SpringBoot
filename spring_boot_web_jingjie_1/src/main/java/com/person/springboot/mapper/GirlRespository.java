package com.person.springboot.mapper;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.entities.Girl;

public interface GirlRespository extends JpaRepository<Girl, Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);

    //通过Id来查询
    public Optional<Girl> findById(Integer id);
}
