package net.cxf.ws.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="Book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable{
	
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="auther")
	private String auther;
	@XmlElement(name="id",nillable=true, required=false)
	private int id;
	@XmlElement(name="price",nillable=true, required=false)
	private double price;
	@XmlTransient    //using this annotation this field will excludes from xsd(will not publish as webservice)
	private String publisher;
	@XmlTransient	 //using this annotation this field will excludes from xsd(will not publish as webservice)
	private String publisherId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
