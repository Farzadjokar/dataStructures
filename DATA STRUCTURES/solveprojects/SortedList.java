package solveprojects;
import java.util.ListIterator;

public class SortedList <T extends Comparable<? super T>>{
    private Node first;

    private class Node{
        Node next;
        T data;
    }


}
