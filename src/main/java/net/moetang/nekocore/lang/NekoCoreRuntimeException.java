package net.moetang.nekocore.lang;

public class NekoCoreRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -3784871429933951269L;

	public NekoCoreRuntimeException() {
		super();
	}

	public NekoCoreRuntimeException(String message) {
		super(message);
	}

	public NekoCoreRuntimeException(Throwable cause) {
		super(cause);
	}

	public NekoCoreRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
