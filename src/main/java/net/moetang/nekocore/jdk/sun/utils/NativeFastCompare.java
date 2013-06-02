package net.moetang.nekocore.jdk.sun.utils;

import net.moetang.nekocore.jdk.sun.unsafe.UnsafeUtils;
import net.moetang.nekocore.jdk.sun.unsafe.UnsafeUtils.UnsafeProxy;
import net.moetang.nekocore.util.compare.SoftCompare;

public final class NativeFastCompare extends SoftCompare {
	private NativeFastCompare() {
	}

	public static NativeFastCompare getInstance() {
		if(!isInitialized){
			isInitialized = true;
			try {
				up = UnsafeUtils.getProxy();
			} catch (Throwable e) {
			}
		}
		if (up != null) {
			if (itself == null) {
				itself = new NativeFastCompare();
				return itself;
			} else
				return itself;
		}
		return null;
	}

	private static NativeFastCompare itself;

	private static UnsafeProxy up;
	private static volatile boolean isInitialized = false;

	private static final int BYTES = 8;
	private static final int BYTE_ARRAY_BASE_OFFSET;

	static {
		BYTE_ARRAY_BASE_OFFSET = up.arrayBaseOffset(byte[].class);
	}

	@Override
	public int compare(byte[] buffer1, int offset1, byte[] buffer2,
			int offset2, int length) {

		isIndexValid(buffer1.length, offset1, buffer2.length, offset2, length);
		int length1 = length;
		int length2 = length;
		if (sameEquals(buffer1, offset1, buffer2, offset2, length)) {
			return 0;
		}

		int minLength = Math.min(length1, length2);

		// small array, simple compare method
		if (minLength < 8) {
			return super.compare(buffer1, offset1, buffer2, offset2, length);
		}

		int minLongBytes = (minLength / BYTES) * BYTES;
		int offset1Adj = offset1 + BYTE_ARRAY_BASE_OFFSET;
		int offset2Adj = offset2 + BYTE_ARRAY_BASE_OFFSET;

		int i = 0;
		for (; i < minLongBytes; i += BYTES) {
			long lw = up.getLong(buffer1, offset1Adj + (long) i);
			long rw = up.getLong(buffer2, offset2Adj + (long) i);
			long diff = lw ^ rw;

			if (diff != 0) {
				int base1 = offset1 + i;
				int base2 = offset2 + i;
				for (int k = 0; k < BYTES; k++) {
					if (buffer1[base1 + k] == buffer2[base2 + k])
						continue;
					return buffer1[base1 + k] - buffer2[base2 + k];
				}
			}
		}

		for (; i < minLength; i++) {
			if (buffer1[offset1 + i] == buffer2[offset2 + i])
				continue;
			return buffer1[offset1 + i] - buffer2[offset2 + i];
		}

		return length1 - length2;
	}

}
