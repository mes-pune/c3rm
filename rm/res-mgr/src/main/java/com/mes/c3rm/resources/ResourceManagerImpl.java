package com.mes.c3rm.resources;

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
		final ContainerConfig containerConfig = ContainerConfig.builder()
			    .hostConfig(hostConfig)
			    .image("busybox")
			    .cmd("sh", "-c", "while :; do sleep 1; done")
			    .build();
		
		dockerClient.createContainer(containerConfig);
		
	}

}
