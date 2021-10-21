
public class Lambda {

	public static void main(String[] args) {

		LambdaInt li = (fdfd) -> {
			System.out.println(Integer.parseInt(fdfd) + 12);
		};
		
		li.test("6");
		
		/*LambdaAbs la = (a) -> {
			System.out.println(Integer.parseInt(a) + 22);
		}*/
	}

}
