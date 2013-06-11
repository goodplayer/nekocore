package net.moetang.nekocore.text;

import org.junit.Assert;
import org.junit.Test;

public class HexConvertTest {
	@Test
	public void testToHex(){
		byte[] dd = new byte[]{34,56,23,5,5,23,7,2,78,23,8};
		Assert.assertEquals(HexConvert.toHex(dd), HexConvert.toHexFast(dd));
	}
}
