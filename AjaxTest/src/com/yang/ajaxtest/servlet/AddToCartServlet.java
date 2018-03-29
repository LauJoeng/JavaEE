package com.yang.ajaxtest.servlet;

import com.yang.ajaxtest.bean.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/app2/AddToCartServlet","/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数：id,price
        String bookName = req.getParameter("id");
        int price = Integer.parseInt(req.getParameter("price"));
        //获取购物车对象
        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("sc");

        if (cart==null){
            cart = new ShoppingCart();
            session.setAttribute("sc",cart);
        }
        //把点击的选项加入到购物车内
        cart.addToCart(bookName,price);
        //准备响应的JSON对象
        //如果服务器端返回JSON字符串，则属性名必须使用双引号
        StringBuilder result = new StringBuilder();
        result.append("{")
                .append("\"bookName\":").append("\"").append(bookName).append("\"")
                .append(",")
                .append("\"totalBookNumber\":").append(cart.getTotalBookNumber())
                .append(",")
                .append("\"totalMoney\":").append(cart.getTotalMoney())
                .append("}");
        //响应JSON
        resp.setContentType("text/javascript");
        resp.getWriter().print(result.toString());
    }
}
