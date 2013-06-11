package net.moetang.nekocore.lang;

import java.util.Arrays;

public class ArrayUtil {
	// Do nothing
	public static void concat() {
		FastException.throwIt();
	}

	@SafeVarargs
	public final static <T> T[] concat(T[]... arrays) {
		int n = 0;
		int i = 0;
		int pos = 0;
		int len = arrays.length;
		for (; i < len; i++) {
			n += arrays[i].length;
		}
		if (len > 0) {
			T[] arr = arrays[0];
			pos = arr.length;
			T[] newArray = Arrays.copyOf(arr, n);
			for (i = 1; i < len; i++) {
				arr = arrays[i];
				if (arr.length > 0) {
					System.arraycopy(arr, 0, newArray, pos, arr.length);
					pos += arr.length;
				}
			}
			return newArray;
		} else {
			return null;
		}
	}

	public final static byte[] clone(byte[] array) {
		if (array == null) {
			return null;
		}
		byte[] result = new byte[array.length];
		System.arraycopy(array, 0, result, 0, array.length);
		return result;
	}

	public final static int[] clone(int[] array) {
		if (array == null) {
			return null;
		}
		int[] result = new int[array.length];
		System.arraycopy(array, 0, result, 0, array.length);
		return result;
	}

	public final static long[] clone(long[] array) {
		if (array == null) {
			return null;
		}
		long[] result = new long[array.length];
		System.arraycopy(array, 0, result, 0, array.length);
		return result;
	}

	public final static short[] clone(short[] array) {
		if (array == null) {
			return null;
		}
		short[] result = new short[array.length];
		System.arraycopy(array, 0, result, 0, array.length);
		return result;
	}

	public static byte[] subArray(byte[] input, int start, int end) {
		byte[] result = new byte[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
	public static short[] subArray(short[] input, int start, int end) {
		short[] result = new short[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
	public static int[] subArray(int[] input, int start, int end) {
		int[] result = new int[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
	public static long[] subArray(long[] input, int start, int end) {
		long[] result = new long[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
	public static float[] subArray(float[] input, int start, int end) {
		float[] result = new float[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
	public static double[] subArray(double[] input, int start, int end) {
		double[] result = new double[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
	public static char[] subArray(char[] input, int start, int end) {
		char[] result = new char[end - start];
		System.arraycopy(input, start, result, 0, end - start);
		return result;
	}
}
