package inclassQuizes.structures.stack;


import java.util.EmptyStackException;

public class MyLinkedListStack<E> implements Stack<E> {

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

}
