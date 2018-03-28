package com.yang.ajaxtest.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ValidateServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<String>userNames = Arrays.asList("AAA","BBB","CCC");
        String userName = request.getParameter("userName");
        String result = null;
        if(userNames.contains(userName)){
            result = "<font color='red'>该用户名已被使用</font>";
        }else{
            result = "<font color='green'>该用户名可以使用</font>";
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(result);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
