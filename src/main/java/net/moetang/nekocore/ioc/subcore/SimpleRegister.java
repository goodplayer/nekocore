package net.moetang.nekocore.ioc.subcore;

public interface SimpleRegister {
	public void register(String name, Object o);
	public void register(Class<?> clazz);
	public void register(Class<?> clazz, String name);
	public void unregister(String name);
	public void unregister(Class<?> clazz);
}
