package inclassQuizes.structures.queue;


public interface Queue<E> {
    void enqueue(E obj);
    E dequeue();
    int size();
}
