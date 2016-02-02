package com.mes.c3rm.resources;

import com.mes.c3rm.common.model.ContainerModel;

public class AppTestMain {

	public static void main(String[] args) {
		ContainerModel containerModel = new ContainerModel();
		containerModel.setImageName("busybox:latest");
		ResourceManagerImpl resourceManger = new ResourceManagerImpl("http://127.0.0.1:2375");
		String containerId = resourceManger.createContainer(containerModel);
		System.out.println("The new container Id: "+ containerId);
		
	}

}
