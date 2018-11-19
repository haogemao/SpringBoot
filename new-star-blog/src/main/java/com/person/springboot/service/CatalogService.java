package com.person.springboot.service;

import java.util.List;

import com.person.springboot.domain.Catalog;
import com.person.springboot.domain.User;


/**
 * Catalog 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�10鏃�
 */
public interface CatalogService {
    /**
     * 淇濆瓨Catalog
     *
     * @param catalog
     * @return
     */
    Catalog saveCatalog(Catalog catalog);

    /**
     * 鍒犻櫎Catalog
     *
     * @param id
     * @return
     */
    void removeCatalog(Long id);

    /**
     * 鏍规嵁id鑾峰彇Catalog
     *
     * @param id
     * @return
     */
    Catalog getCatalogById(Long id);

    /**
     * 鑾峰彇Catalog鍒楄〃
     *
     * @return
     */
    List<Catalog> listCatalogs(User user);
}
