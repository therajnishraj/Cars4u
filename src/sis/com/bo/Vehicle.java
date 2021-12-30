package sis.com.bo;

public class Vehicle {
	private long id;
	private String vehicleType;
	private String vehicleName;
	private String vehicleNo;
	private int vehicleCapacity;
	private float vehicleCost;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public int getVehicleCapacity() {
		return vehicleCapacity;
	}
	public void setVehicleCapacity(int vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}
	public float getVehicleCost() {
		return vehicleCost;
	}
	public void setVehicleCost(float vehicleCost) {
		this.vehicleCost = vehicleCost;
	}

}
