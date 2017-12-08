import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            set.addAll(Arrays.asList(arr));
        }
        System.out.println(set.size());
        set.clear();
    }
}
