package com.siri.esmartHealthCare.beans;

public class BedBean {
	private int bid;
	private double costperday;
	private boolean availability;
	
	private BedTypeBean btbean;
	
	
	
	public BedBean(BedTypeBean btbean) {
		this.btbean = btbean;
	}
	public BedTypeBean getBtbean() {
		return btbean;
	}
	/*public void setBtbean(BedTypeBeans btbean) {
		this.btbean = btbean;
	}*/
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public double getCostperday() {
		return costperday;
	}
	public void setCostperday(double costperday) {
		this.costperday = costperday;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	

}
