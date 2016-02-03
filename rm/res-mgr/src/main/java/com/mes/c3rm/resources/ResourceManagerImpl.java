package com.mes.c3rm.resources;

import java.util.ArrayList;
import java.util.List;

import com.mes.c3rm.common.model.ContainerModel;
import com.mes.c3rm.common.resources.ResourceManager;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ContainerInfo;
import com.spotify.docker.client.messages.ContainerStats;

public class ResourceManagerImpl implements ResourceManager{
	private DockerClient dockerClient = null;
	private String host;
	
	public ResourceManagerImpl() {
		this("http://127.0.0.1:2375");
	}
	
	public ResourceManagerImpl(String uri) {
		try {
			dockerClient = DefaultDockerClient.builder().uri(uri).build();
			host = dockerClient.getHost();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create a connection to the docker engine");
		} 
	}
	
	public String getHost() {
		return host;
	}

	public String createContainer(ContainerModel containerModel) {
		try {
			System.out.println("Creating container:"+ containerModel.getName());
			
			// pull image from repo
			System.out.println("Downloading container from repo: "+ containerModel.getImageName());
			dockerClient.pull(containerModel.getImageName());
			System.out.println("Container downloaded successfully: "+ containerModel.getImageName());
			
			
			ContainerConfig config = ContainerConfig.builder().image(containerModel.getImageName()).build();
			ContainerCreation container = dockerClient.createContainer(config, containerModel.getName());
			String containerId = container.id();
			System.out.println("Container created successfully: "+ containerModel.getImageName() + " id:" + containerId);
			start(containerId);
			dockerClient.waitContainer(containerId);
			
			return container.id();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error creating a container. Exception: "+ e.getMessage());
		}
	}

	public List<ContainerModel> getContainerList() {
		try {
			
			List<Container> containers = dockerClient.listContainers(DockerClient.ListContainersParam.allContainers(), 
					DockerClient.ListContainersParam.exitedContainers());
			if (containers.size() == 0) {
				return null;
			}
			
			System.out.println("Preparing container list");
			
			List<ContainerModel> containerList = new ArrayList<ContainerModel>();
			for (Container container: containers) {
				String containerId = container.id();
				
				ContainerModel containerModel = new ContainerModel();
				containerModel.setId(containerId);
				
				//container state
				ContainerInfo containerInfo = dockerClient.inspectContainer(containerId);
				containerModel.setRunning(containerInfo.state().running());
				containerModel.setMacAddress(containerInfo.networkSettings().macAddress());
				containerModel.setIpAddress(containerInfo.networkSettings().ipAddress());
				containerModel.setName(containerInfo.name());
				containerModel.setImageName(containerInfo.image());
				
				//cpu and memory statistics
				ContainerStats stats = dockerClient.stats(containerId);
				containerModel.setCpuPercent(calculatePercentCPU(stats));
				long usedMemory = stats.memoryStats().usage();
				long totalMemory = stats.memoryStats().limit();
				long availableMemory = totalMemory - usedMemory;
				
				containerModel.setAvailableMemory(availableMemory);
				containerModel.setTotalMemory(totalMemory);
				containerModel.setUsedMemory(usedMemory);
				
				containerList.add(containerModel);
			}
			
			System.out.println("Container list created successfully");
			return containerList;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error retrieving containers. Exception: "+ e.getMessage());
		}
	}

	public void stop(String containerId) {
		System.out.println("Stopping container:"+ containerId);
		try {
			dockerClient.stopContainer(containerId, 5);
			System.out.println("Container:"+ containerId + " stopped successfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error stopping container"+ containerId +". Exception: "+ e.getMessage());
		}
	}

	public void start(String containerId) {
		System.out.println("Starting container:"+ containerId);
		try {
			dockerClient.startContainer(containerId);
			System.out.println("Container:"+ containerId + " started successfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error starting container"+ containerId +". Exception: "+ e.getMessage());
		}
	}

	public void remove(List<String> containerIds) {
		if (containerIds.size() == 0 ) {
			throw new RuntimeException("Not a valid input. Container ids is null or empty");
		}
		
		for(String containerId:containerIds) {
			System.out.println("Removing container:"+ containerId);
			try {
				dockerClient.removeContainer(containerId);
				System.out.println("Container:"+ containerId + " removed successfully");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("There was an error removing container"+ containerId +". Exception: "+ e.getMessage());
			}
		}
		
	}
	
	private double calculatePercentCPU(ContainerStats stats) {
		long prevCPU = stats.precpuStats().cpuUsage().totalUsage();
		long prevSystem = stats.precpuStats().systemCpuUsage();
		
		double cpuPercent = 0.0;
		//change for the container
		long containerDelta = stats.cpuStats().cpuUsage().totalUsage() - prevCPU;
		//change for the system 
		long systemDelta = stats.cpuStats().systemCpuUsage() - prevSystem;
		
		if (systemDelta > 0 && containerDelta > 0){
			int countCpu = stats.cpuStats().cpuUsage().percpuUsage().size();
			
			cpuPercent = (containerDelta/systemDelta) * countCpu * 100;
		}
		
		return cpuPercent;
	}
}
