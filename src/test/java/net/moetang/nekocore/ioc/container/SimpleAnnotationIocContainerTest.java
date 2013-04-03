package net.moetang.nekocore.ioc.container;

import net.moetang.nekocore.ioc.Context;
import net.moetang.nekocore.ioc.annotation.DI;
import net.moetang.nekocore.ioc.annotation.ResourceBean;
import net.moetang.nekocore.ioc.container.helper.SimpleAnnotationIocContainerHelper;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleAnnotationIocContainerTest {
	private static Context testContainer;
	@BeforeClass
	public static void makeContainer(){
		SimpleAnnotationIocContainerHelper helper = new SimpleAnnotationIocContainerHelper();
		helper.addPackage(SimpleAnnotationIocContainerTest.class.getPackage());
		SimpleAnnotationIocContainerTest.testContainer = helper.createContainer();
	}
	@Test
	public void testRegister(){
		Assert.assertNotEquals(null, testContainer.get(A.class.getName(), A.class));
		Assert.assertNotEquals(null, testContainer.get(B.class.getName(), B.class).getA());
		Assert.assertNotEquals(null, testContainer.get("indexAction", C.class));
		Assert.assertNotEquals(null, testContainer.get("indexAction", C.class).getA());
		Assert.assertNotEquals(null, testContainer.get("indexAction", C.class).getB());
	}
	@Test
	public void testExternalInjection(){
		C c = new C();
		Assert.assertNull(c.getA());
		Assert.assertNull(c.getB());
		
		SimpleAnnotationIocContainerTest.testContainer.inject(c);

		Assert.assertNotNull(c.getA());
		Assert.assertNotNull(c.getB());
	}
}
@ResourceBean
class A{
	
}

@ResourceBean
class B{
	@DI
	private A a;
	public A getA() {
		return a;
	}
}

@ResourceBean("indexAction")
class C{
	@DI
	private A a;
	@DI
	private B b;
	public A getA() {
		return a;
	}
	public B getB() {
		return b;
	}
}