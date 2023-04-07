package com.example.solution.web.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.solution.bo.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class ApplicationInitializer implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ApplicationInitializer() {

	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();


		List<User> userList = Collections.synchronizedList(new ArrayList<User>());

		ctx.setAttribute("users", userList);

	}

}
