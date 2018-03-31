package com.yang.ajaxtest.servlet;

import com.yang.ajaxtest.bean.Location;
import com.yang.ajaxtest.dao.BaseDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String methodName = req.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BaseDao baseDao = new BaseDao();

    protected void listLocations(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String sql = "SELECT location_id locationId,city FROM locations";
        List<Location> locations = baseDao.getForList(sql,Location.class);
        req.setAttribute("locations",locations);
        req.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(req,resp);
    }
}
