package inclassQuizes.structures.binaryTree;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    Node root;
    int size;

    public void addNode(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
        } else {

            Node cur = root;
            Node parent;

            while(true){
                parent = cur;
                if(value <= cur.getValue()) {
                    cur = cur.leftNode;
                    if(cur == null){
                        parent.leftNode = newNode;
                        size++;
                        return;
                    }
                } else {
                    cur = cur.rightNode;
                    if(cur == null){
                        parent.rightNode = newNode;
                        size++;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int value){
        Node cur = root;

        while(value != cur.value){
            if(value <= cur.getValue()){
                cur = cur.leftNode;
            } else {
                cur = cur.rightNode;
            }

            if(cur == null){
                return null;
            }
        }

        return cur;
    }

    public void inOrgerTraversal(Node cur){
        if(cur != null){
            inOrgerTraversal(cur.leftNode);
            System.out.print(cur.value + " ");
            inOrgerTraversal(cur.rightNode);
        }
    }

    public void preOrgerTraversal(Node cur){
        if(cur != null){
            System.out.print(cur.value + " ");
            preOrgerTraversal(cur.leftNode);
            preOrgerTraversal(cur.rightNode);
        }
    }

    public void postOrgerTraversal(Node cur){
        if(cur != null){
            postOrgerTraversal(cur.leftNode);
            postOrgerTraversal(cur.rightNode);
            System.out.print(cur.value + " ");
        }
    }

    class Node{
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }
    }

}
