package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String picCode = (String) req.getSession().getAttribute("picCode");
        String checkCode = req.getParameter("checkCode");
        checkCode = checkCode.toUpperCase();
        PrintWriter out = resp.getWriter();
        if (checkCode.equals(picCode)){
            out.println("验证码正确");
        }else{
            out.println("验证码错误!");
        }
        out.flush();
        out.close();
    }
}
