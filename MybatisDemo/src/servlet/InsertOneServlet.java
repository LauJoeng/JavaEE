package servlet;

import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertOneServlet",urlPatterns = "/InsertOneServlet.action")
public class InsertOneServlet extends HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        forward(request,response);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        //接收页面的值
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        MaintainService maintainService = new MaintainService();
        maintainService.insertOne(command,description,content);
        //跳转
//        request.getRequestDispatcher("/List.action").forward(request,response);
        response.sendRedirect("/List.action");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        forward(request,response);
    }
}
