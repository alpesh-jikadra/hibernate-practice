package com.demo.pojo;


public class Config {

	private Integer id;
	private String key;
	private String value;
	
	
	
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Config(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Config [id=" + id + ", key=" + key + ", value=" + value + "]";
	}
	
	
	
}
