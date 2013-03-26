package net.moetang.nekocore.ioc.container.helper;

import java.util.List;

import net.moetang.nekocore.ioc.IocContainer;
import net.moetang.nekocore.ioc.container.SimpleAnnotationIocContainer;
import net.moetang.nekocore.util.clazz.thirdpart.PackageUtil;

public class SimpleAnnotationIocContainerHelper {
	private SimpleAnnotationIocContainer container;
	private boolean isReady = false;
	
	public SimpleAnnotationIocContainerHelper() {
		container = new SimpleAnnotationIocContainer();
		container.init();
	}
	
	public void addClass(Class<?> clazz){
		container.register(clazz);
	}
	
	public void addPackage(Package pkg){
		this.addPackage(pkg.getName());
	}
	
	public void addPackage(String pkgName){
		List<String> list = PackageUtil.getClassInPackage(pkgName);
		for(String className : list){
			try {
				this.addClass(Class.forName(className));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public IocContainer createContainer(){
		if(!isReady){
			container.prepare();
			isReady = true;
		}
		return container;
	}
}
