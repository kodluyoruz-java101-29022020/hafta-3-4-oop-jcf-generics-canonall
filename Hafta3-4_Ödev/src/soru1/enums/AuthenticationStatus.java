package soru1.enums;

public enum AuthenticationStatus {

	SUCCESS(true, "Login Successful!"), FAIL(false, "Login Failed! Wrong e-mail or password");

	private final boolean code;
	private final String message;

	private AuthenticationStatus(boolean code, String message) {
		this.code = code;
		this.message = message;
	}

	public boolean getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
