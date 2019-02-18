package fieldformat;

public class ShowMessage {
	private boolean isAbEnd;

	private boolean isNomalEnd;

	private String message = "";

	public boolean isAbEnd() {
		return isAbEnd;
	}

	public void setAbEnd(boolean isAbEnd) {
		this.isAbEnd = isAbEnd;
	}

	public boolean isNomalEnd() {
		return isNomalEnd;
	}

	public void setNomalEnd(boolean isNomalEnd) {
		this.isNomalEnd = isNomalEnd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
