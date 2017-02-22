package com.point.calculator.model;

import java.awt.geom.Point2D;
import java.util.Map;

/**
 * @author Sivaramakrishna
 *
 */
public class Coordinate {

	private String id;
	
	private String value;

	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString()
	{
		return "ID is: "+this.id+" Value is: "+this.value;
	}
	
}
