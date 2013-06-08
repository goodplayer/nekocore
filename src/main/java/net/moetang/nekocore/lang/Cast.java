package net.moetang.nekocore.lang;

public class Cast {
	public static <T> T cast(Object o, Class<T> clazz){
		try {
			return clazz.cast(o);
		} catch (ClassCastException e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> T cast(Object o, T typeO){
		return (T) cast(o, typeO.getClass());
	}
}
