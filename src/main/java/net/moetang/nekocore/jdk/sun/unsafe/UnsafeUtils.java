package net.moetang.nekocore.jdk.sun.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public final class UnsafeUtils {
	private static volatile Unsafe unsafeInst;

	private UnsafeUtils() {
	}

	public static synchronized Unsafe getUnsafe() {
		if (unsafeInst != null) {
			return unsafeInst;
		} else
			try {
				Field field = UnsafeUtils.class.getClassLoader()
						.loadClass("sun.misc.Unsafe")
						.getDeclaredField("theUnsafe");
				field.setAccessible(true);
				unsafeInst = (Unsafe) field.get(null);
				return unsafeInst;
			} catch (NoSuchFieldException | SecurityException
					| ClassNotFoundException | IllegalArgumentException
					| IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
	}
	public static UnsafeProxy getProxy(){
		if(getUnsafe() != null){
			return new UnsafeProxy();
		}else{
			return null;
		}
	}
	public static class UnsafeProxy {
		private UnsafeProxy(){
		}
		public int addressSize(){
			return unsafeInst.addressSize();
		}
		public int pageSize(){
			return unsafeInst.pageSize();
		}
		public int arrayBaseOffset(Class<?> clazz){
			return unsafeInst.arrayBaseOffset(clazz);
		}
		public long getLong(Object o, long offset){
			return unsafeInst.getLong(o, offset);
		}
	}
}
