package enums;

public enum E1 {

	VAL1(1, 2),VAL2(2, 3);

	private int i;
	private int y;

	private E1(int i, int y) {
		this.i = i;
		this.y = y;
	}

	public int getI() {
		return i;
	}

	public int getY() {
		return y;
	}

}
