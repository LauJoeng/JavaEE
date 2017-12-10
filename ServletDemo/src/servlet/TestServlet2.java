package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet2")
public class TestServlet2 extends HttpServlet {

    public TestServlet2(){
        super();
        System.out.println("test TestServlet2 constructor called");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("test TestServlet2 destroy method called");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("test TestServlet2 init method called");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test TestServlet2 doPost method called");
        doGet(request,response);//让doPost与doGet执行相同的操作
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//指定out的输出类型
        System.out.println("test TestServlet2 doGet method called");
        PrintWriter out = response.getWriter();
        out.println("<h1>我是TestServlet2</h1>");
    }
}
