import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstFilter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("first filter destroy");
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("first filter start do filter");
        chain.doFilter(req,resp);//放行方法
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //请求重定向
        response.sendRedirect(request.getContextPath() + "/main.jsp");
        //请求转发
//        request.getRequestDispatcher("main.jsp").include(request,response);
        System.out.println("first filter End do filter");
    }

    public void init(javax.servlet.FilterConfig config) {
        System.out.println("first filter init");
    }

}
