package qf.task.week03.day05;

import java.util.LinkedList;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 14:31
 */
public class TestStack_Queue {
    public static void main(String[] args) {
        LinkedList stack = new LinkedList();

        stack.push(1);
        stack.push(2);
        LinkedList queue = new LinkedList();
        queue.offer(23);
        queue.offer(24);

        stack.pop();
        queue.poll();
        System.out.println(stack);
        System.out.println(queue);
    }
}
