package com.mes.c3rm.common.model;

public class ContainerModel {
	private String id;
	private String name;
	private String imageName;
	private String instanceType;
	private double cpuPercent;
	private long usedMemory;
	private long availableMemory;
	private long totalMemory;
	private long storage;
	private boolean running;
	private String ipAddress;
	private String macAddress;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}


	public long getStorage() {
		return storage;
	}

	public void setStorage(long storage) {
		this.storage = storage;
	}

	public double getCpuPercent() {
		return cpuPercent;
	}

	public void setCpuPercent(double cpuPercent) {
		this.cpuPercent = cpuPercent;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public long getAvailableMemory() {
		return availableMemory;
	}

	public void setAvailableMemory(long availableMemory) {
		this.availableMemory = availableMemory;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}
}
