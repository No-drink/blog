package com.joey.service;

import com.joey.mapper.BlogMapper;
import com.joey.pojo.Blog;
import com.joey.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BlogService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Blog> selectAll(){

        SqlSession sqlSession = factory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = mapper.selectAll();
        sqlSession.close();
        return blogs;

    }
}
