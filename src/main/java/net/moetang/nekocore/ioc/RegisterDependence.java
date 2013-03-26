package net.moetang.nekocore.ioc;

import java.util.EnumMap;

/**
 * 所有完成注册功能的类必须实现的接口
 *
 */
interface RegisterDependence {
	public void register(Object o, EnumMap<RegParam, String> param);
	public void unregister(EnumMap<RegParam, String> param);
	
	public static enum RegParam{
		/**
		 * 注册的名称
		 */
		NAME,
		/**
		 * 是实例化后的对象还是Class对象<br />
		 * preferred value: "class", "obj"
		 */
		OBJ_TYPE,
		/**
		 * 如何解析第一个参数<br />
		 * 比如同时要以第一个参数的名称注册，此处推荐定义为："REG_CLASSNAME"<br />
		 * 另如如果解除注册时要解除所有关联的注册，此处可以定义为："UNREG_ALLREF" 以NAME为准，没有第一个参数<br />
		 * 可自定义
		 */
		OBJ_RESOLVE_TYPE,
		/**
		 * 作用域，可自定，比如请求、会话、应用程序等
		 */
		SCOPE,
		/**
		 * 创建方式，单例或原型
		 */
		CREATION_MODE,
		/**
		 * 加载方式：懒加载或其他
		 */
		LOAD_MODE,
		/**
		 * 初始化方法名称
		 */
		INIT_METHOD,
		/**
		 * 销毁方法名称
		 */
		DESTROY_METHOD,
		/**
		 * 此object的依赖状态<br />
		 * 例如: 拥有完整依赖,不需要注入的obj: "complete"<br />
		 * 还没有完整依赖,需要注入的obj: "empty"<br />
		 */
		DEPENDENCE_STATUS,
		/**
		 * 其他信息
		 */
		OTHER,
		;
	}
}
