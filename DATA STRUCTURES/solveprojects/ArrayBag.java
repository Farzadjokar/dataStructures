package solveprojects;
public class ArrayBag<T> implements BagInterface<T>{
    private T array[];
    private int numberOfEntries;
    private static final int difaultCapacity=25;
    public ArrayBag(){
this(difaultCapacity);
    }
    public ArrayBag(int capacity){
        @SuppressWarnings("unchecked")
      T[] newarray=(T[])new Object[capacity];
      array=newarray;
      numberOfEntries=0;
    }
    public boolean isFull(){
        if(numberOfEntries==array.length){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(T newEntry){
        if(isFull()){
            return false;
        }else{
            array[numberOfEntries]=newEntry;
            numberOfEntries++;
            return true;
        }
    }
    public boolean isEmpty(){
        if(numberOfEntries==0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public int getSize(){
        return numberOfEntries;
    }
    @Override
    public T[] toArray(){
        if(isEmpty()){
            return null;
        }
        @SuppressWarnings("unchecked")
    T[] newArray=(T[]) new Object[numberOfEntries];
for(int i=0;i<newArray.length;i++){
    newArray[i]=array[i];
}
return newArray;
    }
    public T remove(){
        if(isEmpty()){
            return null;
        }
        return array[numberOfEntries--];
    }
    public boolean remove(T entry){
int index=getIndex(entry);
array[index]=null;
for(int i=index+1;i<numberOfEntries;i++){
    array[i-1]=array[i];
}
numberOfEntries--;
return true;
    }
    public int getIndex(T entry){
    for(int i=0;i<numberOfEntries;i++){
        if(array[i].equals(entry)){
            return i;
        }
    }
    return -1;
    }
    public int getFrequencyOf(T entry){
        int counter=0;
        for(int i=0;i<numberOfEntries;i++){
if(array[i].equals(entry)){
    counter++;
}
        }
        return counter;
    }
    public void clear(){
        numberOfEntries=0;
    }
}
