package solveprojects;
import java.util.Stack;

public class Expresions {
    public static void main(String[] args) {
        System.out.println(evaluteParathesize("(){(()){}}"));
    }
    public static boolean evaluteParathesize(String exp){
        Stack<Character> stack=new Stack<Character>();
        int counter=0;
        while(counter<exp.length()){
            char x=exp.charAt(counter);
            switch(x){
                case '(':case '[': case '{':
                     stack.push(x);
                     break;
                case ')': case '}': case ']':
                     char previos=stack.peek();
                     if(x==isOposite(previos)){
                          stack.pop();
                     }else{
                        return false;
                     }break;
                default:break;
            }
            counter++;
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
    public static char isOposite(char x){
        if(x=='('){
            return ')';
        }
        else if(x=='{'){
            return '}';
        }else{
            return ']';
        }
    }

}
