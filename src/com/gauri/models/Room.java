package com.gauri.models;

import java.time.LocalTime;
import java.util.List;

public class Room implements IRoomHandler{
	private String roomType;
	private List<Device> devices;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room(String roomType, List<Device> devices) {
		super();
		this.roomType = roomType;
		this.devices = devices;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "\nRoomType::" + roomType + 
				"\n Devices::\n" + this.getDevices() ;
	}

	@Override
	public void addDevice(String deviceName, String deviceType) {
		this.getDevices().add(new Device(deviceName,deviceType));
	}
	@Override
	public void displayStatusForAllDevice() {
		//this points to current room object
		for(Device device:this.getDevices())
		{
			System.out.println(device.getDeviceName()+" is "+(device.getIsDeviceTurnOn()?" ON":" OFF"));
		}
	}
	@Override
	public void displayStatusForSpecificDeviceInSpecificRoom(Room room, String deviceName) {
		for(Device device:room.getDevices())
		{
			if(device.getDeviceName().equals(deviceName))
			System.out.println(device.getDeviceName()+" is "+(device.getIsDeviceTurnOn()?" ON":" OFF"));
		}
	}
	@Override
	public void displayOnTimeForDevice(String deviceName) {
		for(Device device:this.getDevices())
		{
			if(device.getDeviceName().equals(deviceName))
			System.out.println(device.getDeviceName()+" is "+(device.countTime(device)));
		}
	}
	@Override
	public void changeStatus(String deviceName) {
		System.out.println("You want to change the status for Device:"+deviceName);
		boolean isDeviceExist=false;
		
		Device existingDevice=new Device();
		
		for(Device d:this.getDevices())
		{
			if(d.getDeviceName().equals(deviceName))
			{
				existingDevice=d;
				isDeviceExist=true;
			}
		}
		if(isDeviceExist) {
			if(existingDevice.getIsDeviceTurnOn())//if turn on then turn off
			{
				System.out.println(existingDevice.getDeviceName()+"==>previous status was:"+(existingDevice.getIsDeviceTurnOn()?"ON":"OFF"));
				existingDevice.deviceTurnOff();
				existingDevice.setEndTime(LocalTime.now());
				System.out.println(existingDevice.getDeviceName()+"==>Current status is:"+(existingDevice.getIsDeviceTurnOn()?"ON":"OFF"));
			}
			else//if turn off then turn on
			{
				System.out.println(existingDevice.getDeviceName()+"==>previous status was:"+(existingDevice.getIsDeviceTurnOn()?"ON":"OFF"));
				existingDevice.deviceTurnOn();
				existingDevice.setStartTime(LocalTime.now());
				System.out.println(existingDevice.getDeviceName()+"==>Current status is:"+(existingDevice.getIsDeviceTurnOn()?"ON":"OFF"));
			}
		}
		else
		{
			System.out.println("Device not found...");
		}
	}
}
