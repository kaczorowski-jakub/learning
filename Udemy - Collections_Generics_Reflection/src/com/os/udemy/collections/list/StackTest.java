package com.os.udemy.collections.list;

import java.util.Arrays;
import java.util.Stack;

/**
 * Stack inherits from Vector so it is synchronized 
 * 
 * Stack is a LIFO structure Last In - First Out
 * @author jakub.kaczorowski
 *
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Elem1");
        stack.push("Elem2");
        stack.push("Elem3");
        stack.push("Elem4");
        System.out.println(stack);
        
        // pop removes the elements from the collection
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        
        // peek takes the last element without removing it
        stack.addAll(Arrays.asList("A","B","C","D","E"));
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }
}
