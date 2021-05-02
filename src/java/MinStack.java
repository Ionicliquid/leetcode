package java;

import java.util.Stack;

class MinStack {

    /**
     * initialize your data structure here.
     */


    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || val <= stack2.peek()) {
            stack2.push(val);
        }

    }

    public void pop() {
        int val = stack1.pop();
        int val2 = stack2.peek();
        System.out.println("val = " + val + "val2 = " + val2);
        if (val == val2) stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}