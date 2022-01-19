package com.os.udemy.multithreading.memory;

/**
 * Use it in debug mode so we can see the frames and the variables on the stack
 * set the breakpoints on #12,#13,#14,#18,#19
 * @author jakub.kaczorowski
 *
 */
public class Main {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int result = sum(x, y);
    }

    private static int sum(int a, int b) {
        int s = a + b;
        return s;
    }

}
