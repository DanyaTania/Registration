package by.gourianova.binocularvision.controller;

import by.gourianova.binocularvision.controller.command.Command;
import by.gourianova.binocularvision.controller.command.CommandProvider;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "controller", urlPatterns = "/controller")

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String name;
		Command command;
		
		name = request.getParameter("command");
		command = provider.takeCommand(name);
		
		command.execute(request, response);
	}

}
