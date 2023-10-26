package GraphAlgorithms;

import java.util.HashMap;

public class Graph <T>{
    
    private int edgeCount;
    private HashMap<T,Vertex<T>> map;
    public Graph(){
        edgeCount=0;
       this.map=new HashMap<>();
    }
   public boolean addVertex(T label){
    Vertex<T> vertex=new Vertex<>();
    vertex.setLabel(label);
   return map.put(label,vertex )==null;
   }
public boolean addedge(T first,T end,int weight){
    Vertex<T> firVertex=map.get(first);
    Vertex<T> eceVertex=map.get(end);
    if(firVertex!=null && eceVertex!=null){
        firVertex.connect(weight,eceVertex );
        edgeCount++;
        return true;
    }
    return false;
   }

}
