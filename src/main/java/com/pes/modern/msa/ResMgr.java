package com.pes.modern.msa;

import java.util.List;

public interface ResMgr {
      // public String createContainer();
      // public void startContainer();
      // public void stopContainer();
      // public void displayList();
       public List<ContainerModel> getList();
       public String Execute(String url,String action);
	//public String getContainerName();
	public String createContainer();
	public String Execute1(String url,String action,String Image);

	

}

