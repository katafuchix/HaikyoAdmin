package com.example.haikyo.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

@Document(collectionName = "haikyo_category")
public class HaikyoCategoryDocument {

	@DocumentId private String id;
	
	private String color;
	private Integer haikyo_category_id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getHaikyo_category_id() {
		return haikyo_category_id;
	}
	public void setHaikyo_category_id(Integer haikyo_category_id) {
		this.haikyo_category_id = haikyo_category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
