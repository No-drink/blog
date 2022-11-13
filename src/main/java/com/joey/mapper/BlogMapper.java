package com.joey.mapper;

import com.joey.pojo.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogMapper {

    @Select("select * from tb_blog")
    List<Blog> selectAll();
}
