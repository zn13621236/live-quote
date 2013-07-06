package com.archer.livequote.db.domain;

public class ZipCodeRange {

	private int minZip;
	private int maxZip;

	public int getMinZip() {
		return minZip;
	}

	public void setMinZip(int minZip) {
		this.minZip = minZip;
	}

	public int getMaxZip() {
		return maxZip;
	}

	public void setMaxZip(int maxZip) {
		this.maxZip = maxZip;
	}

	@Override
	public String toString() {
		return "ZipCodeRange [minZip=" + minZip + ", maxZip=" + maxZip + "]";
	}

}
