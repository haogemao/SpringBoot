package com.person.springboot.entities.es;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(indexName = "blog", type = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsBlog implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String title;

    private String summary;

    private String content;

}
