package ru.shome.web.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import ru.shome.web.services.impl.ServiceFactory;

public class SHWDispatcherServlet extends DispatcherServlet{

	public SHWDispatcherServlet(){
		super();
		ServiceFactory.runServices();
	}
	public SHWDispatcherServlet(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
		ServiceFactory.runServices();
	}

}
