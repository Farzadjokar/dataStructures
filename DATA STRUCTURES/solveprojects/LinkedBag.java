package solveprojects;
import java.util.Iterator;

public class LinkedBag implements Iterable<Integer>,Iterator<Integer>{
    Node first;
    Node node;
    int counter=0;
public void addFirst(int data){
if(first==null){
    first=new Node();
    first.data=data;
}else{
    Node newNode=new Node();
    newNode.data=data;
    newNode.next=first;
    first=newNode;
}
}
public void print(){
    Node temp=first;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp=temp.next;
    }
}

public boolean isEmpty(){
    return first==null;
}

public int remove(Node entry){
if(entry==first){
    int data=first.data;
    first=first.next;
    return data;
}
    Node tempNode=first;
    while(tempNode.next!=entry){
        tempNode=tempNode.next;
    }
    int data=tempNode.next.data;
tempNode=tempNode.next.next;
return data;
}
    private class Node{
     Node next;
     int data;
    }
    @Override
public Iterator<Integer> iterator(){
return this;
}

@Override
public Integer next(){
    if(hasNext()){
        Integer data=node.data;
        node=node.next;
        return data;
    }
    throw new UnsupportedOperationException();
}
public void reset(){
    node=first;
}

@Override
public boolean hasNext(){
return node!=null;
}
public void remove(){
    throw new UnsupportedOperationException();
}
public void riverseLinkedList(){
    Node temp1=first;
    Node temp2=temp1.next;
    Node temp3=temp2.next;
    temp1.next=null;
do{
temp2.next=temp1;
temp1=temp2;
temp2=temp3;
if(temp2==null){
    break;
}
temp3=temp2.next;
}while(temp2!=null);
first=temp1;
}
public void insertionSort(){
    if(first.next==null){
        return;
    }
Node temp1=first.next;
Node temp2=temp1.next;
first.next=null;
while(temp1!=null){
temp1.next=null;
insert(temp1);
temp1=temp2;
if(temp1==null){
    break;
}
temp2=temp1.next;
}
}
private void insert(Node entry){
    if(entry.data<first.data){
        entry.next=first;
        first=entry;
        return;
    }
Node temp=first;
while(temp.next!=null && entry.data>temp.next.data){
    temp=temp.next;
}
entry.next=temp.next;
temp.next=entry;
}
public void insert(int data){
first=insertRicursively(data, first);
}
public Node insertRicursively(int data,Node first){
if(first==null || data<=first.data){
    Node newNode=new Node();
    newNode.data=data;
    newNode.next=first;
    first=newNode;
}else{
      Node nodeAfter=insertRicursively(data, first.next);
      first.next=nodeAfter;
}
return first;
}
public void delete(int data){
    if(data==first.data){
first=first.next;
    }else{
 deleteRicursively(data,first);
}
}
public void deleteRicursively(int data,Node first){
    if(first.next.data==data){
    first.next=first.next.next;
    return;
    }else{
     deleteRicursively(data, first.next);
    }
    
}
}

