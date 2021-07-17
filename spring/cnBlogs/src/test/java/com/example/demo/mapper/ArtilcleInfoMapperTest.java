package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArtilcleInfoMapperTest {
    @Resource
    private ArtilcleInfoMapper artilcleInfoMapper;

    @Test
    void getAll() {
        List<ArticleInfo> list=artilcleInfoMapper.getAll();
        list.forEach(System.out::println);
    }
}