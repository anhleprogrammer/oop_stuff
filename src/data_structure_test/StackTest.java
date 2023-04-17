package data_structure_test;

import data_structure.Stack;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StackTest {
    @Test
    public void testStack() {
        // Create a stack using a linked list-based implementation
        Stack<Integer> stack = new Stack<>();

        // Test push operation
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.peek().intValue());

        // Test pop operation
        int popped = stack.pop();
        Assert.assertEquals(3, popped);
        Assert.assertEquals(2, stack.peek().intValue());

        // Test size and isEmpty methods
        Assert.assertEquals(2, stack.size());
        Assert.assertFalse(stack.isEmpty());

    }
}
