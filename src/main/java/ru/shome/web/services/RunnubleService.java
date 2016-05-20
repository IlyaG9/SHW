package ru.shome.web.services;

public abstract class RunnubleService implements Runnable {

	public RunnubleService() {
		super();

	}

	public void run() {
		if (isEnabled()) {
			go();
			System.out.println(this.getClass().getName().toString()
					.concat(" started..."));
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
