package com.jacaranda.elementos;

import java.util.Objects;

import com.jacaranda.enumerados.ElementType;

public class Element {

	protected ElementType type;

	//constructor
	public Element(ElementType type) {
		super();
		this.type = type;
	}

	//getter and setter
	public ElementType getType() {
		return type;
	}

	//hashCode And Equals
	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return type == other.type;
	}

	//toString
	@Override
	public String toString() {
		return "Element [type=" + type + "]";
	}
	
	
	
}
