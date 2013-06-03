package net.moetang.nekocore.util.compare;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest {
	@Test
	public void testSoftCompare(){
		Compare c = new SoftCompare();
		
		byte[] bytes1 = {1, 2, 3, 4, 5, 6, 7};
		byte[] bytes2 = {1, 2, 3, 4, 5, 6, 7};
		byte[] bytes3 = {1, 2, 3, 4, 5, 6, 8};

		assertEquals(0, c.compare(bytes1, bytes2));
		assertNotEquals(0, c.compare(bytes1, bytes3));

		String[] strs1 = {new String("1"), new String("2"), new String("3"), new String("4")};
		String[] strs2 = {new String("1"), new String("2"), new String("3"), new String("4")};
		String[] strs3 = {new String("1"), new String("2"), new String("3"), new String("3")};

		assertEquals(false, c.compare(strs1, strs2));
		assertEquals(true, c.deepCompare(strs1, strs2));
		assertEquals(false, c.compare(strs1, strs3));
		assertEquals(false, c.deepCompare(strs1, strs3));
	}
}
