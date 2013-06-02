package net.moetang.nekocore.util.compare;

/**
 * 比较数组是否相等
 * 
 * @author sun hao
 * 
 */
public class SoftCompare implements Compare {
	/**
	 * 两个数组长度是否相同
	 * 
	 * @param len1
	 * @param len2
	 * @return
	 */
	protected final boolean isIndexValid(int len1, int len2) {
		if (len1 != len2) {
			throw new RuntimeException("length1 should equals length2!");
		}
		return true;
	}

	/**
	 * 检查数组长度是否相同
	 * 
	 * @param len1
	 * @param offset1
	 * @param length1
	 * @param len2
	 * @param offset2
	 * @param length2
	 * @return
	 */
	protected final boolean isIndexValid(int len1, int offset1, int len2,
			int offset2, int length) {
		if (length < 0 || offset2 < 0 || offset1 < 0) {
			throw new NegativeArraySizeException();
		}
		if ((offset1 + length) >= len1 || (offset2 + length) >= len2) {
			throw new IndexOutOfBoundsException();
		}
		return true;
	}

	// T
	protected final <T> boolean sameEquals(T[] array1, T[] array2) {
		return array1 == array2;
	}

	protected final <T> boolean sameEquals(T[] array1, int offset1, T[] array2,
			int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// int
	protected final boolean sameEquals(int[] array1, int[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(int[] array1, int offset1, int[] array2,
			int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// long
	protected final boolean sameEquals(long[] array1, long[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(long[] array1, int offset1,
			long[] array2, int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// byte
	protected final boolean sameEquals(byte[] array1, byte[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(byte[] array1, int offset1,
			byte[] array2, int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// short
	protected final boolean sameEquals(short[] array1, short[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(short[] array1, int offset1,
			short[] array2, int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// char
	protected final boolean sameEquals(char[] array1, char[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(char[] array1, int offset1,
			char[] array2, int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// double
	protected final boolean sameEquals(double[] array1, double[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(double[] array1, int offset1,
			double[] array2, int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	// float
	protected final boolean sameEquals(float[] array1, float[] array2) {
		return array1 == array2;
	}

	protected final boolean sameEquals(float[] array1, int offset1,
			float[] array2, int offset2, int length) {
		if (array1 == array2 && offset1 == offset2) {
			return true;
		}
		return false;
	}

	@Override
	public <T> boolean compare(T[] array1, T[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return true;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i])
				return false;
		}
		return true;
	}

	@Override
	public <T> boolean compare(T[] array1, int offset1, T[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return true;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2])
				return false;
		}
		return true;
	}

	@Override
	public <T> boolean deepCompare(T[] array1, T[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return true;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] == array2[i] || array1[i].equals(array2[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public <T> boolean deepCompare(T[] array1, int offset1, T[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return true;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] == array2[offset2]
					|| array1[offset1].equals(array2[offset2])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public <T> int compare(int[] array1, int[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(int[] array1, int offset1, int[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(long[] array1, long[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(long[] array1, int offset1, long[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(byte[] array1, byte[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(byte[] array1, int offset1, byte[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(short[] array1, short[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(short[] array1, int offset1, short[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(char[] array1, char[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(char[] array1, int offset1, char[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(double[] array1, double[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(double[] array1, int offset1, double[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(float[] array1, float[] array2) {
		isIndexValid(array1.length, array2.length);
		if (sameEquals(array1, array2)) {
			return 0;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				if (array1[i] < array2[i]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public <T> int compare(float[] array1, int offset1, float[] array2,
			int offset2, int length) {
		isIndexValid(array1.length, offset1, array2.length, offset2, length);
		if (sameEquals(array1, offset1, array2, offset2, length)) {
			return 0;
		}
		for (int i = 0; i < length; i++, offset1++, offset2++) {
			if (array1[offset1] != array2[offset2]) {
				if (array1[offset1] < array2[offset2]) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}
}
