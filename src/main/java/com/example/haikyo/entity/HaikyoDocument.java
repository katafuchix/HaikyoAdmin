package com.example.haikyo.entity;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import com.google.cloud.spring.data.firestore.Document;

@Document(collectionName = "haikyo_detail_fear")
public class HaikyoDocument {

	@DocumentId private String DocumentId;
	
	private Long id;
	private String name;
	private Integer haikyo_category_id;
	private String url;
	private String address;
	private String state;
	//private Date created_at;
    @ServerTimestamp
    private Timestamp created_at; 
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getHaikyo_category_id() {
		return haikyo_category_id;
	}
	
	public void setHaikyo_category_id(Integer haikyo_category_id) {
		this.haikyo_category_id = haikyo_category_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
}
