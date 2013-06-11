package net.moetang.nekocore.util.timer;

public interface MillisTimeCount {
	/**
	 * write down the time when this method is invoked
	 */
	public void atThisPoint();
	
	/**
	 * @return the time of all the points added
	 */
	public long countTime();
	
	/**
	 * return the time of (toIndex - fromIndex)
	 * @param from
	 * @param to
	 * @return (to - from)
	 */
	public long countTime(int from, int to);
	
	/**
	 * set Time Count to initialized status
	 */
	public void reset();
}
