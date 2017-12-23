import com.yang.entity.User1;

import java.util.ArrayList;

public class SessionUtil {
    public static Object getUserBySessionId(ArrayList<User1> user1List, String sessionId){
        for (int i = 0; i< user1List.size(); i++){
            User1 user1 = user1List.get(i);
            if (user1.getSessionString().equals(sessionId)){
                return user1;
            }
        }
        return null;
    }
}
