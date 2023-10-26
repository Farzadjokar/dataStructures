package Tree;

public class Node {
    public Node rightNode;
    public Node leftNode;
    public int data;

    public int getHeight(Node root){
    if(root==null){
        return 0;
    }
int left=getHeight(root.leftNode);
int righ=getHeight(root.rightNode);
return 1+Math.max(left, righ);
    }
public int numberOfNodes(Node root){
    if(root==null){
       return 0;
    }
    int leftNodes=numberOfNodes(root.leftNode);
    int rightNodes=numberOfNodes(root.rightNode);
    return 1+leftNodes+rightNodes;
}
public int numberOfKey(Node root,int key){
    if(root==null){
        return 0;
    }
    if(key==root.data){
        return 1+numberOfKey(root.leftNode, key)+numberOfKey(root.rightNode, key);
    }else{
        return 0+numberOfKey(root.leftNode, key)+numberOfKey(root.rightNode, key);
    }
}


}
