package GraphAlgorithms;

import java.util.LinkedList;

public class Vertex<T>{
   private LinkedList<Edge> listNeibors;
   private T label;
    private boolean isVisited;
   private Vertex<T> parentVertex;
    private double cost;
   public Vertex(){
    listNeibors=new LinkedList<>();
    isVisited=false;
    parentVertex=null;
    cost=Integer.MAX_VALUE;
    label=null;
   }
   public void setLabel(T label){
this.label=label;
   }
   public boolean connect(double weight,Vertex<T> endVertex){
    if(endVertex!=this ){
       Edge edge=new Edge();
       edge.weight=weight;
       edge.endVertex=endVertex;
       if(!listNeibors.contains(edge)){
            listNeibors.add(edge);
            return true;
       }
    }
    return false;
   }
   public boolean hasNeibors(){
    return !listNeibors.isEmpty();
   }
   public Vertex<T> getUnvisitedNeibor(){
    for (Edge edge : listNeibors) {
        if(edge.endVertex.isVisited==false){
            return edge.endVertex;
        }
    }
return null;
   }
   @Override
   public boolean equals(Object vertex){
    if(vertex==null || vertex.getClass()==this.getClass()){
        return false;
     }else{
        @SuppressWarnings("unchecked")
      Vertex<T> vertex2=(Vertex<T>)vertex;
        return this.label.equals(vertex2.label);
     }
   }
 public T getLabel(){
    return this.label;
 }
 public void visit(){
    isVisited=true;
 }
 public void unVisit(){
    isVisited=false;
 }
 public boolean isVisited(){
    return isVisited;
 }
 public void setPredecessor(Vertex<T> parrent){
parentVertex=parrent;
 }
 public Vertex<T> getPredecessor(){
return this.parentVertex;
 }
 public boolean hasPredecessor(){
    return (this.parentVertex!=null);
 }
 public void setcost(double cost){
    this.cost=cost;
 }
 public double getCost(){
    return this.cost;
 }
    private class Edge{
        Vertex endVertex;
        double weight;

        @Override
        public boolean equals(Object edge){
            @SuppressWarnings("unchecked")
            Edge edge2=(Edge) edge;
            return edge2.endVertex==this.endVertex;
        }
    }
}