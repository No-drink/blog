package com.joey.web;

import com.joey.pojo.Blog;
import com.joey.service.BlogService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private  BlogService service = new BlogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用BlogService完成查询
        List<Blog> Blogs = service.selectAll();

        //2. 存入request域中
        request.setAttribute("Blogs",Blogs);

        //3. 转发到Blog.jsp
        request.getRequestDispatcher("/Blog.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}