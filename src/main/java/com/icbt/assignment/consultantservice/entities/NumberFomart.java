package com.icbt.assignment.consultantservice.entities;

public class NumberFomart {
	private String table_name;
	private String prefix;
	 
	private int number_Part;

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getNumber_Part() {
		return number_Part;
	}

	public void setNumber_Part(int number_Part) {
		this.number_Part = number_Part;
	}

	 
	public NumberFomart() {
		super();
	}

 
	public NumberFomart(String table_name, String prefix, int number_Part) {
		super();
		this.table_name = table_name;
		this.prefix = prefix;
		this.number_Part = number_Part;
	}

	@Override
	public String toString() {
		return "NumberFomart [table_name=" + table_name + ", prefix=" + prefix + ", number_Part=" + number_Part + "]";
	}
	
	
	
	
	
}
