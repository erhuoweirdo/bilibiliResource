package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class CQueue {

    Stack<Integer> stack1; //当做主栈
    
    Stack<Integer> stack2; //当做辅助栈
    
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    //入队
    public void appendTail(int value) {
        stack1.add(value);
    }
    
    //出队
    public int deleteHead() {
        int temp = -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (!stack2.isEmpty()) {
            temp = stack2.pop();
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }
}
