package com.github.luohaha.MyTT.core;

public class TrueTime {
	private Core core;
	
	class TTinterval {
		long earliest;
		long latest;
		
		public TTinterval(long earliest, long latest) {
			super();
			this.earliest = earliest;
			this.latest = latest;
		}
		public long getEarliest() {
			return earliest;
		}
		public void setEarliest(long earliest) {
			this.earliest = earliest;
		}
		public long getLatest() {
			return latest;
		}
		public void setLatest(long latest) {
			this.latest = latest;
		}
		
	}

	public TrueTime(Core core) {
		super();
		this.core = core;
	}
	
	public TTinterval now() {
		Time time = this.core.reply();
		return new TTinterval(time.getCurrentTime() - time.getCurrentError(), 
				time.getCurrentTime() + time.getCurrentError());
	}
	
	public boolean after(long timestamp) {
		Time time = this.core.reply();
		return time.getCurrentTime() - time.getCurrentError() > timestamp;
	}
	
	public boolean before(long timestamp) {
		Time time = this.core.reply();
		return time.getCurrentTime() + time.getCurrentError() < timestamp;
	}
}
