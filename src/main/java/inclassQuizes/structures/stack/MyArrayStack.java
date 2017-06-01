package inclassQuizes.structures.stack;


import java.util.Arrays;
import java.util.EmptyStackException;

public class MyArrayStack<E> implements Stack<E>{

    int top;
    Object[] objects;

    public MyArrayStack(){
        top = 0;
        objects = new Object[10];
    }

    public MyArrayStack(int capacity){
        top = 0;
        objects = new Object[capacity];
    }

    @Override
    public void push(E obj) {
        if(top == objects.length){
            enlarge();
        }
        objects[top++] = obj;
    }


    @Override
    public E pop() {
        if(top > 0) {
            Object object = objects[--top];
            objects[top] = null;
            return (E) object;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public int size() {
        return top;
    }

    public String toString(){
        return Arrays.toString(objects);
    }
    
    private void enlarge() {
        Object[] newObjects = new Object[(objects.length * 3) / 2];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        objects = newObjects;
    }

}
