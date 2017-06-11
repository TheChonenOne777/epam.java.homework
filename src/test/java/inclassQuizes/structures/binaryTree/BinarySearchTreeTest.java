package inclassQuizes.structures.binaryTree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BinarySearchTreeTest {

    BinarySearchTree bst = new BinarySearchTree();

    @Test
    public void addNode() throws Exception {
        bst.addNode(10);
        bst.addNode(9);
        bst.addNode(11);
        assertEquals(10, bst.root.getValue());
        assertEquals(9, bst.root.leftNode.getValue());
        assertEquals(11, bst.root.rightNode.getValue());
    }

    @Test
    public void find() throws Exception {
        bst.addNode(10);
        bst.addNode(9);
        bst.addNode(11);
        BinarySearchTree.Node val = bst.find(11);
        assertEquals(11, val.getValue());
    }

    @Test
    public void orderTraversal() throws Exception {
        bst.addNode(10);
        bst.addNode(8);
        bst.addNode(9);
        bst.addNode(5);
        bst.addNode(14);
        bst.addNode(20);
        bst.addNode(1);
        bst.addNode(17);
        bst.inOrgerTraversal(bst.root);
        System.out.println();
        bst.preOrgerTraversal(bst.root);
        System.out.println();
        bst.postOrgerTraversal(bst.root);
    }

}