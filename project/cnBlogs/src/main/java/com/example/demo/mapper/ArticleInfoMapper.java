package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {

    public List<ArticleInfo> getAll();

    public List<ArticleInfo> getArticleInfo(String title,
                                            String content,
                                            int state);


    public int addArticle(String title, String content, int uid,
                          int rcount, int state);

    public List<ArticleInfo> getArticleInfo2(String title,
                                             String content,
                                             int state);

    public List<ArticleInfo> getArticleInfo3(String title,
                                             String content,
                                             int state);

    public int upArticle(int id, String title, String content);

    public int delArticleByIds(int[] ids);

    public int delById(int id);

    // 查询文章详情
    public ArticleInfo detail(int id);

    // 添加文章
    public int add(ArticleInfo articleInfo);
}
