package solveprojects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CountLines {
    private HashMap<String ,LinkedBag> map;
    public CountLines(){
        map=new HashMap<>();
    }
    public void readData(Scanner scanner){
        Scanner scanner2;
        int lineNumber=0;
    while(scanner.hasNext()){
        String line=scanner.nextLine();
        lineNumber++;
        scanner2=new Scanner(line);
        while(scanner2.hasNext()){
        String x=scanner2.next();
        if(map.containsKey(x)){
            LinkedBag bag=map.get(x);
            bag.addFirst(lineNumber);
        }else{
            LinkedBag bag=new LinkedBag();
            bag.addFirst(lineNumber);
            map.put(x, bag);
        }
        }
    }
    }
    public void display(){
        for (String x : map.keySet()) {
            System.out.print(x+" ");
            map.get(x).print();
            System.out.println();
        }
    }
}
