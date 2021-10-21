package interfaces.two.methods.conflict;

public interface I1 {

	int test1(int i);

	default int test2() {

		return 1;
	}

	default int test3() {

		return 1;
	}
}
