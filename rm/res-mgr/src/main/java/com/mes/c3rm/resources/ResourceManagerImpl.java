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

public class ResourceManagerImpl implements ResourceManager{
	private DockerClient dockerClient = null;
	private String host;
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
			// pull image from repo
			dockerClient.pull(containerModel.getImageName());
			
			ContainerConfig config = ContainerConfig.builder().image(containerModel.getImageName()).build();
			ContainerCreation container = dockerClient.createContainer(config, containerModel.getName());
			return container.id();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error creating a container. Exception: "+ e.getMessage());
		}
	}

	public List<ContainerModel> getContainerList() {
		try {
			List<Container> containers = dockerClient.listContainers();
			if (containers.size() == 0) {
				return null;
			}

			List<ContainerModel> containerList = new ArrayList<ContainerModel>();
			for (Container container: containers) {
				ContainerModel containerModel = new ContainerModel();
				containerModel.setImageName(container.image());
				containerModel.setId(container.id());
				containerList.add(containerModel);
			}
			
			return containerList;
			
		} catch (Exception e) {
			throw new RuntimeException("There was an error retrieving containers. Exception: "+ e.getMessage());
		}
	}
}
