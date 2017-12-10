package assign3;

@SuppressWarnings("serial")
public class LispException extends RuntimeException {
	public LispException() {
		super();
	}

	public LispException(String message) {
		super(message);
	}
}