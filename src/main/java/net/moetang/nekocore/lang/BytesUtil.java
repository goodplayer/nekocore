package net.moetang.nekocore.lang;

public class BytesUtil {
	public final static byte[] shortToBytes(short src) {
		return shortToBytes(src, false);
	}

	public final static byte[] shortToBytes(short src, boolean isBigEndian) {
		byte[] r = new byte[2];
		if (isBigEndian) {
			r[1] = (byte) (src & 0xff);
			r[0] = (byte) ((src >> 8) & 0xff);
		} else {
			r[0] = (byte) (src & 0xff);
			r[1] = (byte) ((src >> 8) & 0xff);
		}
		return r;
	}
	public final static byte[] intToBytes(int src) {
		return intToBytes(src, false);
	}

	public final static byte[] intToBytes(int src, boolean isBigEndian) {
		byte[] r = new byte[4];
		if (isBigEndian) {
			r[3] = (byte) (src & 0xff);
			r[2] = (byte) ((src >> 8) & 0xff);
			r[1] = (byte) ((src >> 16) & 0xff);
			r[0] = (byte) ((src >> 24) & 0xff);
		} else {
			r[0] = (byte) (src & 0xff);
			r[1] = (byte) ((src >> 8) & 0xff);
			r[2] = (byte) ((src >> 16) & 0xff);
			r[3] = (byte) ((src >> 24) & 0xff);
		}
		return r;
	}

	public final static byte[] longToBytes(long src) {
		return longToBytes(src, false);
	}

	public final static byte[] longToBytes(long src, boolean isBigEndian) {
		byte[] r = new byte[8];
		if (isBigEndian) {
			r[7] = (byte) (src & 0xff);
			r[6] = (byte) ((src >> 8) & 0xff);
			r[5] = (byte) ((src >> 16) & 0xff);
			r[4] = (byte) ((src >> 24) & 0xff);
			r[3] = (byte) ((src >> 32) & 0xff);
			r[2] = (byte) ((src >> 40) & 0xff);
			r[1] = (byte) ((src >> 48) & 0xff);
			r[0] = (byte) ((src >> 56) & 0xff);
		} else {
			r[0] = (byte) (src & 0xff);
			r[1] = (byte) ((src >> 8) & 0xff);
			r[2] = (byte) ((src >> 16) & 0xff);
			r[3] = (byte) ((src >> 24) & 0xff);
			r[4] = (byte) ((src >> 32) & 0xff);
			r[5] = (byte) ((src >> 40) & 0xff);
			r[6] = (byte) ((src >> 48) & 0xff);
			r[7] = (byte) ((src >> 56) & 0xff);
		}
		return r;
	}

	public final static byte[] xor(byte[] x1, byte[] x2) {
		byte[] out = new byte[x1.length];
		for (int i = 0; i < x1.length; i++) {
			out[i] = (byte) (x1[i] ^ x2[i]);
		}
		return out;
	}

}
