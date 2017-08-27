package com.github.luohaha.MyTT.core;

public class Time {
	
	// 当前的时间 ns
	private long currentTime;
	// 当前的误差
	private long currentError;
	public Time(long currentTime, long currentError) {
		super();
		this.currentTime = currentTime;
		this.currentError = currentError;
	}
	public long getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	public long getCurrentError() {
		return currentError;
	}
	public void setCurrentError(long currentError) {
		this.currentError = currentError;
	}
	
	
}
