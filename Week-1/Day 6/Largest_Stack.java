import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Stack;

public class Largest_Stack {

    // fill in the definitions for push(), pop(), and getMax()
    

    public static class MaxStack {

    	static Stack<Integer> stack = new Stack<>();
        public void push(int item) {
        	stack.push(item);
        }

        public int pop() {
            return stack.pop();
        }

        public int getMax() {
        	int temp =0;
        	Stack<Integer>tStack = (Stack<Integer>) stack.clone();
        	while(!tStack.isEmpty())
        	{
        		temp = Math.max(tStack.pop(), temp);
        	}
            return temp;
        }
    }


















    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Largest_Stack.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}