package servlet;

import service.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        forward(request,response);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        //接收页面的值
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        //向页面传值
        request.setAttribute("command",command);
        request.setAttribute("description",description);
        ListService listService = new ListService();
        //查询消息列表并传给页面
        request.setAttribute("messageList",listService.queryMessageList(command,description));
        //跳转
        request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request,response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        forward(request,response);
    }
}
