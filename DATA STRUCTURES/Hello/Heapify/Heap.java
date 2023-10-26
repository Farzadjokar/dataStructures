package Hello.Heapify;

public class Heap <T extends Comparable<? super T>>{
    private T array[];
    int numberOfEntries;
    
    public Heap(int capacity){

        @SuppressWarnings("unchecked")
        T[] array=(T[]) new Comparable[capacity];
        this.array=array;
        numberOfEntries=0;
    }

    private int getFather(int index){
        return index/2;
    }
    private int getRightChild(int index){
        return index*2+1;
    }
    private int getLeftChild(int index){
        return index*2;
    }
    public boolean add(T data){
     boolean isAdded=false;
     if(this.isFull()){
      return isAdded;
     }else{
        numberOfEntries++;
        array[numberOfEntries]=data;
        heapify();
        return true;
     }
    }
    private void heapify(){
      int temp  =  numberOfEntries;
      T tempData=array[numberOfEntries];
        while(temp>1 && tempData.compareTo(array[getFather(temp)])>0){
        array[temp]=array[getFather(temp)];
        temp=getFather(temp);
        }
        array[temp]=tempData;
    }
    public boolean delete(){
    if(isEmpty()){
        return false;
    }else{
     array[1]=array[numberOfEntries];
     reHeap();
     numberOfEntries--;
     return true;
    }
    }
    public void reHeap(){
        boolean isDone=false;
        int leftChildIndex=getLeftChild(1);
        int largestChildIndex=leftChildIndex;
        int root=1;
        T temp=array[root];
         while(isDone==false && leftChildIndex<=numberOfEntries){
            int rhigtChildIndex=leftChildIndex+1;
            if(rhigtChildIndex<=numberOfEntries && array[rhigtChildIndex].compareTo(array[largestChildIndex])>0){
                    largestChildIndex=rhigtChildIndex;
            }
           if(array[largestChildIndex].compareTo(temp)<0){
            isDone=true;
           }else{
            array[root]=array[largestChildIndex];
            root=largestChildIndex;
            array[root]=temp;
            leftChildIndex=getLeftChild(root);
            largestChildIndex=leftChildIndex;
           }
        }
    }

    public boolean isFull(){
        return numberOfEntries==array.length-1;
    }
    public boolean isEmpty(){
        return numberOfEntries==0;
    }
    public void printHeap(){
        for (int i = 1; i <=numberOfEntries; i++) {
            System.out.print(array[i]);
        }
    }
}
