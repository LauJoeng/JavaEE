package com.yang.controller.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.bean.Ad;
import com.yang.bean.BusinessList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {


    @RequestMapping(value = "/homead",method = RequestMethod.GET)
    public List<Ad>homead() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "[\n" +
                "    {\n" +
                "        \"title\": \"暑假5折\",\n" +
                "        \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191639092-2000037796.png\",\n" +
                "        \"link\": \"http://www.imooc.com/wap/index\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"特价出国\",\n" +
                "        \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191648124-298129318.png\",\n" +
                "        \"link\": \"http://www.imooc.com/wap/index\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"亮亮车\",\n" +
                "        \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191653983-1962772127.png\",\n" +
                "        \"link\": \"http://www.imooc.com/wap/index\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"学钢琴\",\n" +
                "        \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191700420-1584459466.png\",\n" +
                "        \"link\": \"http://www.imooc.com/wap/index\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"电影\",\n" +
                "        \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191706733-367929553.png\",\n" +
                "        \"link\": \"http://www.imooc.com/wap/index\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"旅游热线\",\n" +
                "        \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191713186-495002222.png\",\n" +
                "        \"link\": \"http://www.imooc.com/wap/index\"\n" +
                "    }\n" +
                "]";
        return mapper.readValue(s, new TypeReference<List<Ad>>(){});
    }


    @RequestMapping(value = "/homead/{city}/{page}",method = RequestMethod.GET)
    public BusinessList homeList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\n" +
                "    \"hasMore\": true,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201638030-473660627.png\",\n" +
                "            \"title\": \"汉堡大大\",\n" +
                "            \"subTitle\": \"叫我汉堡大大，还你多彩口味\",\n" +
                "            \"price\": \"28\",\n" +
                "            \"distance\": \"120m\",\n" +
                "            \"mumber\": \"389\",\n" +
                "            \"id\": \"5622455772948411\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\n" +
                "            \"title\": \"北京开源饭店\",\n" +
                "            \"subTitle\": \"[望京]自助晚餐\",\n" +
                "            \"price\": \"98\",\n" +
                "            \"distance\": \"140m\",\n" +
                "            \"mumber\": \"689\",\n" +
                "            \"id\": \"13270181943298143\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201652952-1050532278.png\",\n" +
                "            \"title\": \"服装定制\",\n" +
                "            \"subTitle\": \"原价xx元，现价xx元，可修改一次\",\n" +
                "            \"price\": \"1980\",\n" +
                "            \"distance\": \"160\",\n" +
                "            \"mumber\": \"106\",\n" +
                "            \"id\": \"12459342812654683\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201700186-1351787273.png\",\n" +
                "            \"title\": \"婚纱摄影\",\n" +
                "            \"subTitle\": \"免费试穿，拍照留念\",\n" +
                "            \"price\": \"2899\",\n" +
                "            \"distance\": \"160\",\n" +
                "            \"mumber\": \"58\",\n" +
                "            \"id\": \"32740762067006046\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"img\": \"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201708124-1116595594.png\",\n" +
                "            \"title\": \"麻辣串串烧\",\n" +
                "            \"subTitle\": \"双人免费套餐等你抢购\",\n" +
                "            \"price\": \"0\",\n" +
                "            \"distance\": \"160\",\n" +
                "            \"mumber\": \"1426\",\n" +
                "            \"id\": \"12600862426171489\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return mapper.readValue(s, new TypeReference<List<BusinessList>>(){});
    }

    @RequestMapping(value = "/submitComment",method = RequestMethod.POST)
    public Map<String,Object> submitComment(){
        Map<String,Object>result = new HashMap<>();
        result.put("error",0);
        result.put("msg","ok");
        return  result;
    }

}
