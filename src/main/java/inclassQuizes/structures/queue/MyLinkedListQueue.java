package inclassQuizes.structures.queue;


import unit4.task3.EncodingConverter;

import java.util.EmptyStackException;

public class MyLinkedListQueue<E> implements Queue<E>{

    Entry<E> first;
    Entry<E> last;
    int size;

    @Override
    public void enqueue(E obj) {
        Entry<E> newObj = new Entry<>(obj);
        if(first == null){
            first = newObj;
            last = first;
        }
        last.next = newObj;
        last = newObj;
        size++;
    }

    @Override
    public E dequeue() {
        if(size == 0){
            throw new EmptyStackException();
        }
        Entry<E> temp = first;
        first = first.next;
        size--;
        return temp.get();
    }

    @Override
    public int size() {
        return size;
    }

    private static class Entry<E>{
        E element;
        Entry<E> next = null;
        public Entry(E el){
            element = el;
        }
        public E get(){
            return element;
        }
    }
}
