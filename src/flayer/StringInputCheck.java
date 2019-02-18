package flayer;

public class StringInputCheck {
	private boolean lackOfInput;

	public boolean check(String target) {
		if(target == null || "".equals(target)) {
			lackOfInput = true;
		} else {
			lackOfInput = false;
		}

		return lackOfInput;
	}
}
