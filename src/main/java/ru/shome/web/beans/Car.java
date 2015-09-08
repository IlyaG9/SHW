package ru.shome.web.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

	@Id
	@Column(name = "car_id")
	private Long id;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "year")
	private String year;

	@Override
	public String toString() {
		return "Car [link=" + link + ", name=" + name + ", price=" + price
				+ ", site=" + site + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}