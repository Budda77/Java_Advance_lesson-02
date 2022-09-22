package ua.lviv.homework;

public class Vehicle {
	private int id;
	private String manufacture;
	private String model;
	private String color;
	private int year;
	
	
	public Vehicle(int id, String manufacture, String model, String color, int year) {
		super();
		this.id = id;
		this.manufacture = manufacture;
		this.model = model;
		this.color = color;
		this.year = year;
	}
	
	public Vehicle(String manufacture, String model, String color, int year) {
		this.manufacture = manufacture;
		this.model = model;
		this.color = color;
		this.year = year;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", manufacture=" + manufacture + ", model=" + model + ", color=" + color
				+ ", year=" + year + "]";
	}
	
	
	

}
