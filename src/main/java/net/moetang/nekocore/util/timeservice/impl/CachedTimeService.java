package net.moetang.nekocore.util.timeservice.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import net.moetang.nekocore.util.timeservice.TimeService;

public class CachedTimeService implements TimeService {
	private ScheduledExecutorService executor;
	private volatile long time = System.currentTimeMillis();

	private CachedTimeService() {
	}

	@Override
	public long currentTimeMillis() {
		return time;
	}
	@Override
	public void shutdown() {
		try {
			executor.shutdown();
			this.executor = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void buildInstance(TimeUnit timeUnit, long tickUnit){
		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				time = System.currentTimeMillis();
			}
		}, tickUnit, tickUnit, timeUnit);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				if( executor != null)
					executor.shutdown();
			}
		});
	}

	public static TimeService createMillisTimeService(long period){
		CachedTimeService cts = new CachedTimeService();
		if(period < 1)
			period = 50;//default is 50
		cts.buildInstance(TimeUnit.MILLISECONDS, period);
		return cts;
	}

	@Override
	public long currentTimeNano() {
		return System.nanoTime();
	}

}
