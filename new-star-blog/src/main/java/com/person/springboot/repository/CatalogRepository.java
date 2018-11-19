package com.person.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.domain.Catalog;
import com.person.springboot.domain.User;


/**
 * Catalog 浠撳簱.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�10鏃�
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    /**
     * 鏍规嵁鐢ㄦ埛鏌ヨ
     *
     * @param user
     * @return
     */
    List<Catalog> findByUser(User user);

    /**
     * 鏍规嵁鐢ㄦ埛鏌ヨ
     *
     * @param user
     * @param name
     * @return
     */
    List<Catalog> findByUserAndName(User user, String name);
}
