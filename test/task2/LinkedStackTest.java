package task2;

import StackExceptions.StackEmptyException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tacita
 */
public class LinkedStackTest {

    private LinkedStack linkedStack;

    public LinkedStackTest() {
    }

    @Before
    public void setUp() {
        linkedStack = new LinkedStack();
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty_True() {
        assertEquals(true, linkedStack.isEmpty());
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty_False() {
        linkedStack.push(new Object());
        assertFalse(linkedStack.isEmpty());
    }

    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() {
        Object item = new Object();
        int sizeBeforePush = linkedStack.size();
        linkedStack.push(item);
        if (linkedStack.size() != sizeBeforePush + 1 || !linkedStack.peek().equals(item)) {
            fail("testPush failed");
        }
    }

    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop() {
        Object item = new Object();
        linkedStack.push(item);
        int sizeAfterPush = linkedStack.size();
        if (!linkedStack.pop().equals(item) || linkedStack.size() != sizeAfterPush - 1) {
            fail("testPop failed");
        }

    }

    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test(expected = StackEmptyException.class)
    public void testPop_StackEmptyException() {
        linkedStack.pop();
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testPeek() {
        Object item = new Object();
        linkedStack.push(item);
        int sizeAfterPush = linkedStack.size();
        if (!linkedStack.peek().equals(item) || linkedStack.size() != sizeAfterPush) {
            fail("testPop failed");
        }

    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test(expected = StackEmptyException.class)
    public void testPeek_StackEmptyException() {
        linkedStack.peek();
    }

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize_ZiroSize() {
        assertEquals(0, linkedStack.size());
    }

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        for (int i = 0; i < 4; i++) {
            linkedStack.push(new Object());
        }
        assertEquals(4, linkedStack.size());
    }
}