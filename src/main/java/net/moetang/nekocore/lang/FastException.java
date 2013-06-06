package net.moetang.nekocore.lang;

/**
 * 
 * 快速异常，无调用栈信息搜集
 * @author sun hao
 *
 */
public class FastException extends RuntimeException {
	private static final long serialVersionUID = 2888486587379012107L;
	private static final FastException self = new FastException();
	public static void throwIt(){
		throw self;
	}
	public FastException() {
		super();
	}
	public FastException(String message){
		super(message);
	}
	public FastException(Throwable cause){
		super(cause);
	}
	public FastException(String message, Throwable cause){
		super(message, cause);
	}
	@Override
	public final Throwable fillInStackTrace() {
		return null;
	}
}
