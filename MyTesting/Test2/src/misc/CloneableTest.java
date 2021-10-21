package misc;

public class CloneableTest {
    public static void main(String[] args) {
        CloneableTest ct = new CloneableTest();
        try {
            CloneableTest ct2 = (CloneableTest) ct.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        CT2 ct11 = new CT2(101);
        try {
            System.out.println(ct11.clone());
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static class CT2 implements Cloneable {

        private final int val;

        public CT2(int val) {
            this.val = val;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            // TODO Auto-generated method stub
            return new CT2(val);
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
