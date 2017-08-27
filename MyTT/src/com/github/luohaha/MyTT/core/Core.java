package com.github.luohaha.MyTT.core;

import java.util.logging.Logger;

public class Core {
	private Logger logger = Logger.getLogger("Core");
	private Time time;
	private Machine machine;
	
	/**
	 * 回复当前时间范围
	 * @return
	 */
	public Time reply() {
		long c = System.nanoTime();
		long e = machine.getLastReviseError() + 
				(c - machine.getLastReviseTime()) / 1000000 * machine.getDriftRate();
		return new Time(c, e);
	}
	
	/**
	 * 处理接受到的回复
	 * @param other
	 * @param delay
	 * @return
	 */
	public boolean receiveReply(Time other, long delay) {
		Time cur = reply();
		if (!isConsistent(cur, other))
			return false;
		long newError = other.getCurrentTime() + delay + delay / 1000000 * machine.getDriftRate();
		if (newError <= cur.getCurrentError()) {
			machine.setLastReviseError(newError);
			machine.setLastReviseTime(other.getCurrentTime());
			// 修改当前时间
			if (!alterSystemTime(other.getCurrentTime())) {
				logger.severe("can't alter system time!");
			}
		}
		return true;
	}
	
	/**
	 * 修改系统时间
	 * @param ns
	 * 系统时间单位为ns
	 * @return
	 * 是否修改成功
	 */
	private boolean alterSystemTime(long ns) {
		return true;
	}
	
	/**
	 * 检查是否一致
	 * @param t1
	 * @param t2
	 * @return
	 * 是否一致
	 */
	private boolean isConsistent(Time t1, Time t2) {
		if (t1.getCurrentTime() + t1.getCurrentError() < t2.getCurrentTime() - t2.getCurrentError())
			return false;
		if (t1.getCurrentTime() - t1.getCurrentError() > t2.getCurrentTime() + t2.getCurrentError())
			return false;
		return true;
	}
}
