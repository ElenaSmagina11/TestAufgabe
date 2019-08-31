package de.automedia;

import java.math.BigInteger;

public class Meeting {

	private BigInteger startTime;
	private BigInteger endTime;

	public Meeting(BigInteger startTime, BigInteger endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public BigInteger getStartTime() {
		return startTime;
	}

	public void setStartTime(BigInteger startTime) {
		this.startTime = startTime;
	}

	public BigInteger getEndTime() {
		return endTime;
	}

	public void setEndTime(BigInteger endTime) {
		this.endTime = endTime;
	}

}