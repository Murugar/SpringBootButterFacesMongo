package com.iqmsoft.butterfaces.boot.mongo;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
@SuppressWarnings("all")
public class Admin {

	@Id
	private String id;
	
	private String name;
	
	private String pwd;

	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public Admin() {}

	
	
	public Admin(String name, String pwd) {
		this.pwd = pwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + "]";
	}

}
