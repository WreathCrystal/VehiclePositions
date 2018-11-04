package com.bmw.test.model;


/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
public class VehiclePosition {
	/*
	 * timestamp for inserting a certain vehicle position
	 */
	private long  time; 
	
	/*
	 * the identification of a certain vehicle
	 */
	private String vehicleId;
	
	/*
	 * the session identification of a certain vehicle position
	 */
    private String  session;
    
    /*
     * the latitude of a vehicle position
     */
    private double lat;
    
    /*
     * the longititude of a vehicle position
     */
    private double lon;
    
    
    private int heading;
    
    
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public int getHeading() {
		return heading;
	}
	public void setHeading(int heading) {
		this.heading = heading;
	}
    
}
