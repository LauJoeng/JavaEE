1.什么是Ajax?  不用刷新页面，但可以和服务端进行通信的方式。使用Ajax的主要方式是XMLHttpRequest对象
2.使用XMLHttpRequest对象实现Ajax。【了解】
3.Ajax传输数据的三种方式:
- XML:笨重，解析困难。但XML是通用的数据交换格式
- HTML:不需要解析可以直接放到文档中。若仅更新一部分区域可以使用，但传输数据不是很方便，且HTML代码需要拼接完成
- JSON：小巧，有面向对象的特征，且有很多第三方的jar包可以把java对象或集合转为JSON字符串

4.load方法：可以用于HTML文档的元素节点，把结果直接加为对应元素的子元素。通常而言，load方法加载的数据是一个HTML片段

var $obj = ''''
var url = ...
var args = ...
$obj.load(url,args)

$.get, $post, $getJSON :更加灵活，除去使用load方法的情况，大部分时候都用这三个方法

 基本使用
 
//url:Ajax请求目标URL
//args:传递的参数
//data:Ajaxx响应成功后的数据，可能是XML,HTML,JSON
$.get(utl,args,function(){data})

请求json
$.get(url,args,function(data){},"JSON");

$.post(url,args,function(data){},"JSON");

$.getJSON(url,args,function(data){});


第三方Jar包Jackson

步骤:

- 创建org.codehaus.jackson.map.ObjectMapper对象
- 调用ObjectMapper的writeValueString方法把Java对象或集合转为JSON字符串 

```
ObjectMapper mapper = new ObjectMapper();
        //2调用Mapper对象的WriteValueString()方法把一个对象转为JSON字符串
        Customer customer = new Customer("Yang","1001");
        String jsonStr = mapper.writeValueAsString(customer);
        System.out.println(jsonStr);
```

注意:
Jackson根据getter方法来定位Json对象的属性，而不是字段！！！
可以在类的getter方法上添加注解:JsonIgnore。在转为JSON对象时可以忽略该属性
