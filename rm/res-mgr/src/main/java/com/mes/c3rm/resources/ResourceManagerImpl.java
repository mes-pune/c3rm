package com.mes.c3rm.resources;

import java.util.List;

import com.mes.c3rm.common.model.ContainerModel;
import com.mes.c3rm.common.resources.ResourceManager;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.messages.ContainerConfig;

public class ResourceManagerImpl implements ResourceManager{
	private DockerClient dockerClient = null;
	
	public ResourceManagerImpl() {
		try {
			dockerClient = DefaultDockerClient.fromEnv().build();
		} catch (DockerCertificateException e) {
			e.printStackTrace();
		} 
	}
	
	public void createContainer(ContainerModel containerModel) {
		
	}

	public List<ContainerModel> getContainerList() {
		// TODO Auto-generated method stub
		return null;
	}

}
