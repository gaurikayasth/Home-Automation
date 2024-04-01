package com.gauri.models;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Device implements IControllable{
	private String deviceName;
	private String deviceType;
	private Boolean isDeviceTurnOn;
	private Integer onTime;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public Device() {
		
	}
	
	public Device(String deviceName, String deviceType, Boolean isDeviceTurnOn, Integer onTime, LocalTime startTime,
			LocalTime endTime) {
		super();
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.isDeviceTurnOn = isDeviceTurnOn;
		this.onTime = onTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Device(String deviceName, String deviceType) {
		super();
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.isDeviceTurnOn = true;
		this.startTime = LocalTime.now();
		this.endTime = LocalTime.of(0, 0, 0, 0);
	}
	
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Boolean getIsDeviceTurnOn() {
		return isDeviceTurnOn;
	}

	public void setIsDeviceTurnOn(Boolean isDeviceTurnOn) {
		this.isDeviceTurnOn = isDeviceTurnOn;
	}

	public Integer getOnTime() {
		return onTime;
	}

	public void setOnTime(Integer onTime) {
		this.onTime = onTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "\n\nDeviceName=" + deviceName + 
				"\nDeviceType=" + deviceType +
				"\nisDeviceTurnOn=" + isDeviceTurnOn
				+ "\nOnTime=" + onTime + 
				"\nStartTime=" + startTime +
				"\nEndTime=" + endTime ;		
	}

	@Override
	public void deviceTurnOn() {
		this.setIsDeviceTurnOn(true);
		this.setStartTime(LocalTime.now());
	}
	@Override
	public void deviceTurnOff() {
		this.setIsDeviceTurnOn(false);
		this.setEndTime(LocalTime.now());
	}
	@Override
	public Integer countTime(Device device) {
		if(device.getStartTime()!=null)
		{
			device.setOnTime((int)device.getStartTime().until(device.getEndTime(),ChronoUnit.SECONDS));
			return device.getOnTime();
		}
		else
		return null;
	}
}
