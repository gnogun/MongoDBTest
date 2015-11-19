package com.latis.test;

import java.util.HashMap;


public class MapReduceObject {

	private String id;
	private HashMap<String, Float> value;

	public String getId() {
		return id;
	}

	public HashMap<String, Float> getValue() {
		return value;
	}

	public void setValue(HashMap<String, Float> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ValueObject [id=" + id + ", value=" + value + "]";
	}
}
