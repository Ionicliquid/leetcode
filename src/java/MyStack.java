package java;


// 用队列实现栈

import java.util.LinkedList;

class MyStack {

    private LinkedList<Integer> deque;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        deque = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        deque.offer(x);
        int size = deque.size();
        for (int i = 0; i < size - 1; i++) {

            deque.offer(deque.poll());


        }

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return deque.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return deque.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}