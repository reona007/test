package model;

import java.io.Serializable;

public class UserBean implements Serializable{

	private String id;
	private String name;
	private String pass;
	private int age;
	public UserBean() {}
	public UserBean(String id,String name,Integer age ) {
		this.id=id;
		this.name =name;
		this.age=age;
	}
	public UserBean(String id, String pass) {
		this.id=id;
		this.pass = pass;
	}
	public UserBean(String id,String pass,String userName,int age) {
		this.id=id;this.pass=pass;this.name=userName;this.age=age;
	}

	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}

	}
