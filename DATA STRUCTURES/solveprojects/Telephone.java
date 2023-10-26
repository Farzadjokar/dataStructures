package solveprojects;
import java.util.HashMap;
import java.util.Scanner;
public class Telephone {
  private  HashMap<String,String> telephone;
 public Telephone(){
    telephone=new HashMap<>();
 }
    public void add(String key,String value){
      if(telephone.containsKey(key)){
        System.out.println("Hello world");
      }else{
        telephone.put(key, value);
      }
    }
    public void display(){
      for(String x:telephone.keySet()){
          System.out.println(x+"  "+telephone.get(x));
      }
    }
    public void readData(Scanner scanner){
        scanner.useDelimiter("");
       while(scanner.hasNext()){
         String x=scanner.next();
         String number=scanner.next();
         telephone.put(x, number);
       }

    }
}
