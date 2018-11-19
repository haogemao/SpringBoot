package com.person.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
