package solveprojects;
import java.util.Arrays;

public class Sorts {
    public static void main(String[] args) {
 Doctor doctor=new Doctor();
 doctor.salary=1000;
 Employ employ =new Employ();
 employ.salary=10010;
 Worker []workers={employ,doctor};
 for(Worker worker : workers) {
    System.out.println(worker.salary);
 }
    }
    public static <T extends Comparable<? super T>> void bubleSort(T [] array){
for(int i=0;i<array.length-1;i++){
    for (int j = 0; j < array.length-i-1; j++) {
        if(array[j].compareTo(array[j+1])>0){
            T temp=array[j];
            array[j]=array[j+1];
            array[j+1]=temp;
        }
    }
}
    }
    public static <T extends Comparable<? super T>> void selcetionSort(T array[]){

              for (int i = 0; i < array.length; i++) {
                int min_index=i;
                for (int j = i; j < array.length; j++) {
                    if(array[min_index].compareTo(array[j])>0){
                          min_index=j;
                    }
                }
                T temp=array[i];
                array[i]=array[min_index];
                array[min_index]=temp;
              }
    }
    public static void insertionSort(int array[]){
         for (int i = 1; i < array.length; i++) {
            int key=array[i];
            int j=i;
            while(j>0 && array[j-1]>key){
               array[j]=array[j-1];
                j--;
            }
            array[j]=key;
         }
    }
    public static void merge(int array[],int start,int mid,int end){
        int leftArray[]=new int[mid-start+1];
        int rightArray[]=new int[end-mid];
        for (int i = 0,j=start; i < leftArray.length; i++,j++) {
            leftArray[i]=array[j];
        }
        for (int i = 0,j=leftArray.length+start; i < rightArray.length; i++,j++) {
            rightArray[i]=array[j];
        }
int index1=start;
int index2=0;
int index3=0;
while(index2<leftArray.length && index3<rightArray.length){
    if(leftArray[index2]>rightArray[index3]){
        array[index1]=rightArray[index3];
        index3++;
    }else{
       array[index1]=leftArray[index2];
       index2++;
    }
    index1++;
}
if(index2==leftArray.length){
    while(index3<rightArray.length){
    array[index1]=rightArray[index3];
    index1++;
    index3++;
}
}else{
    while(index2<leftArray.length){
        array[index1]=leftArray[index2];
        index1++;
        index2++;
    }
}
    }
    public static void mergeSort(int array[],int start,int end){
     if(start>=end){
        return;
     }
     int mid=start+(end-start)/2;
     mergeSort(array, start,mid);
     mergeSort(array, mid+1, end);
     merge(array,start,mid,end);
    }
    public static int getPivoteIndex(int array[],int start,int end){
int pivote_index=end;
end--;
while(start<=end){
    while(start<=end &&array[start]<array[pivote_index]){
        start++;
    }
    while(start <=end && array[end]>array[pivote_index]){
        end--;
    }
    if(start>=end){
        break;
    }
    int temp=array[start];
    array[start]=array[end];
    array[end]=temp;
    start++;
    end--;
}
while(array[start]<array[pivote_index]){
    start++;
}
int temp=array[start];
array[start]=array[pivote_index];
array[pivote_index]=temp;
pivote_index=start;
return pivote_index;
    }
    public static void quickSort(int array[],int start,int end){
if(start>=end){
    return;
}
int pivote_index=getPivoteIndex(array, start, end);
quickSort(array, start, pivote_index-1);
quickSort(array, pivote_index+1, end);
    }
}
