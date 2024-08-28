package com.gym;

public class Participant {
    private int id;
    private String name;
    private int batchId;

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
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Participant{" +
				"id=" + id +
				", name='" + name + '\'' +
				", batchId=" + batchId +
				'}';
	}
}