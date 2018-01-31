package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MessageHandler implements InvocationHandler{
    /**
     *
     * @param proxy 方法调用的代理实例
     * @param method 接口的方法的class
     * @param args 接口方法的参数数组
     * @return 接口方法返回对象的类型
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("通过接口与method获取对应配置文件中的信息");
        System.out.println("接口名称.方法名==namespace.id");
        System.out.println("通过配置文件中的信息获取sql语句的类型");
        System.out.println("根据sql语句类型调用sqlSession对应的增删改查方法");
        System.out.println("当sql语句为查询时：");
        System.out.println("根据返回值类型是List,Map,Object");
        System.out.println("分别调用selectList、selectMap、selectObject方法");
        //返回查询结果
        System.out.println(method.getName());
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }
}
