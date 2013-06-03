package net.moetang.nekocore.lang;

public class Check {
	public static boolean isNull(Object o){
		return (o == null) ? true : false;
	}
	public static boolean notNull(Object o){
		return !isNull(o);
	}
	public static boolean isNegative(int n){
		return (n < 0) ? true:false;
	}
	public static boolean isNegative(long n){
		return (n < 0) ? true:false;
	}
	public static boolean isNegative(short n){
		return (n < 0) ? true:false;
	}
	public static boolean isNegative(byte n){
		return (n < 0) ? true:false;
	}
	public static boolean notNegative(int n){
		return !isNegative(n);
	}
	public static boolean notNegative(long n){
		return !isNegative(n);
	}
	public static boolean notNegative(short n){
		return !isNegative(n);
	}
	public static boolean notNegative(byte n){
		return !isNegative(n);
	}
	public static boolean notBlank(String str){
		return notNull(str) && (str.length() > 0);
	}
	public static boolean notBlank(String... strs){
		for(String str : strs){
			if(!notBlank(str)){
				return false;
			}
		}
		return true;
	}
	public static <T> boolean hasElements(T[] array){
		return (array != null && array.length > 0)? true:false;
	}
}
