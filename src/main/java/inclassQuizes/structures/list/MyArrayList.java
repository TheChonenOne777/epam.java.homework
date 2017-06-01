package inclassQuizes.structures.list;


import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<E> implements List<E> {

    Object[] objects;
    private int size = 0;

    public MyArrayList(){
        objects = new Object[10];
    }

    public MyArrayList(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException();
        }
        objects = new Object[capacity];
    }


    @Override
    public void add(E obj) {
        if(size == objects.length){
            enlarge();
        }
        objects[size++] = obj;
    }

    @Override
    public E get(int i) {
        checkIndex(i);
        return (E)objects[i];
    }

    @Override
    public void remove(int i) {
        checkIndex(i);
        int movingSize = size - i - 1;
        if(movingSize > 0) {
            System.arraycopy(objects, i + 1, objects, i, movingSize);
        }
        objects[--size] = null;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        return Arrays.toString(objects);
    }

    private void enlarge() {
        int newLength = (objects.length * 3) / 2 + 1;
        Object[] newObjects = new Object[newLength];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        objects = newObjects;
    }

    private void checkIndex(int i) {
        if(i < 0 || i > size) throw new IndexOutOfBoundsException();
    }

    static int f(int n) {
        if (n <= 0) {
            return 0;
        }

        return n + f(n / 2);
    }

    static class Node {
        Node left;
        Node right;

        static int height(Node node) {
            if (node == null) {
                return 0;     }

            int left = height(node.left);
            int right = height(node.right);
            return Math.max(left, right);
        }
    }

}
