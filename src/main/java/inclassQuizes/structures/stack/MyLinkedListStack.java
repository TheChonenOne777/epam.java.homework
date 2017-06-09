package inclassQuizes.structures.stack;


import java.util.EmptyStackException;
import java.util.Iterator;

public class MyLinkedListStack<E> implements Stack<E>, Iterable<E> {

    Entry<E> top;
    int size = 0;

    public MyLinkedListStack(){}

    @Override
    public void push(E obj) {
        Entry temp = new Entry(obj, null);
        temp.next = top;
        top = temp;
        size++;
    }

    @Override
    public E pop() {
        if(top == null){
            throw new EmptyStackException();
        }
        Entry<E> temp = top;
        top = temp.next;
        size--;
        return temp.get();
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<E> iterator(){
        return new MyLinkedListStackIterator();
    }

    private static class Entry<E>{
        private E element;
        private Entry<E> next;

        public Entry(E element, Entry<E> next){
            this.element = element;
            this.next = next;
        }

        public E get(){
            return element;
        }
    }

    class MyLinkedListStackIterator implements Iterator{

        Entry cur;

        public MyLinkedListStackIterator(){
            cur = top;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            if(cur != null){
                E temp = (E) cur.get();
                cur = cur.next;
                return temp;
            }
            return null;
        }
    }

}
