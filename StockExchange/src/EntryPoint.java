import java.util.*;
import java.util.stream.Collectors;

public class EntryPoint {
    public static void main(String[] args){
        //StockExchange se = StockExchange.getInstance();
        //se.getRepos();
        Map<String, Integer> map = new HashMap<>();
        map.put("123", 4);
        map.put("dsjjkds", 6);
        map.put("ooskds", 9);
        map.put("iocbns", 7);
        map.put("iocbnds8sd", 7);
        List<String> res = map.entrySet().stream().filter((k) -> k.getKey().length() > 3).map(s -> s.getKey()).collect(Collectors.toList());
        /*
        for (String s: res){
            System.out.println(s);
        }
        */
        String[] s = {"123", "456", "dsa", "dfd"};
        List<String> x = Arrays.asList(s);
        LinkedList<String> l = new LinkedList<>(x);
        String word = l.pollFirst();
        System.out.println(word + " " + l.size());
        while (word != null){
            word = l.pollFirst();
            System.out.println(word + " " + l.size());
        }
    }
}
