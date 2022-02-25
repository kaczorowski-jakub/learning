package varargs;

public class VarArgTest {
    public static void main(String[] args) {
        test("A", "B");
        System.out.println(new String[4].getClass());
        System.out.println(new String[] { "A" }.getClass());
        System.out.println(new String().getClass());
    }

    private static void test(String... val) {
        System.out.println(val.getClass());
    }

    /*
     * // The variable argument type int of the method test must be the last
     * parameter private static void test(int...is, String...strings) {
     * 
     * }
     */
}
