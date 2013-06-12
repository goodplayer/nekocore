package net.moetang.nekocore.text;

import org.junit.Assert;
import org.junit.Test;

public class BinaryConvertTest {
	@Test
	public void testByte() {
		Assert.assertEquals("00000001", BinaryConvert.toBinary((byte)1));
	}
	
	@Test
	public void testByteArray(){
		Assert.assertEquals("10000000 01000000", BinaryConvert.toBinary(new byte[]{1, 2}));
	}

	@Test
	public void testShort() {
		Assert.assertEquals("00000000 00000001", BinaryConvert.toBinary((short)1));
	}
	@Test
	public void testInt() {
		Assert.assertEquals("00000000 00000000 00000000 00000001", BinaryConvert.toBinary((int)1));
	}
	@Test
	public void testLong() {
		Assert.assertEquals("00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000001", BinaryConvert.toBinary((long)1));
	}
}
