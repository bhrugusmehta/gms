package com.gym;

public class Batch {
    private int id;
    private String name;
    private String timeOfDay;
    public Batch() {}

    public Batch(int id, String name, String timeSlot) {
        this.id = id;
        this.name = name;
        this.timeOfDay = timeSlot;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	@Override
	public String toString() {
		return "Batch{" +
				"id=" + id +
				", name='" + name + '\'' +
				", timeOfDay='" + timeOfDay + '\'' +
				'}';
	}
}