package net.moetang.nekocore.util.timeservice;

public interface TimeService {
	public long currentTimeMillis();
	public void shutdown();
	/**
	 * NOTE: 不要尝试将此值转换为时间，此值仅用于统计两个时间点的间隔
	 * @return nano time
	 */
	public long currentTimeNano();
}
