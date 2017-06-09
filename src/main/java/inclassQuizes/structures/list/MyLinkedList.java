package inclassQuizes.structures.list;


public class MyLinkedList<E> implements List<E> {

    Entry<E> first;
    Entry<E> last;
    int size;

    @Override
    public void add(E obj) {
        Entry<E> newEntry = new Entry<>(obj);
        if(first == null){
            first = newEntry;
            last = first;
        } else {
            Entry<E> temp = last;
            last.next = newEntry;
            last = newEntry;
            last.prev = temp;
        }
        size++;
    }

    @Override
    public E get(int i) {
        Entry<E> cur;
        if(i < size / 2){
            cur = first;
            for (int j = 0; j < i; j++) {
                cur = cur.next;
            }
        } else {
            cur = last;
            for (int j = 0; j < size - i - 1; j++) {
                cur = cur.prev;
            }
        }
        return cur.getElement();
    }

    @Override
    public void remove(int i) {
        Entry<E> cur;
        if(i < size / 2){
            cur = first;
            for (int j = 0; j < i; j++) {
                cur = cur.next;
            }
        } else {
            cur = last;
            for (int j = 0; j < size - i - 1; j++) {
                cur = cur.prev;
            }
        }
        if(cur == first){
            first = first.next;
        } else if(cur == last){
            last = last.prev;
        } else {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }


    static class Entry<E>{
        E element;
        Entry<E> next;
        Entry<E> prev;

        public Entry(E el){
            element = el;
        }

        public E getElement() {
            return element;
        }

        public Entry<E> getNext() {
            return next;
        }

        public Entry<E> getPrev() {
            return prev;
        }
    }
}
