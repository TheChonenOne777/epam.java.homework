package inclassQuizes.structures.binaryTree;

import org.junit.Test;

import java.util.Arrays;
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
        List<Integer> actual = bst.getInOrderTraversal();
        int[] actualArray = new int[actual.size()];
        for(int i = 0; i < actual.size(); i++){
            actualArray[i] = actual.get(i);
        }
        assertArrayEquals(new int[]{1, 5, 8, 9, 10, 14, 17, 20}, actualArray);
    }

}