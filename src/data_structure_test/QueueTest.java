package data_structure_test;

import data_structure.Queue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QueueTest {
    @Test
    public void testQueue() {
        // Create a queue using a linked list-based implementation
        Queue<Integer> queue = new Queue<>();

        // Test enqueue operation
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(1, queue.peek().intValue());

        // Test dequeue operation
        int dequeued = queue.dequeue();
        Assert.assertEquals(1, dequeued);
        Assert.assertEquals(2, queue.peek().intValue());

        // Test size and isEmpty methods
        Assert.assertEquals(2, queue.size());
        Assert.assertFalse(queue.isEmpty());

    }
}
