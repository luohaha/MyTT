package com.github.luohaha.MyTT.core;

public class Machine {
	// 机器上的时间漂移速率，ns/ms 或者 us/s
	private long driftRate;
	// 上次校正的时间 ns
	private long lastReviseTime;
	// 上次校正的误差 ns
	private long lastReviseError;
	public Machine(long driftRate, long lastReviseTime, long lastReviseError) {
		super();
		this.driftRate = driftRate;
		this.lastReviseTime = lastReviseTime;
		this.lastReviseError = lastReviseError;
	}
	public long getDriftRate() {
		return driftRate;
	}
	public void setDriftRate(long driftRate) {
		this.driftRate = driftRate;
	}
	public long getLastReviseTime() {
		return lastReviseTime;
	}
	public void setLastReviseTime(long lastReviseTime) {
		this.lastReviseTime = lastReviseTime;
	}
	public long getLastReviseError() {
		return lastReviseError;
	}
	public void setLastReviseError(long lastReviseError) {
		this.lastReviseError = lastReviseError;
	}

	
	
}
