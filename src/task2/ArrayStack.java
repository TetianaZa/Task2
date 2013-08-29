package task2;

import StackExceptions.*;

/**
 *
 * @author tacita
 */
public class ArrayStack<T> implements AbstraktStack<T> {

    private Object[] elementData;
    private int top = -1;
    private int capacity;

    public ArrayStack(int size) {
        this.capacity = size;
        elementData = new Object[this.capacity];
    }

    public ArrayStack() {
        this(16);
    }

    @Override
    public synchronized boolean isEmpty() {
        return (top < 0);
    }

    @Override
    public synchronized T push(Object item)  {
        if (top == capacity-1) {
            throw new StackFullException("Stack overflow ");
        }
        elementData[++top] = item;
        return (T) elementData[top];
    }

    @Override
    public synchronized T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        Object elem = elementData[top];
        elementData[top--] = null;
        return (T) elem;
    }

    @Override
    public synchronized T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return (T) elementData[top];
    }

    @Override
    public synchronized int size() {
        return top + 1;
    }
}
