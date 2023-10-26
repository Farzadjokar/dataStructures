package Hello;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
     int array[]={9,8,7,6,5,4,3,2,1};
        heapSort(array);
        System.out.println(Arrays.toString(array));   
    }
    public static void heapSort(int array[]){
        int lastIndex=array.length-1;
        for(int j=lastIndex;j>0;j--){
      for (int i = (int)Math.ceil((double)j/2)-1; i>=0; i--) {
        Heaper(array,i,j);
      }
      int temp=array[0];
      array[0]=array[j];
      array[j]=temp;
    }
    }
    public static void Heaper(int array[],int rootIndex,int lastIndex){
    int root=array[rootIndex];
    int bigestIndex=2*rootIndex+1;
    while(bigestIndex<=lastIndex){
        int anotherChildIndex=bigestIndex+1;
        if(anotherChildIndex<=lastIndex && array[anotherChildIndex]>array[bigestIndex]){
            bigestIndex=anotherChildIndex;
        }
      if(array[bigestIndex]>root){
        array[rootIndex]=array[bigestIndex];
        array[bigestIndex]=root;
        rootIndex=bigestIndex;
        bigestIndex=rootIndex*2+1;
      }else{
        return;
      }
    }
    }
}
