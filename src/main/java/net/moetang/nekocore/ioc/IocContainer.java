package net.moetang.nekocore.ioc;

/**
 * 完整IOC功能的容器必须实现的接口<br />
 * 执行顺序: init -> (register|unregister) -> prepare -> (use) -> destroy<br />
 */
public interface IocContainer extends Context, RegisterDependence {
	/**
	 * 初始化容器
	 */
	public void init();
	/**
	 * 当完成所有资源的注册之后,准备beans
	 */
	public void prepare();
	/**
	 * 销毁容器
	 */
	public void destroy();
}
