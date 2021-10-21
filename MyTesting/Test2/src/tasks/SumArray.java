package tasks;

public class SumArray {
    public static void main(String[] args) {
        System.out.println(sum(new Integer[][] {{1,2,3},{4,5,6}}));
    }
    
    private static int sum(Integer arr[][]) {
        int sum = 0;
        for (Integer[] subArr : arr) {
            for (int i : subArr) {
                sum += i;
            }
        }
        return sum;
    }
}
