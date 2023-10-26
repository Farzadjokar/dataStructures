package Hello;

import javax.swing.text.rtf.RTFEditorKit;

public class Tree {
    public Node root;
    public Tree(int data){
    root=new Node();
    root.data=data;
    }
    
    public int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.Right);
        if(leftHeight>rightHeight){
            return 1+leftHeight;
        }else{
            return 1+rightHeight;
        }

    }
    public int getNumberOfNodes(Node root){
     if(root==null){
        return 0;
     }
     int leftNodes=getNumberOfNodes(root.left);
     int rightNode=getNumberOfNodes(root.Right);
     return 1+leftNodes+rightNode;
    }
    public int getNumberOfLeaves(Node root){
     if(root == null){
        return 0;
     }
     if(root.left==null && root.Right==null){
        return 1+getNumberOfLeaves(root.left)+getNumberOfLeaves(root.Right);
     }else{
      return  0+getNumberOfLeaves(root.left)+getNumberOfLeaves(root.Right);
     }
    }
    public boolean add(int data,Node root){
        if(data<root.data){
            if(root.left==null){
                root.left=new Node();
                root.left.data=data;
                return true;
            }else{
                return add(data, root.left);
            }
        }else{
            if(root.Right==null){
                root.Right=new Node();
                root.Right.data=data;
                return true;
            }else{
                return add(data, root.Right);
            }
        }
    }
    public void printTree(Node root,String space){
        if(root==null){
            return;
        }
       space+="     ";
       printTree(root.Right, space);
       System.out.println(space+root.data);
       printTree(root.left, space);
    }
    private class Node{
        Node left;
        Node Right;
        int data;
    }
    public Node getParent(int data){
        if(contains(data, root)&&root.data!=data){
            Node parent=getRicursiveParent(data, root);
            System.out.println(parent.data);
            return parent;
        }
        return null;
    }
    private Node getRicursiveParent(int data,Node root){
    if((root.Right!=null&&root.Right.data==data) || (root.left!=null&&root.left.data==data)){
        return root;
    }
    if(root.data<data){
        return getRicursiveParent(data, root.Right);
    }else{
        return getRicursiveParent(data, root.left);
    }
    }
    public boolean contains(int data,Node root){
    if(root==null){
        return false;
    }
    if(root.data==data){
        return true;
    }
    if(root.data<data){
        return contains(data, root.Right);
    }else{
        return contains(data, root.left);
    }
    }
}
