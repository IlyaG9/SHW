package ru.shome.web.beans;

import java.io.Serializable;

public class SettingValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
