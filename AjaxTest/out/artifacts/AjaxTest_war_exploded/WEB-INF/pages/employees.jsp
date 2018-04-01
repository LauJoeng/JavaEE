<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/3/31
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.10.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.blockUI.js"></script>
    <script type="text/javascript">

        /*
        * 1.获取#city，添加change响应函数
        * 2.使#department只保留第一个option子结点
        * 3.获取#city选择的值，若该值为""，即选择的是“请选择...”，此时不需要发送Ajax请求
        * 4.若值不为""，说明的确是city发生了改变，准备Ajax请求
        * 4.1:url:EmployeeServlet?method=listDepartments
        * 4.2:args:locationId,time
        * 5.返回的是一个JSON数组
        * 5.1若返回的数组中元素为0，则提示：“当前城市没有部门
        * 5.2：若返回数组中元素不为0，遍历，创建<option value="departmentId">departmentName</option>,并把新创建
        * 的option节点加为#department的子结点*/
        $(function () {
            $(document).ajaxStart(function () {
                $.blockUI({
                    message: $('#loading'),
                    css: {
                        top:  ($(window).height() - 400) /2 + 'px',
                        left: ($(window).width() - 400) /2 + 'px',
                        width: '400px'
                    }
                });
            }).ajaxStop($.unblockUI);
            $("#city").change(function () {
                $("#department option:not(:first)").remove();
                var city = $(this).val();
                if(city!==""){
                    var url = "EmployeeServlet?method=listDepartments";
                    var args = {"locationId":city,time:new Date()};

                    $.getJSON(url,args,function (data) {
                        if(data.length == 0){
                            alert("当前城市没有部门");
                        }else{
                            for(var i=0;i<data.length;i++){
                                var deptId = data[i].departmentId;
                                var deptName = data[i].departmentName;

                                $("#department").append("<option value='"+deptId+"'>"+deptName+"</option>");
                            }
                        }
                    });
                }
            });
            
            $("#department").change(function () {
                $("#employee option:not(:first)").remove();
                var department = $(this).val();
                alert(department);
                if(department!=""){
                    var url = "EmployeeServlet?method=listEmployees";
                    var args = {"departmentId":department,"time":new Date()};

                    $.getJSON(url,args,function (data) {
                        if(data.length == 0){
                            alert("当前部门没有员工");
                        }else{
                            for(var i=0;i<data.length;i++){
                                var empId = data[i].employeeId;
                                var empName = data[i].lastName;

                                $("#employee").append("<option value='"+empId+"'>"+empName+"</option>");
                            }
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
    <img src="${pageContext.request.contextPath}/images/loading.jpg" style="display: none" id="loading">
    <center>
        <br><br>
        City
        <select id="city">
            <option value="">请选择...</option>
            <c:forEach items="${locations}" var="location">
                <option value="${location.locationId}">${location.city}</option>
            </c:forEach>
        </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            department
            <select id="department">
                <option value="">请选择...</option>
            </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            Employee:
        <select id="employee">
            <option value="">请选择...</option>
        </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <br><br>
        <table id="empdetails" border="1" cellspacing="5" style="display: none">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Salary</th>
            </tr>
            <tr>
                <td id="id"></td>
                <td id="name"></td>
                <td id="email"></td>
                <td id="salary"></td>
            </tr>
        </table>
    </center>
</body>
</html>
