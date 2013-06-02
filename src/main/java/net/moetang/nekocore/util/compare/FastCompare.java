package net.moetang.nekocore.util.compare;

import net.moetang.nekocore.jdk.sun.utils.NativeFastCompare;

public class FastCompare extends SoftCompare {
	private Compare compare;

	public FastCompare() {
		this.compare = NativeFastCompare.getInstance();
	}

	@Override
	public <T> int compare(byte[] array1, int offset1, byte[] array2,
			int offset2, int length) {
		if (this.compare != null) {
			return compare(array1, offset1, array2, offset2, length);
		}
		return super.compare(array1, offset1, array2, offset2, length);
	}
}
