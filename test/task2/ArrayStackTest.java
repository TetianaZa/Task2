package task2;

import StackExceptions.StackEmptyException;
import StackExceptions.StackFullException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tacita
 */
public class ArrayStackTest {

    private ArrayStack arrayStack;

    public ArrayStackTest() {
    }

    @Before
    public void setUp() {
        arrayStack = new ArrayStack(5);
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty_True() {
        assertTrue(arrayStack.isEmpty());
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty_False() {
        arrayStack.push(new Object());
        assertFalse(arrayStack.isEmpty());
    }

    /**
     * Test of push method, of class ArrayStack.
     */
    @Test(expected = StackFullException.class)
    public void testPush_StackFullException() {
        for (int i = 0; i <= 5; i++) {
            arrayStack.push(new Object());
        }

    }

    @Test
    public void testPush() {
        for (int i = 0; i < 4; i++) {
            arrayStack.push(new Object());
        }
    }

    /**
     * Test of pop method, of class ArrayStack.
     */
    @Test
    public void testPop() {
        Object putObject = new Object();
        int size = arrayStack.size();
        arrayStack.push(putObject);
        if (!arrayStack.peek().equals(putObject) || size != arrayStack.size() - 1) {
            fail("testPop failed");
        }
    }

    @Test(expected = StackEmptyException.class)
    public void testPop_StackEmptyException() {
        arrayStack.pop();
    }

    /**
     * Test of peek method, of class ArrayStack.
     */
    @Test
    public void testPeek() {
        Object putObject = new Object();
        arrayStack.push(putObject);
        int size = arrayStack.size();
        if (!arrayStack.peek().equals(putObject) || size != arrayStack.size()) {
            fail("testPeek failed");
        }
    }

    /**
     * Test of peek method, of class ArrayStack.
     */
    @Test(expected = StackEmptyException.class)
    public void testPeek_StackEmptyException() {
        arrayStack.peek();
    }

    /**
     * Test of size method, of class ArrayStack.
     */
    @Test
    public void testSize_ZiroSize() {
        assertEquals(0, arrayStack.size());
    }

    /**
     * Test of size method, of class ArrayStack.
     */
    @Test
    public void testSize() {
        for (int i = 0; i < 4; i++) {
            arrayStack.push(new Object());
        }
        assertEquals(4, arrayStack.size());
    }
}