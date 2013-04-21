package net.moetang.nekocore.jdk.sun.utils;

import net.moetang.nekocore.jdk.sun.unsafe.UnsafeUtils;
import net.moetang.nekocore.jdk.sun.unsafe.UnsafeUtils.UnsafeProxy;

public final class FastCompare {
	public FastCompare() {
	}

	private static final UnsafeProxy up;

	private static final int BYTES = 8;
	private static final int BYTE_ARRAY_BASE_OFFSET;

	static {
		up = UnsafeUtils.getProxy();
		BYTE_ARRAY_BASE_OFFSET = up.arrayBaseOffset(byte[].class);
	}

	public int compareTo(byte[] buffer1, int offset1, int length1,
			byte[] buffer2, int offset2, int length2) {

		// invalid case
		if (offset1 < 0 || length1 < 0 || offset2 < 0 || length2 < 0) {
			return 0;
		}
		// equal case
		if (buffer1 == buffer2 && offset1 == offset2 && length1 == length2) {
			return 0;
		}
		// invalid case
		if ((offset1 + length1) > buffer1.length
				|| (offset2 + length2) > buffer2.length) {
			return 0;
		}

		int minLength = Math.min(length1, length2);

		// small array, simple compare method
		if (minLength < 8) {
			return scompare(buffer1, offset1, length1, buffer2, offset2,
					length2);
		}

		int minLongBytes = ( minLength / BYTES ) * BYTES;
		int offset1Adj = offset1 + BYTE_ARRAY_BASE_OFFSET;
		int offset2Adj = offset2 + BYTE_ARRAY_BASE_OFFSET;
		
		int i = 0;
		for ( ; i < minLongBytes; i += BYTES) {
			long lw = up.getLong(buffer1, offset1Adj + (long) i);
			long rw = up.getLong(buffer2, offset2Adj + (long) i);
			long diff = lw ^ rw;

			if (diff != 0) {
				int base1 = offset1 + i;
				int base2 = offset2 + i;
				for(int k = 0; k < BYTES; k++){
					if(buffer1[base1 + k] == buffer2[base2 + k])
						continue;
					return buffer1[base1 + k] - buffer2[base2 + k];
				}
			}
		}
		
		for( ; i < minLength; i++){
			if(buffer1[offset1+i]==buffer2[offset2+i])
				continue;
			return buffer1[offset1+i] - buffer2[offset2+i];
		}
		
		return length1 - length2;
	}

	private int scompare(byte[] buffer1, int offset1, int length1,
			byte[] buffer2, int offset2, int length2) {
		int end1 = offset1 + length1;
		int end2 = offset2 + length2;
		for (int i = offset1, j = offset2; i < end1 && j < end2; i++, j++) {
			int a = (buffer1[i] & 0xff);
			int b = (buffer2[j] & 0xff);
			if (a != b) {
				return a - b;
			}
		}
		return length1 - length2;
	}

}
