package com.yang;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AsyncServlet",asyncSupported = true,value = {"/index.jsp"})
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AsyncContext asyncContext = request.startAsync();
//        asyncContext.getRequest();
//        asyncContext.getResponse();
        System.out.println("Servlet执行开始时间:"+new Date());
        new Thread(new Excutor(asyncContext)).start();
        System.out.println("Servlet执行结束时间:"+new Date());
    }

    public class Excutor implements Runnable{

        private AsyncContext context;
        public Excutor(AsyncContext context)
        {
            this.context = context;
        }

        @Override
        public void run() {
            //执行相关复杂业务
            try {
                System.out.println("业务执行开始时间"+new Date());
                Thread.sleep(1000*10);
//                context.getRequest()
                System.out.println("业务执行完成时间"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
