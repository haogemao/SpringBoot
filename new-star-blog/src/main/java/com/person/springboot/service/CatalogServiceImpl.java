package com.person.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.springboot.domain.Catalog;
import com.person.springboot.domain.User;
import com.person.springboot.repository.CatalogRepository;


/**
 * Catalog 鏈嶅姟.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�10鏃�
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        // 鍒ゆ柇閲嶅
        List<Catalog> list = catalogRepository.findByUserAndName(catalog.getUser(), catalog.getName());
        if (list != null && list.size() > 0) {
            throw new IllegalArgumentException("璇ュ垎绫诲凡缁忓瓨鍦ㄤ簡");
        }
        return catalogRepository.save(catalog);
    }

    @Override
    public void removeCatalog(Long id) {
        catalogRepository.deleteById(id);
    }

    @Override
    public Catalog getCatalogById(Long id) {
        Catalog catalog = null;
        try {
            catalog = catalogRepository.findById(id).get();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return catalog;
    }

    @Override
    public List<Catalog> listCatalogs(User user) {
        return catalogRepository.findByUser(user);
    }

}
