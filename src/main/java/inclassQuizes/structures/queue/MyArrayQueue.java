package inclassQuizes.structures.queue;


import inclassQuizes.structures.stack.EmptyQueueException;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MyArrayQueue<E> implements Queue<E>{

    Object[] objects;
    int first;
    int last;
    int size;

    public MyArrayQueue(){
        objects = new Object[10];
    }

    public MyArrayQueue(int capacity){
        objects = new Object[capacity];
    }

    @Override
    public void enqueue(E obj) {
        if(size == objects.length){
            enlarge();
        }
        if(last == objects.length){
            last = 0;
        }
        objects[last++] = obj;
        size++;
    }

    @Override
    public E dequeue() {
        if(size == 0) throw new EmptyQueueException("The queue is empty");
        size--;
        Object obj = objects[first];
        objects[first++] = null;
        return (E)obj;
    }

    @Override
    public int size() {
        return size;
    }

    private void enlarge() {
        int len = objects.length;
        Object[] newArray = new Object[(len * 3) / 2];
        for(int i = 0; i < size; i++){
            newArray[i] = objects[(first + i) % len];
        }
        objects = newArray;
        last = len;
    }

    class ArrayQueueIterator<E> implements Iterator<E>{


        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

}
