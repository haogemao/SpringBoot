package com.person.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.person.springboot.entities.es.EsBlog;
import com.person.springboot.repository.EsBlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchInActionApplicationTests {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Test
    public void contextLoads() {
    }

    @Before
    public void initRepository() {
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1", "��������̸̸��װ Elasticsearch", "��������̸̸��װ Elasticsearch",
                "�����������װ Elasticsearch������뿴�ҵĲ��� https://waylau.com"));
        esBlogRepository.save(new EsBlog("2", "��������̸̸ Elasticsearch �ļ����÷�", "��������̸̸ Elasticsearch �ļ����÷�",
                "����������� Elasticsearch�����ǵÿ��ҵĲ��� https://waylau.com����"));  // �ؼ���"��"
        esBlogRepository.save(new EsBlog("3", "��������һ��ѧ Elasticsearch", "��������һ��ѧ Elasticsearch",
                "�����ѧϰ Elasticsearch�����տ��ҵĲ��� https://waylau.com����")); // �ؼ���"��"

        esBlogRepository.save(new EsBlog("4", "03-05 �ô�׻����ķֲ�ʽϵͳ", "03-05 �ô�׻����ķֲ�ʽϵͳ",
                "һ���𡰷ֲ�ʽϵͳ������ҵĵ�һ�о����Ǻøߴ��ϰ�����ɲ�"));
        esBlogRepository.save(new EsBlog("5", "02-19 Thymeleaf 3 �������µĽ���ϵͳ", "02-19 Thymeleaf 3 �������µĽ���ϵͳ",
                "�����Ĵ���ʹ���� HTML5 �ı�׼����Thymeleaf �汾��ͣ���� 2.x ����ô���û�аѱպ�"));
        esBlogRepository.save(new EsBlog("6", "02-19 ʹ�� GFM Eclipse ���ʱ��������Ŀ�������� HTML �ļ�", "02-19 ʹ�� GFM Eclipse ���ʱ��������Ŀ�������� HTML �ļ�",
                "GFM �� GitHub Flavored Markdown Viewer �ļ�ƣ���һ��� GitHub �Ѻõ� Markdown �༭�� ��"));
    }

    @Test
    public void textFindDistinctEsBlog() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<EsBlog> ePage = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining("��", "��", "��", pageable);
        System.out.println(ePage.getTotalElements());
        System.out.println(ePage.getContent().get(0).toString());
        assertThat(ePage.getTotalElements()).isEqualTo(3);
    }

}
