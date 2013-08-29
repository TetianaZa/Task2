package task2;

/**
 *
 * @author tacita
 */
interface AbstraktStack<T> {

    public boolean isEmpty();

    public T push(T item);

    public T pop();

    public T peek();
    
    public int size();
}
