package net.moetang.nekocore.util.timeservice.impl;

import net.moetang.nekocore.util.timeservice.TimeService;

public class SystemTimeService implements TimeService {

	@Override
	public long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	@Override
	public void shutdown() {
	}

	@Override
	public long currentTimeNano() {
		return System.nanoTime();
	}

}
