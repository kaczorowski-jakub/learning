package com.os.junit.test.main;

public class MathMethods {

    public Integer fib(int pos) {
        checker(pos);
        return (pos == 0) ? 0 : pos == 1 ? 1 : fib(pos - 1) + fib(pos - 2);
    }

    public Integer luc(int pos) {
        checker(pos);
        return (pos == 0) ? 2 : pos == 1 ? 1 : luc(pos - 1) + luc(pos - 2);
    }

    public Integer tri(int pos) {
        checker(pos);
        return (pos == 0 || pos == 1) ? 0 : pos == 2 ? 1 : tri(pos - 1) + tri(pos - 2) + tri(pos - 3);
    }

    public Integer tet(int pos) {
        checker(pos);
        return (pos == 0 || pos == 1 || pos == 2) ? 0
                : pos == 3 ? 1 : tet(pos - 1) + tet(pos - 2) + tet(pos - 3) + tet(pos - 4);
    }

    private void checker(int pos) {
        if (pos < 0) throw new RuntimeException("Wrong parameter");
    }
}
