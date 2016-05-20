package ru.shome.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import ru.shome.web.services.RunnubleService;

public class ServiceFactory {
	private static List<RunnubleService> serviceRegistry = new ArrayList<RunnubleService>();

	public static void reqisterService(RunnubleService service) {
		serviceRegistry.add(service);
	}

	public static void runServices() {
		for (RunnubleService service : serviceRegistry) {
			new Thread(service,service.getClass().getName()).start();
		}
	}
}
