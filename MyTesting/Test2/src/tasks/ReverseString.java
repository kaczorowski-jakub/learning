package tasks;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("ALA MA KOTA"));
        System.out.println(reverse2("ALA MA KOTA"));
    }

    public static String reverse(String in) {
        StringBuilder sb = new StringBuilder();
        for (int i = in.length() - 1; i >= 0; i--) {
            sb.append(in.charAt(i));
        }
        return sb.toString();
    }

    public static String reverse2(String in) {
        return reverse2part(in.toCharArray(), in.length() - 1);
    }

    private static String reverse2part(char[] chain, int idx) {
        return idx < 0 ? "" : chain[idx] + reverse2part(chain, --idx);
    }
}
