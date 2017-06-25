package inclassQuizes.structures.binaryTree;


import inclassQuizes.binarySearch.BinarySearch;

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

    public List<Integer> getInOrderTraversal(){
        List<Integer> output = new ArrayList<>();
        inOrgerTraversal(root, output);
        return output;
    }

    private void inOrgerTraversal(Node cur, List<Integer> array){
        if(cur != null){
            inOrgerTraversal(cur.leftNode, array);
            array.add(cur.getValue());
            inOrgerTraversal(cur.rightNode, array);
        }
    }

    public List<Integer> getPreOrderTraversal(){
        List<Integer> output = new ArrayList<>();
        preOrgerTraversal(root, output);
        return output;
    }

    private void preOrgerTraversal(Node cur, List<Integer> array){
        if(cur != null){
            array.add(cur.getValue());
            preOrgerTraversal(cur.leftNode, array);
            preOrgerTraversal(cur.rightNode, array);
        }
    }

    public List<Integer> getPostOrderTraversal(){
        List<Integer> output = new ArrayList<>();
        postOrgerTraversal(root, output);
        return output;
    }

    private void postOrgerTraversal(Node cur, List<Integer> array){
        if(cur != null){
            postOrgerTraversal(cur.leftNode, array);
            postOrgerTraversal(cur.rightNode, array);
            array.add(cur.getValue());
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
