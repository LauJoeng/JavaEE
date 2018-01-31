package proxyTest;

import java.util.ArrayList;
import java.util.List;

public class QueryMessage implements IMessage{
    @Override
    public List<Object> query(Object parameter) {
        List<Object>list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return list;
    }
}
