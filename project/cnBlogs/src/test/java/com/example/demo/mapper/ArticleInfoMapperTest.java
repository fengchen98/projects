package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Transactional
class ArticleInfoMapperTest {

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void getAll() {
        List<ArticleInfo> list = articleInfoMapper.getAll();
        list.forEach(System.out::println);
    }

    @Test
    void getArticleInfo() {
        List<ArticleInfo> list = articleInfoMapper.getArticleInfo(null,
                null, 0);
        list.forEach(System.out::println);
    }

    @Test
    void getArticleInfo2() {
        List<ArticleInfo> list = articleInfoMapper.getArticleInfo2("今天星期天",
                "今天上课了", 0);
        list.forEach(System.out::println);
    }

    @Test
    void addArticle() {
        articleInfoMapper.addArticle("今天星期天", "今天上课了", 1,
                1, 0);
    }

    @Test
    void getArticleInfo3() {
        List<ArticleInfo> list = articleInfoMapper.getArticleInfo3(null,
                null, 0);
        list.forEach(System.out::println);
    }



    @Test
    void delArticleByIds() {
        int result = articleInfoMapper.delArticleByIds(new int[]{1, 2, 3});
        System.out.println(result);
    }
}