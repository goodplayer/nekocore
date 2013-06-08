package net.moetang.nekocore.lang;

import org.junit.Test;

public class ArrayUtilTest {
	@Test
	public void testConcat(){
		Print.printArray(ArrayUtil.concat(new String[]{"hello"}, new String[]{"laji"}, new String[]{"bye"}));
	}
}
