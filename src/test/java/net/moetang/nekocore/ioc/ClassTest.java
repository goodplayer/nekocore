package net.moetang.nekocore.ioc;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.moetang.nekocore.util.clazz.thirdpart.PackageUtil;

import org.junit.Assert;
import org.junit.Test;

public class ClassTest {
	@Test
	public void testGetClassName(){
		Assert.assertEquals("net.moetang.nekocore.ioc.ClassTest", this.getClass().getName());
		
		Assert.assertEquals("net.moetang.nekocore.ioc.haha", haha.class.getName());
	}
	
	@Test
	public void testInheritedFields(){
		for(Field field : B.class.getFields()){
			System.out.println(field.getName());
		}
		Assert.assertEquals(2, B.class.getFields().length);
		System.out.println("===========inherited field============");
		for(Field field : B.class.getDeclaredFields()){
			System.out.println(field.getName());
		}
		Assert.assertEquals(5, B.class.getDeclaredFields().length);
		System.out.println("=======================");
		
	}
	
	@Test
	public void testGetSuperclass(){
		Class<?> clazz = new A().getClass();
		do{
			System.out.println(clazz);
			clazz = this.getParentClass(clazz);
		}while(clazz != null);
	}
	protected Class<?> getParentClass(Class<?> clazz){
		return clazz.getSuperclass();
	}
	@Test
	public void testGetSuperclass2(){
		Class<?> clazz = new B().getClass();
		do{
			System.out.println(clazz);
			clazz = this.getParentClass(clazz);
		}while(clazz != null);
	}
	
	@Test
	public void testGetFieldType(){
		Class<?> clazz = field.class;
		Assert.assertEquals("java.lang.String", clazz.getDeclaredFields()[1].getType().getName());
	}
	
	@Test
	public void testGetGenericType(){
		Class<?> clazz = field.class;
		System.out.println("==");
		System.out.println(clazz.getDeclaredFields()[1].getGenericType());
		System.out.println(clazz.getDeclaredFields()[2].getGenericType());
		System.out.println(clazz.getDeclaredFields()[1].getType().getName());
		System.out.println(clazz.getDeclaredFields()[2].getType().getName());
		System.out.println(clazz.getSuperclass().getName());
		System.out.println(clazz.getGenericSuperclass());
		System.out.println("==");
	}
	
	@Test
	public void testGetPackageClass(){
		System.out.println("=========package class==========");
		List<String> l = PackageUtil.getClassInPackage("net.moetang.nekocore.ioc");
		for(String className : l){
			System.out.println(className);
		}
		System.out.println("================================");
	}
	
	@Test
	public void testGetPackageName(){
		System.out.println(this.getClass().getPackage().getName());
	}
}

class field extends HashMap<String, String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String haha;
	Map<String , String > lala;
}

interface haha{
	
}

class A implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a1;
	int a2;
	protected int a3;
	public int a4;
}
class B extends A{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int b1;
	int b2;
	protected int b3;
	public int b4;
}
