/**
 *
 */
package com.person.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.person.springboot.entities.es.EsBlog;

/**
 * @author HS
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    public Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);

}
