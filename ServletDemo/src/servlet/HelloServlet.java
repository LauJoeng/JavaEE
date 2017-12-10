package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("处理POST请求...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");//指定out的输出类型
        out.println("<strong>hello servlet</strong><br>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("处理GET请求...");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");//指定out的输出类型
        out.println("<strong>hello servlet</strong><br>");
    }
}
