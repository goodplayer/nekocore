package net.moetang.nekocore.lang;

public class NekoCoreException extends Exception {
	private static final long serialVersionUID = -3463290910795767665L;

	public NekoCoreException() {
		super();
	}

	public NekoCoreException(String message) {
		super(message);
	}

	public NekoCoreException(Throwable cause) {
		super(cause);
	}

	public NekoCoreException(String message, Throwable cause) {
		super(message, cause);
	}
}
