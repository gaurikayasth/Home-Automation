package com.gauri.models;

public interface IRoomHandler {
	void addDevice(String deviceName,String deviceType);
	
	void displayStatusForAllDevice();
	
	void displayStatusForSpecificDeviceInSpecificRoom(Room room,String deviceName);
	
	void displayOnTimeForDevice(String deviceName);
	
	void changeStatus(String deviceName);

}
