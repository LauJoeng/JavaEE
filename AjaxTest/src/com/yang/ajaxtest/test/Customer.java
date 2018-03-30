package com.yang.ajaxtest.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Customer {
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity(){
        return "BeiJing";
    }

    public String getBirth(){
        return "1999-07-08";
    }

    public static void main(String[] args) throws JsonProcessingException {

        //1创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //2调用Mapper对象的WriteValueString()方法把一个对象转为JSON字符串
        Customer customer = new Customer("Yang","1001");
        String jsonStr = mapper.writeValueAsString(customer);
        System.out.println(jsonStr);

        //注意:Jackson使用getter方法来定位JSON对象属性!!!
        //可以通过添加注解org.codehaus.jackson.annotate.JsonIgnore忽略某一个定义的属性

        List<Customer>customers = Arrays.asList(customer,new Customer("BSA","2009"));
        jsonStr = mapper.writeValueAsString(customers);
        System.out.println(jsonStr);
    }

}
