package net.moetang.nekocore.ioc;

/**
 * 所有完成获取Bean功能的类必须实现的接口
 *
 */
public interface Context {
	public <T> T get(String name, Class<T> clazz);
}
