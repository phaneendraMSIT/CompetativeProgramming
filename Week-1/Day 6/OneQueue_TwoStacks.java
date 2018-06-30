import java.util.Stack;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class OneQueue_TwoStacks {

    // fill in the definitions for enqueue() and dequeue()
    

    public static class QueueTwoStacks {

        private Stack<Integer> inStack= new Stack<>();; 
        private Stack<Integer> outStack= new Stack<>();;
       /* 
        public void Queue2stacks() {
			inStack 
			outStack 
		}*/
        
        private void stack1tostack2() {
        	while(!inStack.isEmpty())
        	{
        		outStack.push(inStack.pop());
        	}
		}
        
        public boolean isEmpty()
        {
        	return inStack.isEmpty() && outStack.isEmpty();
        }
        
        public int size() {
			return inStack.size() + outStack.size();
		}
        
        public void enqueue(int item)
        {
        	inStack.push(item);
        }

        public int dequeue() throws Exception {
        	if (isEmpty()) throw new Exception();
        	if(outStack.isEmpty()) stack1tostack2();
            return outStack.pop();
        }
    }








    // tests

    @Test
    public void basicQueueOperationsTest() throws Exception {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals("dequeue #1", 1, q.dequeue());
        assertEquals("dequeue #2", 2, q.dequeue());
        q.enqueue(4);
        assertEquals("dequeue #3", 3, q.dequeue());
        assertEquals("dequeue #4", 4, q.dequeue());
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDeuqueFromNewQueueTest() throws Exception {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.dequeue();
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDeuqueFromEmptyQueueTest() throws Exception {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(OneQueue_TwoStacks.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}