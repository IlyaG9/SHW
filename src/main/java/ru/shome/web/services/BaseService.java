package ru.shome.web.services;


public abstract class BaseService implements Runnable{

	public BaseService(){
		super();
		System.out.println(this.getClass().getName().toString().concat(" started..."));
	}
	public  void run(){
		if(isEnabled()){
			go();
		}
	}
	
	/**
	 * Отвечет за действие сервиса
	 */
	public abstract void go();
	
	/**
	 * Отвечает за доступность сервиса
	 * 
	 * @return
	 */
	public abstract boolean isEnabled();
}
