package ru.shome.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import ru.shome.web.services.BaseService;

public class ServiceFactory {
	private static List<BaseService> serviceRegistry = new ArrayList<BaseService>();

	public static void reqisterService(BaseService service) {
		serviceRegistry.add(service);
	}

	public static void runServices() {
		for (BaseService service : serviceRegistry) {
			new Thread(service,service.getClass().getName()).start();
		}
	}
}
