import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "SecondFilter")
public class SecondFilter implements Filter {
    public void destroy() {
        System.out.println("second filter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("second filter start do filter");
        chain.doFilter(req,resp);
        System.out.println("second filter End do filter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("second init");
    }

}
