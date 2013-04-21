package net.moetang.nekocore.jdk.sun.unsafe;

import org.junit.Assert;
import org.junit.Test;

public class UnsafeUtilsTest {
	@Test
	public void testIfUnsafeGet(){
		Assert.assertNotNull(UnsafeUtils.getUnsafe());
	}
	
	@Test
	public void testUseUnsafe(){
		UnsafeUtils.UnsafeProxy proxy = UnsafeUtils.getProxy();
		System.out.println(proxy.addressSize());
		System.out.println(proxy.pageSize());
	}
	
}
