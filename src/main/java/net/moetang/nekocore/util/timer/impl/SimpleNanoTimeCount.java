package net.moetang.nekocore.util.timer.impl;

import net.moetang.nekocore.util.timer.NanoTimeCount;

public class SimpleNanoTimeCount implements NanoTimeCount {
	private long start = 0;
	private long end = 0;
	private boolean startSet = false;
	private boolean endSet = false;

	@Override
	public void atThisPoint() {
		if(!startSet){
			this.start = System.nanoTime();
			this.startSet = true;
		}else if(!endSet){
			this.end = System.nanoTime();
			this.endSet = true;
		}
	}

	@Override
	public long countTime() {
		if((!startSet) || (!endSet)){
			return -1;
		}
		return (end - start);
	}

	@Override
	public long countTime(int from, int to) {
		return countTime();
	}
	
	@Override
	public String toString() {
		if((!startSet) || (!endSet)){
			return "please set two point in order to calculate during time";
		}
		return "The time between two point is "+this.countTime()+" ns";
	}

	@Override
	public void reset() {
		this.startSet = false;
		this.endSet = false;
	}

}
