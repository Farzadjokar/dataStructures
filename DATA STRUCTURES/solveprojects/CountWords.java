package solveprojects;
import java.util.HashMap;
import java.util.Scanner;

public class CountWords {
    HashMap<String,Integer> map;
    public CountWords(){
        map=new HashMap<>();
    }
    @Deprecated
    public void readData(Scanner scanner){
while(scanner.hasNext()){
    String string=scanner.next();
    if(map.containsKey(string)){
        Integer integer=map.get(string);
        map.replace(string,++integer);
    }else{
        map.put(string, new Integer(1));
    }
}
    }
    public  void display(){
        for (String x:map.keySet()) {
            System.out.println(x+"  "+map.get(x));
        }
    }
}
