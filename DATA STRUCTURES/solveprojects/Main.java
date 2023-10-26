package solveprojects;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
 char array[]={'A','B','C','D'};
 LinkedList<TreeNode> list=paranthesize(array, 0, array.length-1);
 for (TreeNode treeNode : list) {
     String postFix=getpostfix(treeNode);
     System.out.println(finalMethod(postFix));
 }
    }
 public static void backTrack(String x,char[] c,int b){
System.out.println(x);
for(int i=b;i<c.length;i++){
backTrack(x+c[i], c, b+1);
b++;
}
 }
public static void napSackSolver(LinkedList<Integer> list,int[] weights,int prices[],int b,int[] configure,int maxWeight,int otherWeight){
if(b==configure.length){
    int max=0;
 for (int i = 0; i < configure.length; i++) {
       max=max+prices[i]*configure[i];
 }
 list.add(max);
 return;
}
if(weights[b]<=otherWeight){
    configure[b]=1;
napSackSolver(list, weights, prices, b+1, configure, maxWeight, otherWeight-weights[b]);
}
configure[b]=0;
napSackSolver(list, weights, prices, b+1, configure, maxWeight, otherWeight);
}
public static void partitionProblem(int number,int otherNumber,Integer config[],int b){
if(b==config.length){
if(otherNumber==0){
    for(Integer integer:config){
        System.out.print(integer+" ");
    }
    System.out.println();
}
    return;
}
for(int i=number;i>=0;i--){
config[b]=i;
if(config[b]<=otherNumber){
    partitionProblem(number, otherNumber-config[b],config, b+1);
}
}
}
public static void solveSudoku(int [][]A,int counter,int i,int j){
    if(counter==A.length*A.length){
        for (int j2 = 0; j2 < A.length; j2++) {
            for (int k = 0; k < A.length; k++) {
                System.out.print(A[j2][k]);
            }
            System.out.println();
        }
        System.exit(1);
    }
    if(isNotZero(A[i][j])&&canPlace(A, i, j, A[i][j])){
         if(j+1==A.length){
            solveSudoku(A, counter+1,(i+1)%A.length, (j+1)%A.length);
         }else{
         solveSudoku(A, counter+1,i, (j+1)%A.length);
         }
    }
for (int j2 = 1; j2 <= A.length; j2++) {
if(canPlace(A, i, j, j2)){
    A[i][j]=j2;
    if(j+1==A.length){
        solveSudoku(A, counter+1,(i+1)%A.length, (j+1)%A.length);
     }else{
     solveSudoku(A, counter+1,i, (j+1)%A.length);
     }
}
}
} 
public static boolean canPlace(int array[][],int i,int j,int key){
    boolean flag1=true;
    for (int k = 0; k < array.length; k++) {
        if(k!=j){
          if(array[i][k]==key){
              flag1=false;
              return flag1;
          }
        }
    }
    for (int k = 0; k < array.length; k++) {
        if(k!=i){
          if(array[k][j]==key){
              flag1=false;
              return flag1;
          }
        }
    }
    return true;
}
public static boolean isNotZero(int a){
    return a!=0;
}
public static void nQueenSolver(int array[],int b){
    if(b==array.length){
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+" "+array[i]);
        }
        System.out.println("----------------------");
        return;
    }
   for (int i = 0; i < array.length; i++) {
    array[b]=i;
    if(canPlace2(array,b)){
        nQueenSolver(array, b+1);
    }
   }
}
public static boolean canPlace2(int array[],int b){
     boolean flag=false;
     for (int i = 0; i < b; i++) {
        if(array[i]==array[b]){
            return flag;
        }
     }
     for (int i = 0; i < b; i++) {
        if(Math.abs(array[i]-array[b])==Math.abs(i-b)){
            return flag;
        }
     }
     return true;
}
public static LinkedList<TreeNode> paranthesize(char []array,int i,int j){
  if(i==j){
    TreeNode node=new TreeNode();
    node.x=array[i];
    LinkedList<TreeNode> nodes=new LinkedList<>();
    nodes.add(node);
    return nodes;
   }
   if(i+1==j){
         TreeNode root=new TreeNode();
         TreeNode left=new TreeNode();
         TreeNode right=new TreeNode();
      left.x=array[i];
      right.x=array[j];
      root.x='.';
      root.leftNode=left;
      root.rightNode=right;
      LinkedList<TreeNode> nodes=new LinkedList<>();
    nodes.add(root);
    return nodes;
   }
   LinkedList<TreeNode> list1=new LinkedList<>();
   LinkedList<TreeNode> list2=new LinkedList<>();
   LinkedList<TreeNode> list3=new LinkedList<>();
   for (int k = i; k <j; k++) {
      list1=paranthesize(array,i, k);
      list2=paranthesize(array, k+1, j);
      list3.addAll(merge(list1, list2));
   }
   return list3;
}
public static LinkedList<TreeNode> merge(LinkedList<TreeNode> list1,LinkedList<TreeNode> list2){
    LinkedList<TreeNode> list3=new LinkedList<>();
    for (TreeNode treeNode : list1) {
        for (TreeNode treeNode2 : list2) {
            TreeNode root=new TreeNode();
            root.x='.';
            root.leftNode=treeNode;
            root.rightNode=treeNode2;
            list3.add(root);
        }
    }
    return list3;
}
public static void print(TreeNode node,String space){
    if(node==null){
        return ;
    }
    space+="    ";
   print(node.rightNode, space);
   System.out.println(space+node.x);
   print(node.leftNode, space);
}
public static String getpostfix(TreeNode root){
    if(root==null){
       return new String();
    }
  String x=  getpostfix(root.leftNode);
   String y= getpostfix(root.rightNode);
    return x+y+root.x;
}
public static String finalMethod(String postfix){
Stack<String> stack=new Stack<>();
int i=0;
while(i<postfix.length()){
    Character c=postfix.charAt(i);
    if(Character.isLetter(c)){
        stack.push(c.toString());
    }else{
        String c1=stack.pop();
        String c2=stack.pop();
        String newString="("+c2+c1+")";
        stack.push(newString);
    }
    i++;
}
return stack.peek();
}
}
