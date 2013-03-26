package net.moetang.nekocore.ioc.container;

import net.moetang.nekocore.ioc.Context;
import net.moetang.nekocore.ioc.annotation.DI;
import net.moetang.nekocore.ioc.annotation.ResourceBean;
import net.moetang.nekocore.ioc.container.helper.SimpleAnnotationIocContainerHelper;

import org.junit.Assert;
import org.junit.Test;

public class SimpleAnnotationIocContainerTest {
	@Test
	public void testRegister(){
		SimpleAnnotationIocContainerHelper helper = new SimpleAnnotationIocContainerHelper();
		helper.addPackage(this.getClass().getPackage());
		Context context = helper.createContainer();
		Assert.assertNotEquals(null, context.get(A.class.getName(), A.class));
		Assert.assertNotEquals(null, context.get(B.class.getName(), B.class).getA());
		Assert.assertNotEquals(null, context.get("indexAction", C.class));
		Assert.assertNotEquals(null, context.get("indexAction", C.class).getA());
		Assert.assertNotEquals(null, context.get("indexAction", C.class).getB());
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