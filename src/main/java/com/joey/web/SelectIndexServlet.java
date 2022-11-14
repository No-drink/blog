package com.joey.web;

import com.joey.pojo.Blog;
import com.joey.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectIndexServlet")
public class SelectIndexServlet extends HttpServlet {
    private BlogService service = new BlogService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用BlogService完成查询
        Blog blog = service.selectIndex(Integer.parseInt(request.getParameter("index")));

        String md = blog.getText();
        String html = service.convert(md);
        blog.setText(html);

        //2. 存入request域中
        request.setAttribute("blog", blog);

        //3. 转发到single_blog.jsp
        request.getRequestDispatcher("/single_blog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
