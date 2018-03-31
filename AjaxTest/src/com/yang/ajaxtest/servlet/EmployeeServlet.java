package com.yang.ajaxtest.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.ajaxtest.bean.Department;
import com.yang.ajaxtest.bean.Employee;
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

    protected void listDepartments(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       String locationId = req.getParameter("locationId");
//       System.out.println(locationId);
       String sql = "SELECT department_id departmentId,department_name departmentName FROM departments d " +
               "WHERE d.location_id = ?";
       List<Department>departments = baseDao.getForList(sql,Department.class,Integer.parseInt(locationId));
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(departments);
        System.out.println(result);
        resp.setContentType("text/javascript");
        resp.getWriter().print(result);
    }

    protected void listEmployees(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String deptId = req.getParameter("departmentId");
//        System.out.println(deptId);
        String sql = "SELECT employee_id employeeId,last_name lastName,email ,salary from employees " +
                "where department_id = ?";
        List<Employee>employees = baseDao.getForList(sql,Employee.class,Integer.parseInt(deptId));
        String result = new ObjectMapper().writeValueAsString(employees);
        System.out.println(result);
        resp.setContentType("text/javascript");
        resp.getWriter().print(result);
    }
}
