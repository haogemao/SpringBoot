package com.person.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.person.springboot.domain.File;


/**
 * File 瀛樺偍搴�.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�28鏃�
 */
public interface FileRepository extends MongoRepository<File, String> {
}
