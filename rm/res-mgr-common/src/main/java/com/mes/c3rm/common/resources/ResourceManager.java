package com.mes.c3rm.common.resources;

import java.util.List;

import com.mes.c3rm.common.model.ContainerModel;

public interface ResourceManager {
	public void createContainer(ContainerModel containerModel);
	public List<ContainerModel> getContainerList();
}
