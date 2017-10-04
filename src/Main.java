import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Map<String,String> map = new HashMap<>();
        map.put("1","2");
        System.out.println(map.get("1"));
        System.out.println(map.values());
    }
}
