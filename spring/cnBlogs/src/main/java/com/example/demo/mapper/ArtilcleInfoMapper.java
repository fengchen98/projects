package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtilcleInfoMapper {
    public List<ArticleInfo> getAll();

    public List<ArticleInfo> getArticleInfo(String title,String content,int state);
}
