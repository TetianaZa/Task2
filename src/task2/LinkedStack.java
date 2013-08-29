package task2;

import StackExceptions.StackEmptyException;

/**
 *
 * @author tacita
 */
public class LinkedStack<T> implements AbstraktStack<T> {

    private int stackSize;
    private Node<T> top;

    @Override
    public synchronized boolean isEmpty() {
        return top == null;
    }

    @Override
    public synchronized T push(T item) {
        Node newTop = new Node(item);
        newTop.next = top;
        top = newTop;
        stackSize++;
        return item;
    }

    @Override
    public synchronized T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        T value = top.value;
        top = top.next;
        stackSize--;
        return value;
    }

    @Override
    public synchronized T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return (T)top.value;
    }

    @Override
    public synchronized int size() {
        return stackSize;
    }

    private class Node<T> {

        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
