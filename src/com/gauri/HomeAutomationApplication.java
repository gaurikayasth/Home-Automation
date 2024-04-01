package com.gauri;
import java.util.ArrayList;
import java.util.List;
import com.gauri.models.Room;
import com.gauri.models.Device;
import java.util.Scanner;
public class HomeAutomationApplication {
	private static List<Room> rooms=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice = 0;
		do
		{
			System.out.println("==========================================");
			System.out.println("Home Automation Menu::");
			System.out.println("1.Add device in existing room");
			System.out.println("2.Change Status of device");
			System.out.println("3.Check the status of each room and the devices in it");
			System.out.println("4.Total time the device is in the current state");
			System.out.println("5.Add new room and devices in it");
			System.out.println("6.Check the status for specific device in specific room");
			System.out.println("7.Exit");
			System.out.println("==========================================");
			
			System.out.println("Enter Your Choice::");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Room Type to add divice:");
				String roomType=sc.next();
				boolean found=false;
				for(int i=0;i<rooms.size();i++)
				{
					if(rooms.get(i).getRoomType().equalsIgnoreCase(roomType))
					{
						found=true;
						System.out.println("Enter Device Name:");
						String deviceName=sc.next();
						System.out.println("Enter Device Type;");
						String deviceType=sc.next();
						rooms.get(i).addDevice(deviceName,deviceType);
					}
				}
				if(found)
					System.out.println("Device Added successfully");
				else
					System.out.println("room not found!");
				
				break;
			case 2:
				System.out.println("Enter Room Type to change the status:");
			    roomType=sc.next();
				found=false;
				for(int i=0;i<rooms.size();i++)
				{
					if(rooms.get(i).getRoomType().equalsIgnoreCase(roomType))
					{
						found=true;
						System.out.println("Enter Device Name:");
						String deviceName=sc.next();
						rooms.get(i).changeStatus(deviceName);
					}
				}
				if(found)
					System.out.println("Status Changed successfully");
				else
					System.out.println("room not found!");
				break;
			case 3:
				for(int i=0;i<rooms.size();i++)
				{
					System.out.println("\nRoom Type::"+rooms.get(i).getRoomType()+"\n"+"Divices::");
					rooms.get(i).displayStatusForAllDevice();
				}				
				break;
			case 4:
				System.out.println("Enter Room Type ");
				roomType=sc.next();
				found=false;
				for(int i=0;i<rooms.size();i++)
				{
					if(rooms.get(i).getRoomType().equalsIgnoreCase(roomType))
					{
						found=true;
						System.out.println("Enter Device Name to count total time:");
						String deviceName=sc.next();
						rooms.get(i).displayOnTimeForDevice(deviceName);
					}
				}
				if(found)
					System.out.println("");
				else
					System.out.println("room not found!");	
				break;
			case 5:
				System.out.println("You want to add new rooms...");
				for(Room room:rooms) {
					System.out.println(room.getRoomType());
				}
				
				System.out.println("\nEnter new room type::");
				String newRoomType=sc.next();
				
				System.out.println("How many devices you want to enter::");
				int no=sc.nextInt();
				List<Device> listOfDevicesInNewRoom=new ArrayList<>();
				for(int i=0;i<no;i++)
				{
					System.out.println("Enter New Device"+(i+1)+" Name:");
					String deviceName=sc.next();
					System.out.println("Enter New Device"+(i+1)+" Type:");
					String deviceType=sc.next();
					
					Device dNew=new Device(deviceName,deviceType);
					listOfDevicesInNewRoom.add(dNew);
				}
				Room newRoom=new Room(newRoomType,listOfDevicesInNewRoom);
				rooms.add(newRoom);
				System.out.println("\nNew Room Added...");
				System.out.println("------------------------");
				for(Room room:rooms) {
					System.out.println(room.getRoomType());
				}
				break;
			case 6:
				System.out.println("Enter Room Type to check the status:");
			    roomType=sc.next();
				found=false;
				for(int i=0;i<rooms.size();i++)
				{
					if(rooms.get(i).getRoomType().equalsIgnoreCase(roomType))
					{
						found=true;
						System.out.println("Enter Device Name:");
						String deviceName=sc.next();
						rooms.get(i).displayStatusForSpecificDeviceInSpecificRoom(rooms.get(i), deviceName);
						break;
					}
				}
				if(found)
					System.out.println("");
				else
					System.out.println("room not found!");
				break;
			case 7:
				System.out.println("Thank You!");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}while(choice!=7);
		sc.close();
}
}