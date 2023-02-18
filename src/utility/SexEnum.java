package utility;

public enum SexEnum{

	none(0),
	male(1),
	female(2);
	
	private final int value;
	private SexEnum(int _value) {
		this.value = _value;
	}
	
	public int get() {
		return value;
	}
	
	@Override
	public String toString() {
		if (this.get() == 1) return "M";
		if (this.get() == 2) return "F";
		return "N/A";
	}
}
