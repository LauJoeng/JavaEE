package servlet;

import service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 批量删除控制层
 */
@WebServlet(name = "DeleteBatchServlet",urlPatterns = "/DeleteBatchServlet.action")
public class DeleteBatchServlet extends HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        forward(request,response);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        //接收页面的值
        String[] ids = request.getParameterValues("id");
        MaintainService maintainService = new MaintainService();
        maintainService.deleteBatch(ids);
        //跳转
        request.getRequestDispatcher("/List.action").forward(request,response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        forward(request,response);
    }
}
