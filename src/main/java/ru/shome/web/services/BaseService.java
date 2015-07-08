package ru.shome.web.services;


public abstract class BaseService implements Runnable{

	public BaseService(){
		super();
		System.out.println(this.getClass().getName().toString().concat(" started..."));
	}
	public abstract void run();
}
