package inheritance.test2;

public interface I2 extends I1 {

	default void m1() {
		System.out.println("m1 w I2");
	}
}
