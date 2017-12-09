import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AsyncFilter",value = {"/com.yang.AsyncServlet"},dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.ASYNC},asyncSupported = true)
public class AsynFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("start filter");
        chain.doFilter(req, resp);
        System.out.println("end filter");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
