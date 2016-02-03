package com.mes.c3rm.web.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.c3rm.common.resources.ResourceManager;
import com.mes.c3rm.resources.ResourceManagerImpl;

/**
 * Servlet implementation class ContainerActions
 */
public class ContainerActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContainerActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("action");
		String containerId = request.getParameter("id");
		
		ResourceManager resMgr= new ResourceManagerImpl();
		if (actionName != null) {
			if (actionName.equals("remove")){
				resMgr.remove(Arrays.asList(containerId));
			} else if (actionName.equals("stop")){
				resMgr.stop(containerId);
			} else if (actionName.equals("start")){
				resMgr.start(containerId);
			}
			
			response.sendRedirect("/res-web");
		} else {
			// list containers after action
			request.setAttribute("containers", resMgr.getContainerList());
			RequestDispatcher rd = request.getRequestDispatcher("ListContainer.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
