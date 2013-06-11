package net.moetang.nekocore.text;

import net.moetang.nekocore.lang.Chars;

public class HexConvert {
	public final static String toHex(byte[] buffer) {
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 15, 16));
		}
		return sb.toString();
	}
	public final static String toHexFast(byte[] buffer) {
		return toHexFast(buffer, 0, buffer.length);
	}
	public final static String toHexFast(byte[] buffer, int offset, int len){
		StringBuffer sb = new StringBuffer(len * 2);
		int stopPos = offset + len;
		for (int i = offset; i < stopPos; i++) {
			sb.append(Chars.HEX_CHARS[(buffer[i] & 0xf0) >> 4]);
			sb.append(Chars.HEX_CHARS[buffer[i] & 0x0f]);
		}
		return sb.toString();
	}
}
