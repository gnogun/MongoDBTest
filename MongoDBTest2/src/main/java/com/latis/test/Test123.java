package com.latis.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Collection 객체
// Filed와 variable들이 대응 된다
@Document(collection="test123")
public class Test123 {
	
	public Test123() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private String id;
	
	private String name;
	
	private String qwe;
	
	private double num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQwe() {
		return qwe;
	}

	public void setQwe(String qwe) {
		this.qwe = qwe;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + id + ", name: " + name + ", qwe: " + qwe + ", num: " + num;
	}

}
