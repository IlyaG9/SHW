package ru.shome.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "settings")
public class Setting {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "group_id")
	private Long id;
	
	@Column(name = "identifier",unique = true)
	private String identifier;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "value")
	private SettingValue value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SettingValue getValue() {
		return value;
	}

	public void setValue(SettingValue value) {
		this.value = value;
	}

	
}
